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

public class TestInputNegative_individual extends InitDriver {
    public void testInputNegative() throws InterruptedException {
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

        //Заполнение обязательных полей
        List<WebElement> inputs = driver.findElements(By.xpath("//*[(@HelpText='Обязательное поле')" +
                "and not (contains(@AutomationId,'1230'))]"));
        for (WebElement input : inputs) {
            input.sendKeys(testFields);
        }
        driver.findElement(By.xpath(snils)).sendKeys(testSNILS);

        //Фамилия
        driver.findElement(By.xpath(surname)).sendKeys(specialSymbols);
        next.click();
        new Button(driver.findElement(By.xpath("//Window/Window/Button"))).click();
        driver.findElement(By.xpath(surname)).sendKeys(date);
        next.click();
        new Button(driver.findElement(By.xpath("//Window/Window/Button"))).click();
        driver.findElement(By.xpath(surname)).sendKeys(testFields);

        //Отчество
        driver.findElement(By.xpath(givenName)).sendKeys(specialSymbols);
        next.click();
        new Button(driver.findElement(By.xpath("//Window/Window/Button"))).click();
        driver.findElement(By.xpath(givenName)).sendKeys(date);
        next.click();
        new Button(driver.findElement(By.xpath("//Window/Window/Button"))).click();
        driver.findElement(By.xpath(givenName)).sendKeys(testFields);

        //Организация
        driver.findElement(By.xpath(organizationName)).sendKeys(specialSymbols);
        next.click();
        new Button(driver.findElement(By.xpath("//Window/Window/Button"))).click();
        driver.findElement(By.xpath(organizationName)).sendKeys(testFields);

        //Подразделение
        driver.findElement(By.xpath(organizationUnitname)).sendKeys(specialSymbols);
        next.click();
        new Button(driver.findElement(By.xpath("//Window/Window/Button"))).click();
        driver.findElement(By.xpath(organizationUnitname)).clear();

        //Должность
        driver.findElement(By.xpath(title)).sendKeys(specialSymbols);
        next.click();
        new Button(driver.findElement(By.xpath("//Window/Window/Button"))).click();
        driver.findElement(By.xpath(title)).clear();

        //Страна
        driver.findElement(By.xpath(contryName)).sendKeys(specialSymbols);
        next.click();
        new Button(driver.findElement(By.xpath("//Window/Window/Button"))).click();
        driver.findElement(By.xpath(contryName)).sendKeys(date);
        next.click();
        new Button(driver.findElement(By.xpath("//Window/Window/Button"))).click();
        driver.findElement(By.xpath(contryName)).sendKeys(numbers);
        next.click();
        new Button(driver.findElement(By.xpath("//Window/Window/Button"))).click();
        driver.findElement(By.xpath(contryName)).sendKeys("тест");
        next.click();
        new Button(driver.findElement(By.xpath("//Window/Window/Button"))).click();
        driver.findElement(By.xpath(contryName)).sendKeys(" u");
        next.click();
        new Button(driver.findElement(By.xpath("//Window/Window/Button"))).click();
        driver.findElement(By.xpath(contryName)).sendKeys("r");
        next.click();
        new Button(driver.findElement(By.xpath("//Window/Window/Button"))).click();
        driver.findElement(By.xpath(contryName)).sendKeys("r ");
        next.click();
        new Button(driver.findElement(By.xpath("//Window/Window/Button"))).click();
        driver.findElement(By.xpath(contryName)).clear();
        next.click();
        new Button(driver.findElement(By.xpath("//Window/Window/Button"))).click();
        driver.findElement(By.xpath(contryName)).sendKeys("ru");

        //Область
        driver.findElement(By.xpath(provinceName)).sendKeys(specialSymbols);
        next.click();
        new Button(driver.findElement(By.xpath("//Window/Window/Button"))).click();
        driver.findElement(By.xpath(provinceName)).sendKeys(date);
        next.click();
        new Button(driver.findElement(By.xpath("//Window/Window/Button"))).click();
        driver.findElement(By.xpath(provinceName)).sendKeys(numbers);
        next.click();
        new Button(driver.findElement(By.xpath("//Window/Window/Button"))).click();
        driver.findElement(By.xpath(provinceName)).clear();

        //Населенный пункт
        driver.findElement(By.xpath(localityName)).sendKeys(specialSymbols);
        next.click();
        new Button(driver.findElement(By.xpath("//Window/Window/Button"))).click();
        driver.findElement(By.xpath(localityName)).clear();

        //Адрес
        driver.findElement(By.xpath(address)).sendKeys(specialSymbols);
        next.click();
        new Button(driver.findElement(By.xpath("//Window/Window/Button"))).click();
        driver.findElement(By.xpath(address)).clear();

        //Почта
        driver.findElement(By.xpath(mail)).sendKeys(specialSymbols);
        next.click();
        new Button(driver.findElement(By.xpath("//Window/Window/Button"))).click();
        driver.findElement(By.xpath(mail)).sendKeys(date);
        next.click();
        new Button(driver.findElement(By.xpath("//Window/Window/Button"))).click();
        driver.findElement(By.xpath(mail)).sendKeys(numbers);
        next.click();
        new Button(driver.findElement(By.xpath("//Window/Window/Button"))).click();
        driver.findElement(By.xpath(mail)).sendKeys(words);
        next.click();
        Thread.sleep(1000);
        new Button(driver.findElement(By.xpath("//Window/Window/Button"))).click();
        driver.findElement(By.xpath(mail)).clear();
        Thread.sleep(1000);

        //ИНН
        driver.findElement(By.xpath(inn)).sendKeys(specialSymbols);
        driver.findElement(By.xpath(inn)).sendKeys(date);
        next.click();
        driver.findElement(By.xpath(inn)).sendKeys(words);
        driver.findElement(By.xpath(inn)).sendKeys(space);
        driver.findElement(By.xpath(inn)).clear();

        //СНИЛС
        driver.findElement(By.xpath(snils)).sendKeys(specialSymbols);
        driver.findElement(By.xpath(snils)).sendKeys(date);
        next.click();
        driver.findElement(By.xpath(snils)).sendKeys(words);
        driver.findElement(By.xpath(snils)).sendKeys(space);
        driver.findElement(By.xpath(snils)).sendKeys(testSNILS);

        next.click();
        next.click();

        try {
            driver.findElement(By.xpath("//List[ListItem[1]/Text[2][@Name='ТестПоля']" +
                    "and ListItem[2]/Text[2][@Name='ТестПоля'] and ListItem[3]/Text[2][@Name='ТестПоля']" +
                    "and ListItem[4]/Text[2][@Name=''] and ListItem[5]/Text[2][@Name='']" +
                    "and ListItem[6]/Text[2][@Name='ru'] and ListItem[7]/Text[2][@Name='']" +
                    "and ListItem[8]/Text[2][@Name=''] and ListItem[9]/Text[2][@Name='']" +
                    "and ListItem[10]/Text[2][@Name=''] and ListItem[11]/Text[2][@Name='']" +
                    "and ListItem[12]/Text[2][@Name='01234567891']]"));
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.assertAll();
        }
        new Button(driver.findElement(By.xpath("//*[(@AutomationId = 'cancelbutton')]"))).click();
    }
}
