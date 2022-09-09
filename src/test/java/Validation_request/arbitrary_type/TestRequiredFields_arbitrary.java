package Validation_request.arbitrary_type;

import FlaNium.WinAPI.elements.Button;
import FlaNium.WinAPI.webdriver.DesktopOptions;
import FlaNium.WinAPI.webdriver.FlaNiumDriver;
import Validation_request.InitDriver;
import Validation_request.Request;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import java.io.File;

public class TestRequiredFields_arbitrary extends InitDriver {
    public void test_Required_fields() {
        //init
        DesktopOptions options = new DesktopOptions();
        options.setApplicationPath(String.valueOf(new File(APP_PATH)));
        options.setLaunchDelay(10);
        options.setDebugConnectToRunningApp(true);
        FlaNiumDriver driver = new FlaNiumDriver(service, options);

        Request request = new Request();
        request.closingRequest();
        request.movingToRequestArbitrary();

        Button next = new Button(driver.findElement(By.xpath("//*[(@AutomationId = 'nextbutton')]")));
        next.click();
        driver.findElement(By.xpath("//*[(@HelpText='Обязательное поле')]")).sendKeys("Test");
        next.click();

        try {
            driver.findElement(By.xpath("//*[(@Name='Имя файла')]"));
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.assertAll();
        }

        new Button(driver.findElement(By.xpath("//*[(@AutomationId = 'cancelbutton')]"))).click();
    }
}
