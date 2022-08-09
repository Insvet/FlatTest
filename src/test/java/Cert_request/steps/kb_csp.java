package Cert_request.steps;

import FlaNium.WinAPI.elements.*;
import FlaNium.WinAPI.enums.BasePoint;
import FlaNium.WinAPI.webdriver.DesktopOptions;
import FlaNium.WinAPI.webdriver.FlaNiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.io.File;

public class kb_csp extends InitFlaniumCSP{

    public static void main(String[] args){
        DesktopOptions options = new DesktopOptions();
        options.setApplicationPath(String.valueOf(new File(APP_PATH)));
        options.setLaunchDelay(10);
        options.setDebugConnectToRunningApp(true);
        FlaNiumDriver driver = new FlaNiumDriver(service, options);

        TabItem cert = new TabItem(driver.findElement(By.xpath("//ToolBar/Tab/TabItem[3]")));
        cert.click();

        TabItem user = new TabItem(driver.findElement(By.xpath("//TabItem/ToolBar/Tab/TabItem[1]")));
        user.click();

        //Проверка полей
        WebElement group = null;
        try { //a[b = 'value1' and b = 'value2']/@id
            group = driver.findElement(By.xpath("//Group[1][Group[1] and Group[2] and Group[3]]"));
        }catch (Exception e){
            e.printStackTrace();
        }if (group != null){
            System.out.println("--> SUCCESS! Fields checked");
        }else System.out.println("-->ERROR! The fields failed validation");

        Button request = new Button(driver.findElement(By.xpath("//TabItem/TabItem/ToolBar[1]/Button[1]")));
        request.click();

        ComboBox csp = new ComboBox(driver.findElement(By.xpath("//Window/Pane/ComboBox[2]")));
        csp.expand();
        csp.mouseClick(BasePoint.CENTER,0,28);

        Button next = new Button(driver.findElement(By.xpath("//*[(@AutomationId = 'nextbutton')]")));
        next.click();

        driver.findElement(By.xpath("//*[(@AutomationId ='1012')]")).sendKeys("test");
        next.click();
        next.click();

        WebElement name = null;
        try {
            name = driver.findElementByName("Код Безопасности CSP");
        }catch (Exception e){
            e.printStackTrace();
        }if (name != null){
            System.out.println("--> SUCCESS! cryptoprovider - security code found");
        }else System.out.println("--> ERROR! cryptoprovider - the security code not found");

        WebElement base64 = null;
        try {
            base64 = driver.findElementByName("Двоичные данные");
        }catch (Exception e){
            e.printStackTrace();
        }if (base64 != null){
            System.out.println("--> SUCCESS! Only Request 3.x is available");
        }else System.out.println("--> ERROR! Not only the 3.x query is available");

        new Button(driver.findElement(By.xpath("//Window/Button[3]"))).click();

        cert.click();

        user.click();

        request.click();

        ComboBox kb_csp = new ComboBox(driver.findElement(By.xpath("//Window/Pane/ComboBox[1]")));
        kb_csp.expand();
        kb_csp.mouseClick(BasePoint.CENTER,0,28);

        Button next2 = new Button(driver.findElement(By.xpath("//*[(@AutomationId = 'nextbutton')]")));
        next2.click();

        driver.findElement(By.xpath("//*[(@AutomationId ='1012')]")).sendKeys("test");
        next2.click();
        next2.click();

        WebElement cp_csp = null;
        try {
            cp_csp = driver.findElementByName("Сторонний криптопровайдер (ГОСТ Р 34.10-2012)");
        }catch (Exception e){
            e.printStackTrace();
        }if (cp_csp != null){
            System.out.println("--> SUCCESS! cryptoprovider - CryptoPro (GOST R 34.10-2012) found");
        }else System.out.println("--> ERROR! cryptoprovider - the security code not found");

        new Button(driver.findElement(By.xpath("//Window/Button[3]"))).click();

//        cert.click();
//
//        user.click();
//
//        request.click();
//
//        ComboBox kb_csp1 = new ComboBox(driver.findElement(By.xpath("//Window/Pane/ComboBox[1]")));
//        kb_csp1.expand();
//        kb_csp1.mouseClick(BasePoint.CENTER,0,28);
//
//        ComboBox kb_csp2 = new ComboBox(driver.findElement(By.xpath("//Window/Pane/ComboBox[1]")));
//        kb_csp2.expand();
//        kb_csp2.mouseClick(BasePoint.CENTER,0,28);
//
//        next2.click();
//        driver.findElement(By.xpath("//*[(@AutomationId ='1012')]")).sendKeys("test");
//        next2.click();
//        next2.click();

    }    //Push
}
