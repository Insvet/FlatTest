package Validation_request;

import Validation_request.validation_arbitrary_type.*;
import org.junit.Test;


public class TestFields {
    static TestVisibleFields test_Visible_fields = new TestVisibleFields();
    static TestRequiredFields test_required_fields = new TestRequiredFields();
    static TestInputPositive test_Input_Positive = new TestInputPositive();
    static TestInputNegative test_Input_Negative = new TestInputNegative();
    static TestInputLongWords test_Input_Long_Words = new TestInputLongWords();

    @Test
    public void Step1(){
        test_Visible_fields.test_Visible_fields();
    }
    @Test
    public void Step2(){
        test_required_fields.test_Required_fields();
    }
    @Test
    public void Step3(){
        test_Input_Positive.testInput();
    }
    @Test
    public void Step4()throws InterruptedException{
        test_Input_Negative.testInputNegative();
    }
    @Test
    public void Step5()throws InterruptedException{
        test_Input_Long_Words.testInputLongWords();
    }
}
