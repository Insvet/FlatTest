package Validation_request;

import FlaNium.WinAPI.webdriver.FlaNiumDriverService;
import java.io.File;

public class InitDriver {
    public static final String DRIVER_PATH = "C:\\Users\\AdminTst\\IdeaProjects\\FlatTest\\src\\main\\resources\\" +
            "FlaNium.Desktop.Driver-v1.6.0/FlaNium.Driver.exe";
    public static final String APP_PATH = "C:\\Program Files\\Security Code\\Continent ZTN Client/ZtnClient.exe";
    public static final int driverPort = 9970;
    public static FlaNiumDriverService service = new FlaNiumDriverService.Builder()
            .usingDriverExecutable(new File(DRIVER_PATH).getAbsoluteFile())
            .usingPort(driverPort)
            .withVerbose(false)
            .withSilent(false)
            .buildDesktopService();
}
