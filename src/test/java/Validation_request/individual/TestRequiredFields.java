package Validation_request.individual;

import FlaNium.WinAPI.elements.Button;
import FlaNium.WinAPI.elements.TabItem;
import FlaNium.WinAPI.enums.BasePoint;
import FlaNium.WinAPI.webdriver.DesktopOptions;
import FlaNium.WinAPI.webdriver.FlaNiumDriver;
import Validation_request.InitDriver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import java.io.File;
import static Validation_request.Variables.*;

public class TestRequiredFields extends InitDriver {
    public static void main(String[] args) {
        DesktopOptions options = new DesktopOptions();
        options.setApplicationPath(String.valueOf(new File(APP_PATH)));
        options.setLaunchDelay(10);
        options.setDebugConnectToRunningApp(true);
        FlaNiumDriver driver = new FlaNiumDriver(service, options);

        try {
            driver.findElement(By.xpath("//*[@AutomationId='cancelbutton']")).click();
        } catch (Exception e) {
            e.printStackTrace();
        }

        new TabItem(driver.findElement(By.xpath("//ToolBar/Tab/TabItem[3]"))).click();
        new TabItem(driver.findElement(By.xpath("//TabItem/ToolBar/Tab/TabItem[1]"))).click();
        new Button(driver.findElement(By.xpath("//TabItem/TabItem/ToolBar[1]/Button[1]"))).click();
        Button type = new Button(driver.findElement(By.xpath("/Window/Pane/ComboBox[4]")));
        type.click();
        type.mouseClick(BasePoint.CENTER ,0,25);
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
