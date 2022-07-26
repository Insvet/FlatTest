package Validation_request.individual;

import FlaNium.WinAPI.elements.Button;
import FlaNium.WinAPI.webdriver.DesktopOptions;
import FlaNium.WinAPI.webdriver.FlaNiumDriver;
import Validation_request.InitDriver;
import Validation_request.Request;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import java.io.File;

import static Validation_request.Variables.*;

public class TestRequiredFields_individual extends InitDriver {
    public void testRequiredFields() {
        //init
        DesktopOptions options = new DesktopOptions();
        options.setApplicationPath(String.valueOf(new File(APP_PATH)));
        options.setLaunchDelay(10);
        options.setDebugConnectToRunningApp(true);
        FlaNiumDriver driver = new FlaNiumDriver(service, options);

        Request request = new Request();
        request.closingRequest();
        request.movingToRequestIndividual();

        Button next = new Button(driver.findElement(By.xpath("//*[(@AutomationId = 'nextbutton')]")));
        next.click();

        driver.findElement(By.xpath(surname)).sendKeys(testFields);
        next.click();
        driver.findElement(By.xpath(givenName)).sendKeys(testFields);
        next.click();
        driver.findElement(By.xpath(organizationName)).sendKeys(testFields);
        next.click();
        driver.findElement(By.xpath(snils)).sendKeys(testSNILS);
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