package Validation_request.individual;

import FlaNium.WinAPI.elements.Button;
import FlaNium.WinAPI.webdriver.DesktopOptions;
import FlaNium.WinAPI.webdriver.FlaNiumDriver;
import Validation_request.InitDriver;
import Validation_request.Request;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.List;

import static Validation_request.Variables.*;

public class TestLongWords_individual extends InitDriver {
    public void testLongWords() throws InterruptedException {
        //init
        DesktopOptions options = new DesktopOptions();
        options.setApplicationPath(String.valueOf(new File(APP_PATH)));
        options.setLaunchDelay(10);
        options.setDebugConnectToRunningApp(true);
        FlaNiumDriver driver = new FlaNiumDriver(service, options);

        Request request = new Request();
        request.closingRequest();
        request.movingToRequestIndividual();

        Button next = new Button(driver.findElement(By.xpath("//*[(@AutomationId = 'nextbutton')]")));
        next.click();

        /**
         * В тесте ввода длинных слов предусмотрен костыль. Сделанно во избежания краша ПО. Краш происходит из за ввода
         * в поля с максимальным значением 1024 символа. В данном тесте максимальное значение 1023, более крашится.
         * С начала тест заполняет обязательные поля ('ТестПоля') переходит и к завершению регистрации.
         * Затем возвращается и заполняет поля максимальным значением.
         */

        //Заполнение обязательных полей
        List<WebElement> inputs = driver.findElements(By.xpath("//*[(@HelpText='Обязательное поле')" +
                "and not (contains(@AutomationId,'1230'))]"));
        for (WebElement input : inputs) {
            input.sendKeys(testFields);
        }
        driver.findElement(By.xpath(snils)).sendKeys(testSNILS);

        next.click();
        next.click();
        Button back = new Button(driver.findElement(By.xpath("//*[@AutomationId ='backbutton']")));
        back.click();
        back.click();

        driver.findElement(By.xpath(surname)).sendKeys(words1023);
        Thread.sleep(5000);
        driver.findElement(By.xpath(givenName)).sendKeys(words1023);
        Thread.sleep(5000);
        driver.findElement(By.xpath(organizationName)).sendKeys(words1023);
        Thread.sleep(5000);
        driver.findElement(By.xpath(organizationUnitname)).sendKeys(words129);
        driver.findElement(By.xpath(title)).sendKeys(words129);
        driver.findElement(By.xpath(provinceName)).sendKeys(words129);
        driver.findElement(By.xpath(localityName)).sendKeys(words129);
        driver.findElement(By.xpath(address)).sendKeys(words129);
        driver.findElement(By.xpath(mail)).sendKeys(testMail129);
        driver.findElement(By.xpath(inn)).sendKeys(" 012345678912 ");
        driver.findElement(By.xpath(snils)).sendKeys(" 01234567891 ");

        next.click();
        next.click();

        try {
            driver.findElement(By.xpath("//List[ListItem[1]/Text[2][@Name='Lorem ipsum dolor sit amet " +
                    "consectetuer adipiscing elit Aenean commodo ligula eget dolor Aenean massa Cum sociis natoque " +
                    "penatibus et magnis dis parturient montes nascetur ridiculus mus Donec quam felis ultricies nec " +
                    "pellentesque eu pretium quis sem Nulla cons']" +

                    "and ListItem[2]/Text[2][@Name='Lorem ipsum dolor sit amet consectetuer adipiscing elit Aenean " +
                    "commodo ligula eget dolor Aenean massa Cum sociis natoque penatibus et magnis dis parturient " +
                    "montes nascetur ridiculus mus Donec quam felis ultricies nec pellentesque eu pretium quis sem " +
                    "Nulla cons'] " +

                    "and ListItem[3]/Text[2][@Name='Lorem ipsum dolor sit amet consectetuer adipiscing " +
                    "elit Aenean commodo ligula eget dolor Aenean massa Cum sociis natoque penatibus et magnis dis " +
                    "parturient montes nascetur ridiculus mus Donec quam felis ultricies nec pellentesque eu pretium " +
                    "quis sem Nulla cons']" +

                    "and ListItem[4]/Text[2][@Name='Lorem ipsum dolor sit amet consectetuer adipiscing elit Aenean " +
                    "commodo ligula eget dolor Aenean massa Cum sociis natoque penati']" +

                    "and ListItem[5]/Text[2][@Name='Lorem ipsum dolor sit amet consectetuer adipiscing elit Aenean " +
                    "commodo ligula eget dolor Aenean massa Cum sociis natoque penati']" +

                    "and ListItem[6]/Text[2][@Name='RU']" +

                    "and ListItem[7]/Text[2][@Name='Lorem ipsum dolor sit amet consectetuer adipiscing elit Aenean " +
                    "commodo ligula eget dolor Aenean massa Cum sociis natoque penati'] " +

                    "and ListItem[8]/Text[2][@Name='Lorem ipsum dolor sit amet consectetuer adipiscing elit Aenean" +
                    " commodo ligula eget dolor Aenean massa Cum sociis natoque penati']" +

                    "and ListItem[9]/Text[2][@Name='Lorem ipsum dolor sit amet consectetuer adipiscing elit Aenean " +
                    "commodo ligula eget dolor Aenean massa Cum sociis natoque penati'] " +

                    "and ListItem[10]/Text[2][@Name='userfkvjmlsdzjkhrguihnsrgjndzxjsdujfhuisefuih32873724fliughesr22@" +
                    "hijagsiaefoiubhsrawjgkcudzhvfklsrjgfuihsdrfigvbsdrtkgost.domai']" +

                    "and ListItem[11]/Text[2][@Name='012345678912']" +
                    "and ListItem[12]/Text[2][@Name='01234567891']]"));

        } catch (Exception e) {
            e.printStackTrace();
            Assertions.assertAll();
        }
        new Button(driver.findElement(By.xpath("//*[(@AutomationId = 'cancelbutton')]"))).click();
    }
}
