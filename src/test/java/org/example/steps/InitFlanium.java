package org.example.steps;

import FlaNium.WinAPI.webdriver.FlaNiumDriverService;
import java.io.File;

public class InitFlanium {
    static String DRIVER_PATH = "C:\\Users\\AdminTst\\IdeaProjects\\FlatTest\\src\\main\\resources\\" +
            "FlaNium.Desktop.Driver-v1.6.0/FlaNium.Driver.exe";
    static String APP_PATH = "C:\\Program Files\\Security Code\\Continent ZTN Client/ZtnClient.exe";
    static int driverPort = 9986;
    static FlaNiumDriverService service = new FlaNiumDriverService.Builder()
            .usingDriverExecutable(new File(DRIVER_PATH).getAbsoluteFile())
            .usingPort(driverPort)
            .withVerbose(false)
            .withSilent(false)
            .buildDesktopService();
}
