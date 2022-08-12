package org.example.steps;

import FlaNium.WinAPI.elements.*;
import FlaNium.WinAPI.enums.BasePoint;
import FlaNium.WinAPI.webdriver.DesktopOptions;
import FlaNium.WinAPI.webdriver.FlaNiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.io.File;

public class TestImport extends InitFlanium {
    public void testImp() throws InterruptedException {
        DesktopOptions options = new DesktopOptions();
        options.setApplicationPath(String.valueOf(new File(APP_PATH)));
        options.setLaunchDelay(10);
        options.setDebugConnectToRunningApp(true);
        FlaNiumDriver driver = new FlaNiumDriver(service, options);

        new TabItem(driver.findElement(By.xpath(" //*[(@Name = 'Настройки')] "))).click();
        new TabItem(driver.findElement(By.xpath(" //*[(@Name = 'Конфигурация')] "))).click();
        new Button(driver.findElement(By.xpath(" //Window/Group/Button[2] "))).click();

        Thread.sleep(1000);

        new TreeItem(driver.findElement(By.xpath(" //*[(@Name = 'Загрузки (закреплено)')] "))).click();
        new Button(driver.findElement(By.xpath(" //*[(@ControlType = 'ListItem')] "))).invoke();

        Thread.sleep(1000);

        new Button(driver.findElement(By.xpath(" //*[(@Name = 'Да')] "))).click();

        Thread.sleep(1000);

        new TreeItem(driver.findElement(By.xpath(" //*[(@Name = 'test8_win11_2 (18-07-2022 17:24:08)')] ")))
                .click();
        new Button(driver.findElement(By.xpath(" //*[(@Name = 'ОК')] "))).click();

        Thread.sleep(1000);

        new Button(driver.findElement(By.xpath(" //Window[2]/TabItem/Group[1]/Button "))).click();
        new Button(driver.findElement(By.xpath(" //Window/Button "))).click();

        //Проверка добавленного сертификата

        new TabItem(driver.findElement(By.xpath(" //ToolBar/Tab/TabItem[3] "))).click();
        new TabItem(driver.findElement(By.xpath(" //TabItem/ToolBar/Tab/TabItem[1] "))).click();
        Button edit = new Button(driver.findElement(By.xpath(" //TabItem/TabItem/ToolBar[1]/Edit ")));
        edit.click();

        driver.findElement(By.xpath(" //TabItem/TabItem/ToolBar[1]/Edit ")).clear();
        driver.findElement(By.xpath(" //TabItem/TabItem/ToolBar[1]/Edit "))
                .sendKeys("test8_win11_2");

        new Button(driver.findElement(By.xpath(" //TabItem/TabItem/Table/Group[1]/Group[1] "))).mouseClick
                (BasePoint.CENTER_BOTTOM, 0, 10);

        WebElement test = null;
        try {
            test = driver.findElement(By.xpath(" //*[(@Name = 'Удалить')] "));
        } catch (Exception e) {
            edit.invoke();
        }
        if (test != null) {
            System.out.print(" --> Cert added");
        } else System.out.println(" --> Cert not added");
    }
}