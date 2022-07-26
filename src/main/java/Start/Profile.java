package Start;

import FlaNium.WinAPI.elements.*;
import FlaNium.WinAPI.enums.BasePoint;
import FlaNium.WinAPI.webdriver.DesktopOptions;
import FlaNium.WinAPI.webdriver.FlaNiumDriver;
import FlaNium.WinAPI.webdriver.FlaNiumDriverService;
import org.openqa.selenium.By;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

public class Profile {
    static String DRIVER_PATH = "C:\\Users\\AdminTst\\IdeaProjects\\FlatTest\\src\\main\\resources\\FlaNium.Desktop.Driver-v1.6.0/FlaNium.Driver.exe";
    static String APP_PATH = "C:\\Program Files\\Security Code\\Continent ZTN Client/ZtnClient.exe";
    static int driverPort = 9992;

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        FlaNiumDriverService service = new FlaNiumDriverService.Builder()
                // Указание пути до драйвера
                .usingDriverExecutable(new File(DRIVER_PATH).getAbsoluteFile())
                // Установка порта (по умолчанию 9999)
                .usingPort(driverPort)
                // Включение режима отладки (вывод логов в консоль)
                .withVerbose(true)
                // Отключение логирования
                .withSilent(true)
                .buildDesktopService();


// Инициализация приложения:
        DesktopOptions options = new DesktopOptions();
// Указание пути до тестируемого приложения
        options.setApplicationPath(String.valueOf(new File(APP_PATH)));
// Задержка после запуска приложения (сек)
        options.setLaunchDelay(10);
// Подключение к ранее запущенному экземпляру приложения
        options.setDebugConnectToRunningApp(true);
// Получение экземпляра драйвера приложения
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
        cert.mouseClick(BasePoint.CENTER_BOTTOM,0,10);

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

        Thread.sleep(10000);

//        Runtime runtime = Runtime.getRuntime();
//        Process process;
//
//        try{
//            process = runtime.exec("ping 192.168.100.101");
//            InputStream is = process.getInputStream();
//            InputStreamReader isr = new InputStreamReader(is);
//            BufferedReader br = new BufferedReader(isr);
//
//            String line;
//            StringBuffer sb = new StringBuffer();
//            while ((line = br.readLine()) != null){
//                sb.append(line);
//            }
//            System.out.println(sb);
//
//            is.close();
//            isr.close();
//            br.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }
}
