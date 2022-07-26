package Start;

import FlaNium.WinAPI.elements.*;
import FlaNium.WinAPI.enums.BasePoint;
import FlaNium.WinAPI.webdriver.DesktopOptions;
import FlaNium.WinAPI.webdriver.FlaNiumDriver;
import FlaNium.WinAPI.webdriver.FlaNiumDriverService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;

public class FlaniumStart {
    static String DRIVER_PATH = "C:\\Users\\AdminTst\\IdeaProjects\\FlatTest\\src\\main\\resources\\FlaNium.Desktop.Driver-v1.6.0/FlaNium.Driver.exe";
    static String APP_PATH = "C:\\Program Files\\Security Code\\Continent ZTN Client/ZtnClient.exe";
    static int driverPort = 9990;

    public static void main(String[] args) throws InterruptedException {
        FlaNiumDriverService service = new FlaNiumDriverService.Builder()
                // Указание пути до драйвера
                .usingDriverExecutable(new File(DRIVER_PATH).getAbsoluteFile())
                // Установка порта (по умолчанию 9999)
                .usingPort(driverPort)
                // Включение режима отладки (вывод логов в консоль)
                .withVerbose(true)
                // Отключение логирования
                .withSilent(false)
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


//        Button window = new Button(driver.findElement(By.xpath(" //*[(@Name = 'Продолжить без регистрации')] ")));
//        window.click();

        TabItem button = new TabItem(driver.findElement(By.xpath(" //*[(@Name = 'Настройки')] ")));
        button.click();

        TabItem konf = new TabItem(driver.findElement(By.xpath(" //*[(@Name = 'Конфигурация')] ")));
        konf.click();

        Button impt = new Button(driver.findElement(By.xpath(" //Window/Group/Button[2] ")));
        impt.click();

        Thread.sleep(1000);

//        TreeItem download = new TreeItem(driver.findElement(By.xpath(" //Window[1]/Pane[1]/Pane[1]/Tree/TreeItem/TreeItem[1]/TreeItem[2] ")));
//        download.click();

        TreeItem download = new TreeItem(driver.findElement(By.xpath(" //*[(@Name = 'Загрузки (закреплено)')] ")));
        download.click();

        Button action = new Button(driver.findElement(By.xpath(" //*[(@ControlType = 'ListItem')] ")));
        action.invoke();

        Thread.sleep(1000);

        Button yes = new Button(driver.findElement(By.xpath(" //*[(@Name = 'Да')] ")));
        yes.click();

        Thread.sleep(1000);

        TreeItem cert = new TreeItem(driver.findElement(By.xpath(" //*[(@Name = 'test8_win11_2 (18-07-2022 17:24:08)')] ")));
        cert.click();

//        Button agree = new Button(driver.findElement(By.xpath(" //Window[1]/Button[3] ")));
//        agree.click();

        Button agree = new Button(driver.findElement(By.xpath(" //*[(@Name = 'ОК')] ")));
        agree.click();

        Thread.sleep(1000);

        Button close = new Button(driver.findElement(By.xpath(" //Window[2]/TabItem/Group[1]/Button ")));
        close.click();

        Button exit = new Button(driver.findElement(By.xpath( " //Window/Button ")));
        exit.click();

        //Проверка добавленного сертификата

        TabItem tabItem = new TabItem(driver.findElement(By.xpath(" //ToolBar/Tab/TabItem[3] ")));
        tabItem.click();

        TabItem user = new TabItem(driver.findElement(By.xpath(" //TabItem/ToolBar/Tab/TabItem[1] ")));
        user.click();

        Button edit = new Button(driver.findElement(By.xpath(" //TabItem/TabItem/ToolBar[1]/Edit ")));
        edit.click();

        driver.findElement(By.xpath(" //TabItem/TabItem/ToolBar[1]/Edit ")).clear();

        driver.findElement(By.xpath(" //TabItem/TabItem/ToolBar[1]/Edit ")).sendKeys("test8_win11_2");

        Button checkEdit = new Button(driver.findElement(By.xpath(" //TabItem/TabItem/Table/Group[1]/Group[1] ")));
        checkEdit.mouseClick(BasePoint.CENTER_BOTTOM, 0, 10);

        WebElement test = null;
        try {
            test = driver.findElement(By.xpath(" //*[(@Name = 'Удалить')] "));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        if (test != null) {
            System.out.print(" --> Cert added");
        }else System.out.println(" --> Cert not added");
    }
}
