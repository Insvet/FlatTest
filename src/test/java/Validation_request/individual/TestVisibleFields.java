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

public class TestVisibleFields extends InitDriver {
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
        new Button(driver.findElement(By.xpath("//*[(@AutomationId = 'nextbutton')]"))).click();

        try {
            driver.findElement(By.xpath("//Pane[Text[1][@Name='Фамилия:']" +
                    "and Text[2][@Name='Имя Отчество:'] and Text[3][@Name='Организация:']" +
                    "and Text[4][@Name='Подразделение:']" +
                    "and Text[5][@Name='Должность:']and Text[6][@Name='Страна:'] and Text[7][@Name='Область:']" +
                    "and Text[8][@Name='Населенный пункт:'] and Text[9][@Name='Адрес:']" +
                    "and Text[10][@Name='Электронная почта:']" +
                    "and Text[11][@Name='ИНН:'] and Text[12][@Name='СНИЛС:']]"));
        }catch (Exception e) {
            e.printStackTrace();
            Assertions.assertAll();
        }
        new Button(driver.findElement(By.xpath("//*[(@AutomationId = 'cancelbutton')]"))).click();
    }
}
