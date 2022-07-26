package Validation_request.arbitrary_type;

import FlaNium.WinAPI.elements.Button;
import FlaNium.WinAPI.webdriver.DesktopOptions;
import FlaNium.WinAPI.webdriver.FlaNiumDriver;
import Validation_request.InitDriver;
import Validation_request.Request;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.List;

import static Validation_request.Variables.*;

public class TestInputPositive_arbitrary extends InitDriver {
    public void testInput() {
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

        List<WebElement> inputs = driver.findElements(By.xpath("//*[(@ClassName='Edit')" +
                "and not (contains(@AutomationId,'1001')) and not (contains(@AutomationId,'1016'))" +
                "and not (contains(@AutomationId,'1229')) and not (contains(@AutomationId,'1230'))" +
                "and not (contains(@AutomationId,'1231'))]"));
        for (WebElement input : inputs) {
            input.sendKeys(testFields);
        }

        driver.findElement(By.xpath(mail)).sendKeys(testMAIL);
        driver.findElement(By.xpath(inn)).sendKeys(testINN);
        driver.findElement(By.xpath(snils)).sendKeys(testSNILS);
        driver.findElement(By.xpath(ogrn)).sendKeys(testOGRN);

        next.click();
        next.click();

        try {
            driver.findElement(By.xpath("//List[ListItem[1]/Text[2][@Name='ТестПоля']" +
                    "and ListItem[2]/Text[2][@Name='ТестПоля'] and ListItem[3]/Text[2][@Name='ТестПоля']" +
                    "and ListItem[4]/Text[2][@Name='ТестПоля'] and ListItem[5]/Text[2][@Name='ТестПоля']" +
                    "and ListItem[6]/Text[2][@Name='ТестПоля'] and ListItem[7]/Text[2][@Name='RU']" +
                    "and ListItem[8]/Text[2][@Name='ТестПоля'] and ListItem[9]/Text[2][@Name='ТестПоля']" +
                    "and ListItem[10]/Text[2][@Name='ТестПоля'] and ListItem[11]/Text[2][@Name='test@test.test']" +
                    "and ListItem[12]/Text[2][@Name='012345678912'] and ListItem[13]/Text[2][@Name='01234567891']" +
                    "and ListItem[14]/Text[2][@Name='0123456789123']]"));
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.assertAll();
        }
        new Button(driver.findElement(By.xpath("//*[(@AutomationId = 'cancelbutton')]"))).click();
    }
}