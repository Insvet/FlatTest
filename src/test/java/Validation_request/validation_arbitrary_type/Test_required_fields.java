package Validation_request.validation_arbitrary_type;

import FlaNium.WinAPI.elements.Button;
import FlaNium.WinAPI.webdriver.DesktopOptions;
import FlaNium.WinAPI.webdriver.FlaNiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.io.File;

public class Test_required_fields extends InitDriver {
    public void test_Required_fields() {
        DesktopOptions options = new DesktopOptions();
        options.setApplicationPath(String.valueOf(new File(APP_PATH)));
        options.setLaunchDelay(10);
        options.setDebugConnectToRunningApp(true);
        FlaNiumDriver driver = new FlaNiumDriver(service, options);

        Button next = new Button(driver.findElement(By.xpath("//Button[2]")));
        next.click();
        driver.findElement(By.xpath("//*[(@HelpText='Обязательное поле')]")).sendKeys("Test");
        next.click();

        //Проверка обязательных полей
        WebElement group = null;
        try {
            group = driver.findElement(By.xpath("//*[(@Name='Имя файла')]"));
        }catch (Exception e){
            e.printStackTrace();
        }if (group != null){
            System.out.println("--> SUCCESS! Required fields checked");
        }else System.out.println("--> ERROR! The Required fields failed validation");
    }

}
