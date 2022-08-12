package Validation_request.validation_arbitrary_type;

import FlaNium.WinAPI.elements.Button;
import FlaNium.WinAPI.elements.TabItem;
import FlaNium.WinAPI.webdriver.DesktopOptions;
import FlaNium.WinAPI.webdriver.FlaNiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.io.File;

public class Test_visible_fields extends InitDriver {
    public void test_Visible_fields() {
        DesktopOptions options = new DesktopOptions();
        options.setApplicationPath(String.valueOf(new File(APP_PATH)));
        options.setLaunchDelay(10);
        options.setDebugConnectToRunningApp(true);
        FlaNiumDriver driver = new FlaNiumDriver(service, options);

        new TabItem(driver.findElement(By.xpath("//ToolBar/Tab/TabItem[3]"))).click();
        new TabItem(driver.findElement(By.xpath("//TabItem/ToolBar/Tab/TabItem[1]"))).click();
        new Button(driver.findElement(By.xpath("//TabItem/TabItem/ToolBar[1]/Button[1]"))).click();
        new Button(driver.findElement(By.xpath("//*[(@AutomationId = 'nextbutton')]"))).click();

        //Проверка полей
        WebElement group = null;
        try { //a[b = 'value1' and b = 'value2']/@id
            group = driver.findElement(By.xpath("//Pane[Text[1][@Name='Фамилия:']" +
                    "and Text[2][@Name='Имя Отчество:'] and Text[3][@Name='Общее имя:'] and Text[4][@Name='Организация:']" +
                    "and Text[5][@Name='Подразделение:']and Text[6][@Name='Должность:'] and Text[7][@Name='Страна:']" +
                    "and Text[8][@Name='Область:'] and Text[9][@Name='Населенный пункт:'] and Text[10][@Name='Адрес:']" +
                    "and Text[11][@Name='Электронная почта:'] and Text[12][@Name='ИНН:'] and Text[13][@Name='СНИЛС:']" +
                    "and Text[14][@Name='ОГРН:']]"));
        }catch (Exception e){
            e.printStackTrace();
        }if (group != null){
            System.out.println("--> SUCCESS! Visible fields checked");
        }else System.out.println("--> ERROR! The visible fields failed validation");

    }

}
