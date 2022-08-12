package Validation_request;

import Validation_request.validation_arbitrary_type.Test_required_fields;
import Validation_request.validation_arbitrary_type.Test_visible_fields;
import io.qameta.allure.Description;
import org.junit.Test;


public class TestFields {
    static Test_visible_fields step1 = new Test_visible_fields();
    static Test_required_fields step2 = new Test_required_fields();

    @Test
    @Description("Test Allure")
    public void Tests(){
        step1.test_Visible_fields();
        step2.test_Required_fields();
    }
}
