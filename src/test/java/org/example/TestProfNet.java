package org.example;

import FlaNium.WinAPI.enums.BasePoint;
import FlaNium.WinAPI.webdriver.DesktopOptions;
import FlaNium.WinAPI.elements.*;
import FlaNium.WinAPI.webdriver.FlaNiumDriver;
import FlaNium.WinAPI.webdriver.FlaNiumDriverService;
import org.junit.Test;
import org.openqa.selenium.By;
import java.io.File;

public class TestProfNet {
    String DRIVER_PATH = "C:\\Users\\AdminTst\\IdeaProjects\\FlatTest\\src\\main\\resources\\FlaNium.Desktop.Driver-v1.6.0/FlaNium.Driver.exe";
    String APP_PATH = "C:\\Program Files\\Google\\Chrome\\Application/chrome.exe";
    int driverPort = 9993;
    FlaNiumDriverService service = new FlaNiumDriverService.Builder()
            .usingDriverExecutable(new File(DRIVER_PATH).getAbsoluteFile())
            .usingPort(driverPort)
            .withVerbose(false)
            .withSilent(false)
            .buildDesktopService();

    @Test
    public void testNet() throws InterruptedException {
        DesktopOptions options = new DesktopOptions();
        options.setApplicationPath(String.valueOf(new File(APP_PATH)));
        options.setLaunchDelay(15);
        options.setDebugConnectToRunningApp(false);
        FlaNiumDriver driver = new FlaNiumDriver(service, options);

//        Button edit = new Button(driver.findElement(By.xpath(" //*[(@Name = 'Адресная строка и строка поиска')] ")));
//        edit.click();

        Thread.sleep(2000);

        driver.findElement(By.xpath(" //*[(@Name = 'Адресная строка и строка поиска')] ")).sendKeys("192.168.100.102:8080");

        Button mouse = new Button(driver.findElement(By.xpath(" //*[(@Name = 'Адресная строка и строка поиска')] ")));
        mouse.mouseClick(BasePoint.CENTER_LEFT, 0, 25);

    }
}
