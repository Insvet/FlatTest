package Validation_request.validation_arbitrary_type;

import FlaNium.WinAPI.elements.Button;
import FlaNium.WinAPI.webdriver.DesktopOptions;
import FlaNium.WinAPI.webdriver.FlaNiumDriver;
import org.openqa.selenium.By;
import java.io.File;
import static Validation_request.validation_arbitrary_type.Variables.*;


public class TestInputLongWords extends InitDriver {
    public void testInputLongWords() throws InterruptedException {
        DesktopOptions options = new DesktopOptions();
        options.setApplicationPath(String.valueOf(new File(APP_PATH)));
        options.setLaunchDelay(10);
        options.setDebugConnectToRunningApp(true);
        FlaNiumDriver driver = new FlaNiumDriver(service, options);

        driver.findElement(By.xpath(commonName)).sendKeys("test");
        Button next = new Button(driver.findElement(By.xpath("//*[(@AutomationId = 'nextbutton')]")));
        next.click();
        next.click();
        Button back = new Button(driver.findElement(By.xpath("//*[@AutomationId ='backbutton']")));
        back.click();
        back.click();

        driver.findElement(By.xpath(surname)).sendKeys(words1025);
        Thread.sleep(5000);
        driver.findElement(By.xpath(givenName)).sendKeys(words1025);
        Thread.sleep(5000);
        driver.findElement(By.xpath(commonName)).sendKeys(words1025);
        Thread.sleep(5000);
        driver.findElement(By.xpath(organizationName)).sendKeys(words1025);
        Thread.sleep(5000);
        driver.findElement(By.xpath(organizationUnitname)).sendKeys(words129);
        driver.findElement(By.xpath(title)).sendKeys(words129);
        driver.findElement(By.xpath(provinceName)).sendKeys(words129);
        driver.findElement(By.xpath(localityName)).sendKeys(words129);
        driver.findElement(By.xpath(address)).sendKeys(words129);
        driver.findElement(By.xpath(mail)).sendKeys(testmail129);
        driver.findElement(By.xpath(inn)).sendKeys(" 012345678912 ");
        driver.findElement(By.xpath(snils)).sendKeys(" 01234567891 ");
        driver.findElement(By.xpath(ogrn)).sendKeys(" 0123456789123 ");

        next.click();
        next.click();




//word 127
//Lorem ipsum dolor sit amet consectetuer adipiscing elit Aenean commodo ligula eget dolor Aenean massa Cum sociis natoque penati


//        WebElement group = null;
//        try {
//            group = driver.findElement(By.xpath(""));
//        }catch (Exception e){
//            e.printStackTrace();
//        }if (group != null){
//            System.out.println("--> SUCCESS! Field entry passed");
//        }else System.out.println("--> ERROR! Field entry failed");
    }
}
