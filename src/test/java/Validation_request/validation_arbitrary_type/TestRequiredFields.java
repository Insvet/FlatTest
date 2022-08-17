package Validation_request.validation_arbitrary_type;

import FlaNium.WinAPI.elements.Button;
import FlaNium.WinAPI.elements.TabItem;
import FlaNium.WinAPI.webdriver.DesktopOptions;
import FlaNium.WinAPI.webdriver.FlaNiumDriver;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.io.File;

public class TestRequiredFields extends InitDriver {
    @Description("Проверка обязательных полей")
    public void test_Required_fields() {
        DesktopOptions options = new DesktopOptions();
        options.setApplicationPath(String.valueOf(new File(APP_PATH)));
        options.setLaunchDelay(10);
        options.setDebugConnectToRunningApp(true);
        FlaNiumDriver driver = new FlaNiumDriver(service, options);

        new TabItem(driver.findElement(By.xpath("//ToolBar/Tab/TabItem[3]"))).click();
        new TabItem(driver.findElement(By.xpath("//TabItem/ToolBar/Tab/TabItem[1]"))).click();
        new Button(driver.findElement(By.xpath("//TabItem/TabItem/ToolBar[1]/Button[1]"))).click();
        Button next = new Button(driver.findElement(By.xpath("//*[(@AutomationId = 'nextbutton')]")));
        next.click();
        driver.findElement(By.xpath("//*[(@HelpText='Обязательное поле')]")).sendKeys("Test");
        next.click();

        WebElement group = null;
        try {
            group = driver.findElement(By.xpath("//*[(@Name='Имя файла')]"));
        }catch (Exception e){
            e.printStackTrace();
        }if (group != null){
            System.out.println("--> SUCCESS! Required fields checked");
        }else System.out.println("--> ERROR! The Required fields failed validation");

        new Button(driver.findElement(By.xpath("//*[(@AutomationId = 'cancelbutton')]"))).click();
    }
}
