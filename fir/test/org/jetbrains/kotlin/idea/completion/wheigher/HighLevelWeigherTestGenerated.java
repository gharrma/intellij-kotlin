/*
 * Copyright 2010-2020 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.idea.completion.wheigher;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.JUnit3RunnerWithInners;
import org.jetbrains.kotlin.test.KotlinTestUtils;
import org.jetbrains.kotlin.test.TestMetadata;
import org.jetbrains.kotlin.test.TestRoot;
import org.junit.runner.RunWith;

/*
 * This class is generated by {@link org.jetbrains.kotlin.generators.tests.TestsPackage}.
 * DO NOT MODIFY MANUALLY.
 */
@SuppressWarnings("all")
@TestRoot("fir")
@TestDataPath("$CONTENT_ROOT")
@RunWith(JUnit3RunnerWithInners.class)
@TestMetadata("../completion/testData/weighers/basic")
public class HighLevelWeigherTestGenerated extends AbstractHighLevelWeigherTest {
    private void runTest(String testDataFilePath) throws Exception {
        KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
    }

    @TestMetadata("AfterNullable.kt")
    public void testAfterNullable() throws Exception {
        runTest("../completion/testData/weighers/basic/AfterNullable.kt");
    }

    @TestMetadata("CallableReference_NothingLast.kt")
    public void testCallableReference_NothingLast() throws Exception {
        runTest("../completion/testData/weighers/basic/CallableReference_NothingLast.kt");
    }

    @TestMetadata("Callables.kt")
    public void testCallables() throws Exception {
        runTest("../completion/testData/weighers/basic/Callables.kt");
    }

    @TestMetadata("DelegateToOtherObject.kt")
    public void testDelegateToOtherObject() throws Exception {
        runTest("../completion/testData/weighers/basic/DelegateToOtherObject.kt");
    }

    @TestMetadata("DeprecatedFun.kt")
    public void testDeprecatedFun() throws Exception {
        runTest("../completion/testData/weighers/basic/DeprecatedFun.kt");
    }

    @TestMetadata("DeprecatedJavaClass.kt")
    public void testDeprecatedJavaClass() throws Exception {
        runTest("../completion/testData/weighers/basic/DeprecatedJavaClass.kt");
    }

    @TestMetadata("DeprecatedSinceKotlinFun.kt")
    public void testDeprecatedSinceKotlinFun() throws Exception {
        runTest("../completion/testData/weighers/basic/DeprecatedSinceKotlinFun.kt");
    }

    @TestMetadata("DslCallWithExpectedType.kt")
    public void testDslCallWithExpectedType() throws Exception {
        runTest("../completion/testData/weighers/basic/DslCallWithExpectedType.kt");
    }

    @TestMetadata("DslCalls.kt")
    public void testDslCalls() throws Exception {
        runTest("../completion/testData/weighers/basic/DslCalls.kt");
    }

    @TestMetadata("DslCallsAnnotatedFunctionType.kt")
    public void testDslCallsAnnotatedFunctionType() throws Exception {
        runTest("../completion/testData/weighers/basic/DslCallsAnnotatedFunctionType.kt");
    }

    @TestMetadata("DslCallsWithMultipleReceivers.kt")
    public void testDslCallsWithMultipleReceivers() throws Exception {
        runTest("../completion/testData/weighers/basic/DslCallsWithMultipleReceivers.kt");
    }

    @TestMetadata("DslMemberCalls.kt")
    public void testDslMemberCalls() throws Exception {
        runTest("../completion/testData/weighers/basic/DslMemberCalls.kt");
    }

    @TestMetadata("ExactMatchForKeyword.kt")
    public void testExactMatchForKeyword() throws Exception {
        runTest("../completion/testData/weighers/basic/ExactMatchForKeyword.kt");
    }

    @TestMetadata("ImportedFirst.kt")
    public void testImportedFirst() throws Exception {
        runTest("../completion/testData/weighers/basic/ImportedFirst.kt");
    }

    @TestMetadata("ImportedFirstForJavaClass.kt")
    public void testImportedFirstForJavaClass() throws Exception {
        runTest("../completion/testData/weighers/basic/ImportedFirstForJavaClass.kt");
    }

    @TestMetadata("ImportedOrder.kt")
    public void testImportedOrder() throws Exception {
        runTest("../completion/testData/weighers/basic/ImportedOrder.kt");
    }

    @TestMetadata("KT-25588_1.kts")
    public void testKT_25588_1() throws Exception {
        runTest("../completion/testData/weighers/basic/KT-25588_1.kts");
    }

    @TestMetadata("KT-25588_2.kts")
    public void testKT_25588_2() throws Exception {
        runTest("../completion/testData/weighers/basic/KT-25588_2.kts");
    }

    @TestMetadata("KeywordsLast.kt")
    public void testKeywordsLast() throws Exception {
        runTest("../completion/testData/weighers/basic/KeywordsLast.kt");
    }

    @TestMetadata("LambdaSignature.kt")
    public void testLambdaSignature() throws Exception {
        runTest("../completion/testData/weighers/basic/LambdaSignature.kt");
    }

    @TestMetadata("LocalFileBeforeImported.kt")
    public void testLocalFileBeforeImported() throws Exception {
        runTest("../completion/testData/weighers/basic/LocalFileBeforeImported.kt");
    }

    @TestMetadata("LocalValuesAndParams.kt")
    public void testLocalValuesAndParams() throws Exception {
        runTest("../completion/testData/weighers/basic/LocalValuesAndParams.kt");
    }

    @TestMetadata("LocalsBeforeKeywords.kt")
    public void testLocalsBeforeKeywords() throws Exception {
        runTest("../completion/testData/weighers/basic/LocalsBeforeKeywords.kt");
    }

    @TestMetadata("LocalsPropertiesKeywords.kt")
    public void testLocalsPropertiesKeywords() throws Exception {
        runTest("../completion/testData/weighers/basic/LocalsPropertiesKeywords.kt");
    }

    @TestMetadata("NamedParameters.kt")
    public void testNamedParameters() throws Exception {
        runTest("../completion/testData/weighers/basic/NamedParameters.kt");
    }

    @TestMetadata("NamedParameters2.kt")
    public void testNamedParameters2() throws Exception {
        runTest("../completion/testData/weighers/basic/NamedParameters2.kt");
    }

    @TestMetadata("NamedParameters3.kt")
    public void testNamedParameters3() throws Exception {
        runTest("../completion/testData/weighers/basic/NamedParameters3.kt");
    }

    @TestMetadata("NoExpectedType.kt")
    public void testNoExpectedType() throws Exception {
        runTest("../completion/testData/weighers/basic/NoExpectedType.kt");
    }

    @TestMetadata("NullArgForInfixFunctionOnTheLeft.kt")
    public void testNullArgForInfixFunctionOnTheLeft() throws Exception {
        runTest("../completion/testData/weighers/basic/NullArgForInfixFunctionOnTheLeft.kt");
    }

    @TestMetadata("NullArgForInfixFunctionOnTheRight.kt")
    public void testNullArgForInfixFunctionOnTheRight() throws Exception {
        runTest("../completion/testData/weighers/basic/NullArgForInfixFunctionOnTheRight.kt");
    }

    @TestMetadata("NullArgForNotImportedFunction.kt")
    public void testNullArgForNotImportedFunction() throws Exception {
        runTest("../completion/testData/weighers/basic/NullArgForNotImportedFunction.kt");
    }

    @TestMetadata("NullForIfConditionOnTheLeft.kt")
    public void testNullForIfConditionOnTheLeft() throws Exception {
        runTest("../completion/testData/weighers/basic/NullForIfConditionOnTheLeft.kt");
    }

    @TestMetadata("NullForIfConditionOnTheRight.kt")
    public void testNullForIfConditionOnTheRight() throws Exception {
        runTest("../completion/testData/weighers/basic/NullForIfConditionOnTheRight.kt");
    }

    @TestMetadata("Packages.kt")
    public void testPackages() throws Exception {
        runTest("../completion/testData/weighers/basic/Packages.kt");
    }

    @TestMetadata("ParametersBeforeKeywords.kt")
    public void testParametersBeforeKeywords() throws Exception {
        runTest("../completion/testData/weighers/basic/ParametersBeforeKeywords.kt");
    }

    @TestMetadata("PreferFromJdk.kt")
    public void testPreferFromJdk() throws Exception {
        runTest("../completion/testData/weighers/basic/PreferFromJdk.kt");
    }

    @TestMetadata("PreferGetMethodToProperty.kt")
    public void testPreferGetMethodToProperty() throws Exception {
        runTest("../completion/testData/weighers/basic/PreferGetMethodToProperty.kt");
    }

    @TestMetadata("Prefix.kt")
    public void testPrefix() throws Exception {
        runTest("../completion/testData/weighers/basic/Prefix.kt");
    }

    @TestMetadata("PropertiesBeforeKeywords.kt")
    public void testPropertiesBeforeKeywords() throws Exception {
        runTest("../completion/testData/weighers/basic/PropertiesBeforeKeywords.kt");
    }

    @TestMetadata("StaticMembers.kt")
    public void testStaticMembers() throws Exception {
        runTest("../completion/testData/weighers/basic/StaticMembers.kt");
    }

    @TestMetadata("SuperMembers.kt")
    public void testSuperMembers() throws Exception {
        runTest("../completion/testData/weighers/basic/SuperMembers.kt");
    }

    @TestMetadata("TopLevelKeywordWithClassName.kt")
    public void testTopLevelKeywordWithClassName() throws Exception {
        runTest("../completion/testData/weighers/basic/TopLevelKeywordWithClassName.kt");
    }

    @TestMetadata("UnavailableDslReceiver.kt")
    public void testUnavailableDslReceiver() throws Exception {
        runTest("../completion/testData/weighers/basic/UnavailableDslReceiver.kt");
    }

    @RunWith(JUnit3RunnerWithInners.class)
    @TestMetadata("../completion/testData/weighers/basic/contextualReturn")
    public abstract static class ContextualReturn extends AbstractHighLevelWeigherTest {
        @RunWith(JUnit3RunnerWithInners.class)
        @TestMetadata("../completion/testData/weighers/basic/contextualReturn/noReturnType")
        public static class NoReturnType extends AbstractHighLevelWeigherTest {
            private void runTest(String testDataFilePath) throws Exception {
                KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
            }

            @TestMetadata("BeginOfNestedBlock.kt")
            public void testBeginOfNestedBlock() throws Exception {
                runTest("../completion/testData/weighers/basic/contextualReturn/noReturnType/BeginOfNestedBlock.kt");
            }

            @TestMetadata("BeginOfTopLevelBlock.kt")
            public void testBeginOfTopLevelBlock() throws Exception {
                runTest("../completion/testData/weighers/basic/contextualReturn/noReturnType/BeginOfTopLevelBlock.kt");
            }

            @TestMetadata("EndOfNestedBlock.kt")
            public void testEndOfNestedBlock() throws Exception {
                runTest("../completion/testData/weighers/basic/contextualReturn/noReturnType/EndOfNestedBlock.kt");
            }

            @TestMetadata("EndOfTopLevelBlock.kt")
            public void testEndOfTopLevelBlock() throws Exception {
                runTest("../completion/testData/weighers/basic/contextualReturn/noReturnType/EndOfTopLevelBlock.kt");
            }

            @TestMetadata("ForWithBody.kt")
            public void testForWithBody() throws Exception {
                runTest("../completion/testData/weighers/basic/contextualReturn/noReturnType/ForWithBody.kt");
            }

            @TestMetadata("ForWithoutBody.kt")
            public void testForWithoutBody() throws Exception {
                runTest("../completion/testData/weighers/basic/contextualReturn/noReturnType/ForWithoutBody.kt");
            }

            @TestMetadata("IfWithoutBody.kt")
            public void testIfWithoutBody() throws Exception {
                runTest("../completion/testData/weighers/basic/contextualReturn/noReturnType/IfWithoutBody.kt");
            }

            @TestMetadata("InElvis.kt")
            public void testInElvis() throws Exception {
                runTest("../completion/testData/weighers/basic/contextualReturn/noReturnType/InElvis.kt");
            }

            @TestMetadata("InElvisWhenSmartCompletionWins.kt")
            public void testInElvisWhenSmartCompletionWins() throws Exception {
                runTest("../completion/testData/weighers/basic/contextualReturn/noReturnType/InElvisWhenSmartCompletionWins.kt");
            }

            @TestMetadata("InWhenSingleExpression.kt")
            public void testInWhenSingleExpression() throws Exception {
                runTest("../completion/testData/weighers/basic/contextualReturn/noReturnType/InWhenSingleExpression.kt");
            }

            @TestMetadata("InWhenWithBody.kt")
            public void testInWhenWithBody() throws Exception {
                runTest("../completion/testData/weighers/basic/contextualReturn/noReturnType/InWhenWithBody.kt");
            }
        }

        @RunWith(JUnit3RunnerWithInners.class)
        @TestMetadata("../completion/testData/weighers/basic/contextualReturn/withReturnType")
        public static class WithReturnType extends AbstractHighLevelWeigherTest {
            private void runTest(String testDataFilePath) throws Exception {
                KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
            }

            @TestMetadata("BeginOfNestedBlock.kt")
            public void testBeginOfNestedBlock() throws Exception {
                runTest("../completion/testData/weighers/basic/contextualReturn/withReturnType/BeginOfNestedBlock.kt");
            }

            @TestMetadata("BeginOfTopLevelBlock.kt")
            public void testBeginOfTopLevelBlock() throws Exception {
                runTest("../completion/testData/weighers/basic/contextualReturn/withReturnType/BeginOfTopLevelBlock.kt");
            }

            @TestMetadata("EndOfNestedBlock.kt")
            public void testEndOfNestedBlock() throws Exception {
                runTest("../completion/testData/weighers/basic/contextualReturn/withReturnType/EndOfNestedBlock.kt");
            }

            @TestMetadata("EndOfTopLevelBlock.kt")
            public void testEndOfTopLevelBlock() throws Exception {
                runTest("../completion/testData/weighers/basic/contextualReturn/withReturnType/EndOfTopLevelBlock.kt");
            }

            @TestMetadata("ForWithBody.kt")
            public void testForWithBody() throws Exception {
                runTest("../completion/testData/weighers/basic/contextualReturn/withReturnType/ForWithBody.kt");
            }

            @TestMetadata("ForWithoutBody.kt")
            public void testForWithoutBody() throws Exception {
                runTest("../completion/testData/weighers/basic/contextualReturn/withReturnType/ForWithoutBody.kt");
            }

            @TestMetadata("IfWithoutBody.kt")
            public void testIfWithoutBody() throws Exception {
                runTest("../completion/testData/weighers/basic/contextualReturn/withReturnType/IfWithoutBody.kt");
            }

            @TestMetadata("InElvis.kt")
            public void testInElvis() throws Exception {
                runTest("../completion/testData/weighers/basic/contextualReturn/withReturnType/InElvis.kt");
            }

            @TestMetadata("InElvisInReturn.kt")
            public void testInElvisInReturn() throws Exception {
                runTest("../completion/testData/weighers/basic/contextualReturn/withReturnType/InElvisInReturn.kt");
            }

            @TestMetadata("InElvisWhenSmartCompletionWins.kt")
            public void testInElvisWhenSmartCompletionWins() throws Exception {
                runTest("../completion/testData/weighers/basic/contextualReturn/withReturnType/InElvisWhenSmartCompletionWins.kt");
            }

            @TestMetadata("InIfAsReturnedExpression.kt")
            public void testInIfAsReturnedExpression() throws Exception {
                runTest("../completion/testData/weighers/basic/contextualReturn/withReturnType/InIfAsReturnedExpression.kt");
            }

            @TestMetadata("InIfInWhenWithBodyAsReturnedExpression.kt")
            public void testInIfInWhenWithBodyAsReturnedExpression() throws Exception {
                runTest("../completion/testData/weighers/basic/contextualReturn/withReturnType/InIfInWhenWithBodyAsReturnedExpression.kt");
            }

            @TestMetadata("InNotElvisBinaryOperator.kt")
            public void testInNotElvisBinaryOperator() throws Exception {
                runTest("../completion/testData/weighers/basic/contextualReturn/withReturnType/InNotElvisBinaryOperator.kt");
            }

            @TestMetadata("InWhenAsReturnedExpression.kt")
            public void testInWhenAsReturnedExpression() throws Exception {
                runTest("../completion/testData/weighers/basic/contextualReturn/withReturnType/InWhenAsReturnedExpression.kt");
            }

            @TestMetadata("InWhenSingleExpression.kt")
            public void testInWhenSingleExpression() throws Exception {
                runTest("../completion/testData/weighers/basic/contextualReturn/withReturnType/InWhenSingleExpression.kt");
            }

            @TestMetadata("InWhenWithBody.kt")
            public void testInWhenWithBody() throws Exception {
                runTest("../completion/testData/weighers/basic/contextualReturn/withReturnType/InWhenWithBody.kt");
            }

            @TestMetadata("InWhenWithBodyAsReturnedExpression.kt")
            public void testInWhenWithBodyAsReturnedExpression() throws Exception {
                runTest("../completion/testData/weighers/basic/contextualReturn/withReturnType/InWhenWithBodyAsReturnedExpression.kt");
            }
        }
    }

    @RunWith(JUnit3RunnerWithInners.class)
    @TestMetadata("../completion/testData/weighers/basic/expectedInfo")
    public static class ExpectedInfo extends AbstractHighLevelWeigherTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
        }

        @TestMetadata("AfterAs.kt")
        public void testAfterAs() throws Exception {
            runTest("../completion/testData/weighers/basic/expectedInfo/AfterAs.kt");
        }

        @TestMetadata("CompanionObjectMethod.kt")
        public void testCompanionObjectMethod() throws Exception {
            runTest("../completion/testData/weighers/basic/expectedInfo/CompanionObjectMethod.kt");
        }

        @TestMetadata("EnumEntries.kt")
        public void testEnumEntries() throws Exception {
            runTest("../completion/testData/weighers/basic/expectedInfo/EnumEntries.kt");
        }

        @TestMetadata("ExpectedType.kt")
        public void testExpectedType() throws Exception {
            runTest("../completion/testData/weighers/basic/expectedInfo/ExpectedType.kt");
        }

        @TestMetadata("ExpectedType2.kt")
        public void testExpectedType2() throws Exception {
            runTest("../completion/testData/weighers/basic/expectedInfo/ExpectedType2.kt");
        }

        @TestMetadata("LambdaValue.kt")
        public void testLambdaValue() throws Exception {
            runTest("../completion/testData/weighers/basic/expectedInfo/LambdaValue.kt");
        }

        @TestMetadata("MultiArgsItem.kt")
        public void testMultiArgsItem() throws Exception {
            runTest("../completion/testData/weighers/basic/expectedInfo/MultiArgsItem.kt");
        }

        @TestMetadata("NameSimilarity.kt")
        public void testNameSimilarity() throws Exception {
            runTest("../completion/testData/weighers/basic/expectedInfo/NameSimilarity.kt");
        }

        @TestMetadata("NameSimilarityAndNoExpectedType.kt")
        public void testNameSimilarityAndNoExpectedType() throws Exception {
            runTest("../completion/testData/weighers/basic/expectedInfo/NameSimilarityAndNoExpectedType.kt");
        }

        @TestMetadata("NameSimilarityAndNoExpectedType2.kt")
        public void testNameSimilarityAndNoExpectedType2() throws Exception {
            runTest("../completion/testData/weighers/basic/expectedInfo/NameSimilarityAndNoExpectedType2.kt");
        }

        @TestMetadata("NoStupidComparison.kt")
        public void testNoStupidComparison() throws Exception {
            runTest("../completion/testData/weighers/basic/expectedInfo/NoStupidComparison.kt");
        }

        @TestMetadata("Null.kt")
        public void testNull() throws Exception {
            runTest("../completion/testData/weighers/basic/expectedInfo/Null.kt");
        }

        @TestMetadata("PreferMatchingThis.kt")
        public void testPreferMatchingThis() throws Exception {
            runTest("../completion/testData/weighers/basic/expectedInfo/PreferMatchingThis.kt");
        }

        @TestMetadata("TrueFalse.kt")
        public void testTrueFalse() throws Exception {
            runTest("../completion/testData/weighers/basic/expectedInfo/TrueFalse.kt");
        }

        @TestMetadata("WhenByEnum.kt")
        public void testWhenByEnum() throws Exception {
            runTest("../completion/testData/weighers/basic/expectedInfo/WhenByEnum.kt");
        }
    }

    @RunWith(JUnit3RunnerWithInners.class)
    @TestMetadata("../completion/testData/weighers/basic/expectedType")
    public static class ExpectedType extends AbstractHighLevelWeigherTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
        }

        @TestMetadata("ifConditionQualified.kt")
        public void testIfConditionQualified() throws Exception {
            runTest("../completion/testData/weighers/basic/expectedType/ifConditionQualified.kt");
        }

        @TestMetadata("returnFromFunction.kt")
        public void testReturnFromFunction() throws Exception {
            runTest("../completion/testData/weighers/basic/expectedType/returnFromFunction.kt");
        }

        @TestMetadata("returnFromFunctionQualifiedSelector.kt")
        public void testReturnFromFunctionQualifiedSelector() throws Exception {
            runTest("../completion/testData/weighers/basic/expectedType/returnFromFunctionQualifiedSelector.kt");
        }

        @TestMetadata("returnFromLambda.kt")
        public void testReturnFromLambda() throws Exception {
            runTest("../completion/testData/weighers/basic/expectedType/returnFromLambda.kt");
        }

        @TestMetadata("whileConditionQualified.kt")
        public void testWhileConditionQualified() throws Exception {
            runTest("../completion/testData/weighers/basic/expectedType/whileConditionQualified.kt");
        }
    }

    @RunWith(JUnit3RunnerWithInners.class)
    @TestMetadata("../completion/testData/weighers/basic/parameterNameAndType")
    public static class ParameterNameAndType extends AbstractHighLevelWeigherTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
        }

        @TestMetadata("Deprecated.kt")
        public void testDeprecated() throws Exception {
            runTest("../completion/testData/weighers/basic/parameterNameAndType/Deprecated.kt");
        }

        @TestMetadata("FromCurrentFilePriority.kt")
        public void testFromCurrentFilePriority() throws Exception {
            runTest("../completion/testData/weighers/basic/parameterNameAndType/FromCurrentFilePriority.kt");
        }

        @TestMetadata("ImportedFirst.kt")
        public void testImportedFirst() throws Exception {
            runTest("../completion/testData/weighers/basic/parameterNameAndType/ImportedFirst.kt");
        }

        @TestMetadata("MoreWordsMatchFirst.kt")
        public void testMoreWordsMatchFirst() throws Exception {
            runTest("../completion/testData/weighers/basic/parameterNameAndType/MoreWordsMatchFirst.kt");
        }

        @TestMetadata("ShorterFirst.kt")
        public void testShorterFirst() throws Exception {
            runTest("../completion/testData/weighers/basic/parameterNameAndType/ShorterFirst.kt");
        }

        @TestMetadata("StartMatchFirst.kt")
        public void testStartMatchFirst() throws Exception {
            runTest("../completion/testData/weighers/basic/parameterNameAndType/StartMatchFirst.kt");
        }

        @TestMetadata("UserPrefix.kt")
        public void testUserPrefix() throws Exception {
            runTest("../completion/testData/weighers/basic/parameterNameAndType/UserPrefix.kt");
        }
    }
}
