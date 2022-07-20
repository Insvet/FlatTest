package Start;

import FlaNium.WinAPI.webdriver.DesktopOptions;
import FlaNium.WinAPI.webdriver.FlaNiumDriver;
import FlaNium.WinAPI.webdriver.FlaNiumDriverService;

import java.io.File;

public class FlaniumStart {
    static String DRIVER_PATH = "C:\\Users\\Admin\\IdeaProjects\\Flat\\src\\main\\resources\\FlaNium.Desktop.Driver-v1.6.0/FlaNium.Driver.exe";
    static String APP_PATH = "C:\\Program Files\\7-Zip/7zFM.exe";
    static int driverPort = 10000;
    public static void main(String[] args) {
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
        options.setLaunchDelay(5);
// Подключение к ранее запущенному экземпляру приложения
        options.setDebugConnectToRunningApp(false);

// Получение экземпляра драйвера приложения
        FlaNiumDriver driver = new FlaNiumDriver(service, options);

    }
}
