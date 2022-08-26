package Validation_request.arbitrary_type;

import FlaNium.WinAPI.elements.Button;
import FlaNium.WinAPI.elements.TabItem;
import FlaNium.WinAPI.webdriver.DesktopOptions;
import FlaNium.WinAPI.webdriver.FlaNiumDriver;
import Validation_request.InitDriver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import java.io.File;
import static Validation_request.Variables.*;

public class TestInputNegative extends InitDriver {
    public void testInputNegative() throws InterruptedException {
        DesktopOptions options = new DesktopOptions();
        options.setApplicationPath(String.valueOf(new File(APP_PATH)));
        options.setLaunchDelay(10);
        options.setDebugConnectToRunningApp(true);
        FlaNiumDriver driver = new FlaNiumDriver(service, options);

        try {
            driver.findElement(By.xpath("//*[@AutomationId='cancelbutton']")).click();
        } catch (Exception e) {
            e.printStackTrace();
        }

        new TabItem(driver.findElement(By.xpath("//ToolBar/Tab/TabItem[3]"))).click();
        new TabItem(driver.findElement(By.xpath("//TabItem/ToolBar/Tab/TabItem[1]"))).click();
        new Button(driver.findElement(By.xpath("//TabItem/TabItem/ToolBar[1]/Button[1]"))).click();
        Button next = new Button(driver.findElement(By.xpath("//*[(@AutomationId = 'nextbutton')]")));
        next.click();

        //Общее имя
        driver.findElement(By.xpath(commonName)).sendKeys(specialSymbols);
        next.click();
        new Button(driver.findElement(By.xpath("//Window/Window/Button"))).click();
        driver.findElement(By.xpath(commonName)).sendKeys(date);
        next.click();
        new Button(driver.findElement(By.xpath("//Window/Window/Button"))).click();
        driver.findElement(By.xpath(commonName)).sendKeys("ТестОбщееИмя");

        //Фамилия
        driver.findElement(By.xpath(surname)).sendKeys(specialSymbols);
        next.click();
        new Button(driver.findElement(By.xpath("//Window/Window/Button"))).click();
        driver.findElement(By.xpath(surname)).sendKeys(date);
        next.click();
        new Button(driver.findElement(By.xpath("//Window/Window/Button"))).click();
        driver.findElement(By.xpath(surname)).clear();

        //Отчество
        driver.findElement(By.xpath(givenName)).sendKeys(specialSymbols);
        next.click();
        new Button(driver.findElement(By.xpath("//Window/Window/Button"))).click();
        driver.findElement(By.xpath(givenName)).sendKeys(date);
        next.click();
        new Button(driver.findElement(By.xpath("//Window/Window/Button"))).click();
        driver.findElement(By.xpath(givenName)).clear();

        //Организация
        driver.findElement(By.xpath(organizationName)).sendKeys(specialSymbols);
        next.click();
        new Button(driver.findElement(By.xpath("//Window/Window/Button"))).click();
        driver.findElement(By.xpath(organizationName)).clear();

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
        driver.findElement(By.xpath(snils)).clear();

        //ОГРН
        driver.findElement(By.xpath(ogrn)).sendKeys(specialSymbols);
        driver.findElement(By.xpath(ogrn)).sendKeys(date);
        next.click();
        driver.findElement(By.xpath(ogrn)).sendKeys(words);
        driver.findElement(By.xpath(ogrn)).sendKeys(space);
        driver.findElement(By.xpath(ogrn)).clear();

        next.click();
        next.click();

        try {
            driver.findElement(By.xpath("//List[ListItem[1]/Text[2][@Name='']" +
                    "and ListItem[2]/Text[2][@Name=''] and ListItem[3]/Text[2][@Name='ТестОбщееИмя']" +
                    "and ListItem[4]/Text[2][@Name=''] and ListItem[5]/Text[2][@Name='']" +
                    "and ListItem[6]/Text[2][@Name=''] and ListItem[7]/Text[2][@Name='ru']" +
                    "and ListItem[8]/Text[2][@Name=''] and ListItem[9]/Text[2][@Name='']" +
                    "and ListItem[10]/Text[2][@Name=''] and ListItem[11]/Text[2][@Name='']" +
                    "and ListItem[12]/Text[2][@Name=''] and ListItem[13]/Text[2][@Name='']" +
                    "and ListItem[14]/Text[2][@Name='']]"));
        }catch (Exception e) {
            e.printStackTrace();
            Assertions.assertAll();
        }
        new Button(driver.findElement(By.xpath("//*[(@AutomationId = 'cancelbutton')]"))).click();
    }
}
