package org.example.steps;

import FlaNium.WinAPI.elements.*;
import FlaNium.WinAPI.enums.BasePoint;
import FlaNium.WinAPI.webdriver.DesktopOptions;
import FlaNium.WinAPI.webdriver.FlaNiumDriver;
import org.openqa.selenium.By;

import java.io.File;

public class TestProfile extends InitFlanium {

    public void profile(){
        DesktopOptions options = new DesktopOptions();
        options.setApplicationPath(String.valueOf(new File(APP_PATH)));
        options.setLaunchDelay(10);
        options.setDebugConnectToRunningApp(true);
        FlaNiumDriver driver = new FlaNiumDriver(service, options);

        TabItem profile = new TabItem(driver.findElement(By.xpath(" //*[(@Name = 'Профили')] ")));
        profile.click();

        Button add = new Button(driver.findElement(By.xpath("//TabItem/ToolBar/Button[3]")));
        add.click();

        CheckBox checkBox = new CheckBox(driver.findElement(By.xpath(" //Window/Group/TabItem/CheckBox[1] ")));
        checkBox.toggle();

        Button field = new Button(driver.findElement(By.xpath(" //TabItem/ToolBar/Button[3]")));
        field.invoke();

        driver.findElement(By.xpath("Window/Group/TabItem/Edit")).sendKeys("java_test");

        ComboBox cert = new ComboBox(driver.findElement(By.xpath("//Window/Group/TabItem/ComboBox[3]")));
        cert.click();
        cert.mouseClick(BasePoint.CENTER_BOTTOM, 0, 10);

        Button ip = new Button(driver.findElement(By.xpath("Window/Group/TabItem/ToolBar[2]/Button[1]")));
        ip.click();

        driver.findElement(By.xpath("Window[2]/Group/TabItem/Edit[1]")).sendKeys("172.17.117.117");

        Button select = new Button(driver.findElement(By.xpath("//Window[2]/Group/TabItem/ToolBar/Button[1]")));
        select.click();

        Button save = new Button(driver.findElement(By.xpath("//Window/Group/TabItem/ToolBar[1]/Button[1]")));
        save.click();

        Button choose = new Button(driver.findElement(By.xpath(" //TabItem/Table/Group[1]")));
        choose.mouseClick(BasePoint.TOP_LEFT, 100, 80);

        Button connect = new Button(driver.findElement(By.xpath(" //TabItem/ToolBar/Button[1]")));
        connect.click();

/*
        //Проверка подключения

        Runtime runtime = Runtime.getRuntime();
        Process process;


        try {
            process = runtime.exec("ping 192.168.100.101");
            InputStream is = process.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String line;
            StringBuffer sb = new StringBuffer();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            System.out.println(sb);

            is.close();
            isr.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
*/
    }
}