package Validation_request;

import FlaNium.WinAPI.elements.Button;
import FlaNium.WinAPI.elements.TabItem;
import FlaNium.WinAPI.enums.BasePoint;
import FlaNium.WinAPI.webdriver.DesktopOptions;
import FlaNium.WinAPI.webdriver.FlaNiumDriver;
import org.openqa.selenium.By;

import java.io.File;

public class Request extends InitDriver {
    public void closingRequest() {
        //init
        DesktopOptions options = new DesktopOptions();
        options.setApplicationPath(String.valueOf(new File(APP_PATH)));
        options.setLaunchDelay(10);
        options.setDebugConnectToRunningApp(true);
        FlaNiumDriver driver = new FlaNiumDriver(service, options);
        //Закрытие окна запроса, если предыдущие тест крашнулся
        try {
            driver.findElement(By.xpath("//*[@AutomationId='cancelbutton']")).click();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void movingToRequestArbitrary() {
        //init
        DesktopOptions options = new DesktopOptions();
        options.setApplicationPath(String.valueOf(new File(APP_PATH)));
        options.setLaunchDelay(10);
        options.setDebugConnectToRunningApp(true);
        FlaNiumDriver driver = new FlaNiumDriver(service, options);
        //Переход к запросу
        new TabItem(driver.findElement(By.xpath("//ToolBar/Tab/TabItem[3]"))).click();
        new TabItem(driver.findElement(By.xpath("//TabItem/ToolBar/Tab/TabItem[1]"))).click();
        new Button(driver.findElement(By.xpath("//TabItem/TabItem/ToolBar[1]/Button[1]"))).click();
    }

    public void movingToRequestIndividual() {
        //init
        DesktopOptions options = new DesktopOptions();
        options.setApplicationPath(String.valueOf(new File(APP_PATH)));
        options.setLaunchDelay(10);
        options.setDebugConnectToRunningApp(true);
        FlaNiumDriver driver = new FlaNiumDriver(service, options);
        //Переход к запросу
        new TabItem(driver.findElement(By.xpath("//ToolBar/Tab/TabItem[3]"))).click();
        new TabItem(driver.findElement(By.xpath("//TabItem/ToolBar/Tab/TabItem[1]"))).click();
        new Button(driver.findElement(By.xpath("//TabItem/TabItem/ToolBar[1]/Button[1]"))).click();
        Button type = new Button(driver.findElement(By.xpath("/Window/Pane/ComboBox[4]")));
        type.click();
        type.mouseClick(BasePoint.CENTER, 0, 25);
    }
}
