package Validation_request.validation_arbitrary_type;

import FlaNium.WinAPI.elements.Button;
import FlaNium.WinAPI.webdriver.DesktopOptions;
import FlaNium.WinAPI.webdriver.FlaNiumDriver;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.io.File;
import static Validation_request.validation_arbitrary_type.Variables.*;

public class TestInputPositive extends InitDriver{
    @Description("Проверка заполения полей(Позитив)")
    public void testInput(){
        DesktopOptions options = new DesktopOptions();
        options.setApplicationPath(String.valueOf(new File(APP_PATH)));
        options.setLaunchDelay(10);
        options.setDebugConnectToRunningApp(true);
        FlaNiumDriver driver = new FlaNiumDriver(service, options);

        new Button(driver.findElement(By.xpath("//Window/Button[1]"))).click();

        driver.findElement(By.xpath(surname)).sendKeys("ТестФамилия");
        driver.findElement(By.xpath(givenName)).sendKeys("ТестОтчество");
        driver.findElement(By.xpath(commonName)).sendKeys("ТестОбщееИмя");
        driver.findElement(By.xpath(organizationName)).sendKeys("ТестОрганизация");
        driver.findElement(By.xpath(organizationUnitname)).sendKeys("ТестПодразделение");
        driver.findElement(By.xpath(title)).sendKeys("ТестДолжность");
        driver.findElement(By.xpath(provinceName)).sendKeys("ТестОбласть");
        driver.findElement(By.xpath(localityName)).sendKeys("ТестНаселенныйПункт");
        driver.findElement(By.xpath(address)).sendKeys("ТестАдрес");
        driver.findElement(By.xpath(mail)).sendKeys("test@test.test");
        driver.findElement(By.xpath(inn)).sendKeys("012345678912");
        driver.findElement(By.xpath(snils)).sendKeys("01234567891");
        driver.findElement(By.xpath(ogrn)).sendKeys("0123456789123");

        Button next = new Button(driver.findElement(By.xpath("//*[(@AutomationId = 'nextbutton')]")));
        next.click();
        next.click();

        WebElement group = null;
        try {
            group = driver.findElement(By.xpath("//List[ListItem[1]/Text[2][@Name='ТестФамилия']" +
                    "and ListItem[2]/Text[2][@Name='ТестОтчество'] and ListItem[3]/Text[2][@Name='ТестОбщееИмя']" +
                    "and ListItem[4]/Text[2][@Name='ТестОрганизация'] and ListItem[5]/Text[2][@Name='ТестПодразделение']" +
                    "and ListItem[6]/Text[2][@Name='ТестДолжность'] and ListItem[7]/Text[2][@Name='RU']" +
                    "and ListItem[8]/Text[2][@Name='ТестОбласть'] and ListItem[9]/Text[2][@Name='ТестНаселенныйПункт']" +
                    "and ListItem[10]/Text[2][@Name='ТестАдрес'] and ListItem[11]/Text[2][@Name='test@test.test']" +
                    "and ListItem[12]/Text[2][@Name='012345678912'] and ListItem[13]/Text[2][@Name='01234567891']" +
                    "and ListItem[14]/Text[2][@Name='0123456789123']]"));
        }catch (Exception e){
            e.printStackTrace();
        }if (group != null){
            System.out.println("--> SUCCESS! Field entry passed");
        }else System.out.println("--> ERROR! Field entry failed");

        new Button(driver.findElement(By.xpath("//*[(@AutomationId = 'cancelbutton')]"))).click();
    }
}
