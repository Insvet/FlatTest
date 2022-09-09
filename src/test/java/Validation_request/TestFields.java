package Validation_request;

import Validation_request.arbitrary_type.*;
import Validation_request.individual.*;
import io.qameta.allure.Description;
import org.junit.Test;


public class TestFields {
    static TestVisibleFields_arbitrary test_Visible_fields = new TestVisibleFields_arbitrary();
    static TestRequiredFields_arbitrary test_required_fields = new TestRequiredFields_arbitrary();
    static TestInputPositive_arbitrary test_Input_Positive = new TestInputPositive_arbitrary();
    static TestInputNegative_arbitrary test_Input_Negative = new TestInputNegative_arbitrary();
    static TestLongWords_arbitrary test_Input_Long_Words = new TestLongWords_arbitrary();
    //individual
    static TestVisibleFields_individual testVisibleFields = new TestVisibleFields_individual();
    static TestRequiredFields_individual testRequiredFields = new TestRequiredFields_individual();
    static TestInputPositive_individual testInputPositive = new TestInputPositive_individual();
    static TestInputNegative_individual testInputNegative = new TestInputNegative_individual();
    static TestLongWords_individual testLongWords = new TestLongWords_individual();

    @Test
    @Description("test")
    public void Step1() {
        test_Visible_fields.test_Visible_fields();
    }

    @Test
    public void Step2() {
        test_required_fields.test_Required_fields();
    }

    @Test
    public void Step3() {
        test_Input_Positive.testInput();
    }

    @Test
    public void Step4() throws InterruptedException {
        test_Input_Negative.testInputNegative();
    }

    @Test
    public void Step5() throws InterruptedException {
        test_Input_Long_Words.testInputLongWords();
    }

    @Test
    public void Step6() {
        testVisibleFields.testVisibleFields();
    }

    @Test
    public void Step7() {
        testRequiredFields.testRequiredFields();
    }

    @Test
    public void Step8() {
        testInputPositive.testInputPositive();
    }

    @Test
    public void Step9() throws InterruptedException {
        testInputNegative.testInputNegative();
    }

    @Test
    public void Step10() throws InterruptedException {
        testLongWords.testLongWords();
    }
}
