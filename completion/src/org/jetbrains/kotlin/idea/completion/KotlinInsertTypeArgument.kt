package org.jetbrains.kotlin.idea.completion

import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Key
import com.intellij.openapi.util.UserDataHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import org.jetbrains.kotlin.descriptors.CallableDescriptor
import org.jetbrains.kotlin.descriptors.TypeParameterDescriptor
import org.jetbrains.kotlin.descriptors.ValueParameterDescriptor
import org.jetbrains.kotlin.idea.FrontendInternals
import org.jetbrains.kotlin.idea.caches.resolve.analyze
import org.jetbrains.kotlin.idea.caches.resolve.getResolutionFacade
import org.jetbrains.kotlin.idea.core.OptionalParametersHelper
import org.jetbrains.kotlin.idea.inspections.collections.isFunctionOfAnyKind
import org.jetbrains.kotlin.idea.intentions.InsertExplicitTypeArgumentsIntention
import org.jetbrains.kotlin.idea.quickfix.createFromUsage.callableBuilder.contains
import org.jetbrains.kotlin.idea.resolve.frontendService
import org.jetbrains.kotlin.psi.*
import org.jetbrains.kotlin.psi.psiUtil.getChildOfType
import org.jetbrains.kotlin.psi.psiUtil.getQualifiedExpressionForSelector
import org.jetbrains.kotlin.resolve.BindingContext
import org.jetbrains.kotlin.resolve.calls.callUtil.getResolvedCall
import org.jetbrains.kotlin.resolve.calls.model.DefaultValueArgument
import org.jetbrains.kotlin.resolve.calls.model.ResolvedCall
import org.jetbrains.kotlin.resolve.lazy.BodyResolveMode
import org.jetbrains.kotlin.resolve.sam.SamConversionOracle
import org.jetbrains.kotlin.types.KotlinType

data class TypeArgsWithOffset(val args: KtTypeArgumentList, val offset: Int)
var UserDataHolder.argList: TypeArgsWithOffset? by UserDataProperty(Key("KotlinInsertTypeArgument.ARG_LIST"))

fun addParamTypesIfNeeded(position: PsiElement): PsiElement {
    if (!callExprToUpdateExists(position)) return position
    return addParamTypes(position)
}

private fun addParamTypes(position: PsiElement): PsiElement {

    data class CallAndDiff(
        // callExpression is a child node of dotExprWithoutCaret in general case (in simple case they are equal)
        val callExpression: KtCallExpression,  // like call()
        val dotExprWithoutCaret: KtExpression, // like smth.call()
        val dotExprWithCaret: KtQualifiedExpression // initial expression like smth.call().IntellijIdeaRulezzz (now separate synthetic tree)
    )

    fun getCallWithParamTypesToAdd(positionInCopy: PsiElement): CallAndDiff? {
        /*
        ............KtDotQualifiedExpression [call().IntellijIdeaRulezzz]
        ...............KtCallExpression [call()]
        ............................................................
        ...............KtNameReferenceExpression [IntellijIdeaRulezzz]
        ..................LeafPsiElement [IntellijIdeaRulezzz] (*) <= positionInCopy

        Replacing KtQualifiedExpression with its nested KtCallExpression we're getting "non-broken" tree.
        */

        val dotExprWithCaret = positionInCopy.parent.parent as? KtQualifiedExpression ?: return null
        val dotExprWithCaretCopy = dotExprWithCaret.copy() as KtQualifiedExpression

        val beforeDotExpr = dotExprWithCaret.receiverExpression // smth.call()
        val dotExpressionWithoutCaret = dotExprWithCaret.replace(beforeDotExpr) as KtExpression // dotExprWithCaret = beforeDotExpr + '.[?]' + caret
        val targetCall = dotExpressionWithoutCaret.findLastCallExpression() ?: return null // call()

        return CallAndDiff(targetCall, dotExpressionWithoutCaret, dotExprWithCaretCopy)
    }

    fun applyTypeArguments(callAndDiff: CallAndDiff, bindingContext: BindingContext): Pair<KtTypeArgumentList, PsiElement>? {
        val (callExpression, dotExprWithoutCaret, dotExprWithCaret) = callAndDiff

        // KtCallExpression [call()]
        InsertExplicitTypeArgumentsIntention.applyTo(callExpression, false) // affects dotExprWithoutCaret as a parent
        // KtCallExpression [call<TypeA, TypeB>()]

        val dotExprWithoutCaretCopy = dotExprWithoutCaret.copy() as KtExpression

        // Now we're restoring original smth.call().IntellijIdeaRulezzz on its place and
        // replace call() with call<TypeA, TypeB>().

        // smth.call() -> smth.call().IntellijIdeaRulezzz
        val originalDotExpr = dotExprWithoutCaret.replace(dotExprWithCaret) as KtQualifiedExpression
        val originalNestedDotExpr = originalDotExpr.receiverExpression // smth.call()
        originalNestedDotExpr.replace(dotExprWithoutCaretCopy) // smth.call() -> smth.call<TypeA, TYpeB>

        // IntellijIdeaRulezzz as before
        val newPosition = (originalDotExpr.selectorExpression as? KtNameReferenceExpression)?.getReferencedNameElement() ?: return null
        val typeArguments = InsertExplicitTypeArgumentsIntention.createTypeArguments(callExpression, bindingContext) ?: return null

        return typeArguments to newPosition
    }

    val fileCopy = position.containingFile.copy() as KtFile
    val positionInCopy = PsiTreeUtil.findSameElementInCopy(position, fileCopy)
    val callAndDiff = getCallWithParamTypesToAdd(positionInCopy) ?: return position
    val (callExpression, dotExprWithoutCaret, _) = callAndDiff

    val bindingContext = fileCopy.getResolutionFacade().analyze(dotExprWithoutCaret, BodyResolveMode.PARTIAL_FOR_COMPLETION)

    if (!InsertExplicitTypeArgumentsIntention.isApplicableTo(callExpression, bindingContext))
        return position

    val exprOffset = callExpression.textOffset // applyTypeArguments modifies PSI, offset is to be calculated before
    val (typeArguments, newPosition) = applyTypeArguments(callAndDiff, bindingContext) ?: return position

    return newPosition.also { it.argList = TypeArgsWithOffset(typeArguments, exprOffset) }
}

private fun callExprToUpdateExists(position: PsiElement): Boolean {
    /*
     Case: call().IntellijIdeaRulezzz or call()?.IntellijIdeaRulezzz or smth.call()?.IntellijIdeaRulezzz
     'position' points to the caret - IntellijIdeaRulezzz and on PSI level it looks as follows:
     ............KtDotQualifiedExpression [call().IntellijIdeaRulezzz]
     ..............KtCallExpression [call()]
     .............................................................
     ..............KtNameReferenceExpression [IntellijIdeaRulezzz]
     ..................LeafPsiElement [IntellijIdeaRulezzz] (*)
     */
    val afterDotExprWithCaret = position.parent as? KtNameReferenceExpression ?: return false
    val callBeforeDot = afterDotExprWithCaret.getPreviousInQualifiedChain() as? KtCallExpression ?: return false
    return callBeforeDot.requiresTypeParams()
}

@OptIn(FrontendInternals::class)
private fun KtCallExpression.requiresTypeParams(): Boolean {
    if (typeArguments.isNotEmpty()) return false

    val resolutionFacade = getResolutionFacade()
    val bindingContext = analyze(BodyResolveMode.PARTIAL)
    val resolvedCall = getResolvedCall(bindingContext) ?: return false
    if (resolvedCall.typeArguments.isEmpty()) return false

    val samConversionOracle = resolutionFacade.frontendService<SamConversionOracle>()
    return !typeParametersCanBeInferred(project, samConversionOracle, resolvedCall)
}

@OptIn(ExperimentalStdlibApi::class)
private fun typeParametersCanBeInferred(
    project: Project,
    samConversionOracle: SamConversionOracle,
    resolvedCall: ResolvedCall<out CallableDescriptor>
): Boolean {
    fun typeParameterIsProbablyInferrable(desc: ValueParameterDescriptor): Boolean {
        val valueArgument = resolvedCall.valueArguments[desc]
        if (!desc.type.isFunctionOrFunctionalInterface(samConversionOracle)) {
            return valueArgument !is DefaultValueArgument
        }

        if (valueArgument is DefaultValueArgument) {
            val defaultValue = OptionalParametersHelper.defaultParameterValueExpression(desc, project)
            return defaultValue !is KtLambdaExpression
        }

        return valueArgument?.arguments?.none { (it as KtValueArgument).isLambdaArgument() } == true
    }

    fun typeParameterPresentInTypes(inferenceRelevantTypes: List<KotlinType>, typeParamDesc: TypeParameterDescriptor): Boolean =
        inferenceRelevantTypes.any { typeParamDesc in it }


    val typeParamDescriptors = resolvedCall.typeArguments.keys

    val inferenceRelevantTypes = buildList {
        resolvedCall.valueArguments.keys // valueArguments is aware of default values as well
            .filter(::typeParameterIsProbablyInferrable)
            .mapTo(this) { resolvedCall.candidateDescriptor.valueParameters[it.index].type }

        val extensionReceiverParamType = resolvedCall.candidateDescriptor.extensionReceiverParameter?.type
        extensionReceiverParamType?.let { add(it) }
    }

    return typeParamDescriptors.all { typeParameterPresentInTypes(inferenceRelevantTypes, it) }
}

private fun KotlinType.isFunctionOrFunctionalInterface(samConversion: SamConversionOracle): Boolean =
    isFunctionOfAnyKind() || samConversion.isPossibleSamType(this)

private fun KtValueArgument.isLambdaArgument(): Boolean {
    val itsTrailingLambda = this is KtLambdaArgument
    val itsLambdaInParenthesis = getChildOfType<KtLambdaExpression>() != null
    return itsTrailingLambda || itsLambdaInParenthesis
}

private fun KtExpression.getPreviousInQualifiedChain(): KtExpression? {
    val receiverExpression = getQualifiedExpressionForSelector()?.receiverExpression
    return (receiverExpression as? KtQualifiedExpression)?.selectorExpression ?: receiverExpression
}

private fun KtExpression.findLastCallExpression() =
    ((this as? KtQualifiedExpression)?.selectorExpression ?: this) as? KtCallExpression
