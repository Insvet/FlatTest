package Start;

import FlaNium.WinAPI.elements.*;
import FlaNium.WinAPI.webdriver.DesktopOptions;
import FlaNium.WinAPI.webdriver.FlaNiumDriver;
import FlaNium.WinAPI.webdriver.FlaNiumDriverService;
import org.openqa.selenium.By;

import java.io.File;

public class FlaniumStart {
    static String DRIVER_PATH = "C:\\Users\\AdminTst\\IdeaProjects\\FlatTest\\src\\main\\resources\\FlaNium.Desktop.Driver-v1.6.0/FlaNium.Driver.exe";
    static String APP_PATH = "C:\\Program Files\\Security Code\\Continent ZTN Client/ZtnClient.exe";
    static int driverPort = 9998;
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
        options.setApplicationPath(String.valueOf(new  File(APP_PATH)));
// Задержка после запуска приложения (сек)
        options.setLaunchDelay(10);
// Подключение к ранее запущенному экземпляру приложения
        options.setDebugConnectToRunningApp(true);
// Получение экземпляра драйвера приложения
        FlaNiumDriver driver = new FlaNiumDriver(service,options);

//        Button window = new Button(driver.findElement(By.xpath(" //*[(@Name = 'Продолжить без регистрации')] ")));
//        window.click();

        TabItem button = new TabItem(driver.findElement(By.xpath(" //*[(@Name = 'Настройки')] ")));
        button.click();

        TabItem konf = new TabItem(driver.findElement(By.xpath(" //*[(@Name = 'Конфигурация')] ")));
        konf.click();

        Button impt = new Button(driver.findElement(By.xpath(" //*[(@Name = 'Импортировать')] ")));
        impt.click();

        Thread.sleep(2000);

        TreeItem download = new TreeItem(driver.findElement(By.xpath(" //*[(@Name = 'Загрузки (закреплено)')] ")));
        download.click();

        Button action = new Button(driver.findElement(By.xpath(" //*[(@ControlType = 'ListItem')] ")));
        action.invoke();

        Button yes = new Button(driver.findElement(By.xpath(" //*[(@Name = 'Да')] ")));
        yes.click();

    }
}
