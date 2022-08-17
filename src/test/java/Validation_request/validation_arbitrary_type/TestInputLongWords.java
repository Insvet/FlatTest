package Validation_request.validation_arbitrary_type;

import FlaNium.WinAPI.elements.Button;
import FlaNium.WinAPI.elements.TabItem;
import FlaNium.WinAPI.webdriver.DesktopOptions;
import FlaNium.WinAPI.webdriver.FlaNiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import static Validation_request.validation_arbitrary_type.Variables.*;

public class TestInputLongWords extends InitDriver {
    public void testInputLongWords() throws InterruptedException {
        DesktopOptions options = new DesktopOptions();
        options.setApplicationPath(String.valueOf(new File(APP_PATH)));
        options.setLaunchDelay(10);
        options.setDebugConnectToRunningApp(true);
        FlaNiumDriver driver = new FlaNiumDriver(service, options);

        new TabItem(driver.findElement(By.xpath("//ToolBar/Tab/TabItem[3]"))).click();
        new TabItem(driver.findElement(By.xpath("//TabItem/ToolBar/Tab/TabItem[1]"))).click();
        new Button(driver.findElement(By.xpath("//TabItem/TabItem/ToolBar[1]/Button[1]"))).click();
        Button next = new Button(driver.findElement(By.xpath("//*[(@AutomationId = 'nextbutton')]")));
        next.click();

        driver.findElement(By.xpath(commonName)).sendKeys("test");
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

        WebElement group = null;
        try {
            group = driver.findElement(By.xpath("//List[ListItem[1]/Text[2][@Name='Lorem ipsum dolor sit " +
                    "amet consectetuer adipiscing elit Aenean commodo ligula eget dolor Aenean massa Cum sociis " +
                    "natoque penatibus et magnis dis parturient montes nascetur ridiculus mus Donec quam felis " +
                    "ultricies nec pellentesque eu pretium quis sem Nulla cons']" +

                    "and ListItem[2]/Text[2][@Name='Lorem ipsum dolor sit amet consectetuer adipiscing elit Aenean " +
                    "commodo ligula eget dolor Aenean massa Cum sociis natoque penatibus et magnis dis parturient " +
                    "montes nascetur ridiculus mus Donec quam felis ultricies nec pellentesque eu pretium quis sem " +
                    "Nulla cons'] " +

                    "and ListItem[3]/Text[2][@Name='Lorem ipsum dolor sit amet consectetuer adipiscing " +
                    "elit Aenean commodo ligula eget dolor Aenean massa Cum sociis natoque penatibus et magnis dis " +
                    "parturient montes nascetur ridiculus mus Donec quam felis ultricies nec pellentesque eu pretium " +
                    "quis sem Nulla cons']" +

                    "and ListItem[4]/Text[2][@Name='Lorem ipsum dolor sit amet consectetuer adipiscing elit Aenean " +
                    "commodo ligula eget dolor Aenean massa Cum sociis natoque penatibus et magnis dis parturient " +
                    "montes nascetur ridiculus mus Donec quam felis ultricies nec pellentesque eu pretium quis sem " +
                    "Nulla cons']" +

                    " and ListItem[5]/Text[2][@Name='Lorem ipsum dolor sit amet consectetuer adipiscing elit Aenean " +
                            "commodo ligula eget dolor Aenean massa Cum sociis natoque penati']" +

                    "and ListItem[6]/Text[2][@Name='Lorem ipsum dolor sit amet consectetuer adipiscing elit Aenean " +
                            "commodo ligula eget dolor Aenean massa Cum sociis natoque penati'] " +

                    "and ListItem[7]/Text[2][@Name='RU']" +

                    "and ListItem[8]/Text[2][@Name='Lorem ipsum dolor sit amet consectetuer adipiscing elit Aenean " +
                            "commodo ligula eget dolor Aenean massa Cum sociis natoque penati'] " +

                    "and ListItem[9]/Text[2][@Name='Lorem ipsum dolor sit amet consectetuer adipiscing elit Aenean" +
                            " commodo ligula eget dolor Aenean massa Cum sociis natoque penati']" +

                    "and ListItem[10]/Text[2][@Name='Lorem ipsum dolor sit amet consectetuer adipiscing elit Aenean " +
                            "commodo ligula eget dolor Aenean massa Cum sociis natoque penati'] " +

                    "and ListItem[11]/Text[2][@Name='userfkvjmlsdzjkhrguihnsrgjndzxjsdujfhuisefuih32873724fliughesr22@" +
                    "hijagsiaefoiubhsrawjgkcudzhvfklsrjgfuihsdrfigvbsdrtkgost.domai']" +

                    "and ListItem[12]/Text[2][@Name='012345678912'] and ListItem[13]/Text[2][@Name='01234567891']" +
                    "and ListItem[14]/Text[2][@Name='0123456789123']]"));
        }catch (Exception e){
            e.printStackTrace();
        }if (group != null){
            System.out.println("--> SUCCESS! Test input long words passed");
        }else System.out.println("--> ERROR! Test input long words failed");

        new Button(driver.findElement(By.xpath("//*[(@AutomationId = 'cancelbutton')]"))).click();
    }
}
