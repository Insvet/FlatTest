package org.example.steps;

import FlaNium.WinAPI.enums.BasePoint;
import FlaNium.WinAPI.webdriver.DesktopOptions;
import FlaNium.WinAPI.elements.*;
import FlaNium.WinAPI.webdriver.FlaNiumDriver;
import org.openqa.selenium.By;
import java.io.File;

public class TestProfNet extends InitFlanium{
    String APP_PATH = "C:\\Program Files\\Google\\Chrome\\Application/chrome.exe";

    public void testNet() throws InterruptedException {
        DesktopOptions options = new DesktopOptions();
        options.setApplicationPath(String.valueOf(new File(APP_PATH)));
        options.setLaunchDelay(15);
        options.setDebugConnectToRunningApp(false);
        FlaNiumDriver driver = new FlaNiumDriver(service, options);

        Thread.sleep(2000);

        driver.findElement(By.xpath(" //*[(@Name = 'Адресная строка и строка поиска')] ")).sendKeys("192.168.100.102:8080");

        Button mouse = new Button(driver.findElement(By.xpath(" //*[(@Name = 'Адресная строка и строка поиска')] ")));
        mouse.mouseClick(BasePoint.CENTER_LEFT, 0, 25);

    }
}
