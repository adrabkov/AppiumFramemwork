package core.setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver extends Configurations {

    private AppiumDriver appiumDriver;
    public static AppiumDriverLocalService service;

    private Driver() {
    }

    private static final Driver instance = new Driver();

    public static Driver getInstance() {
        return instance;
    }

    private final ThreadLocal<AppiumDriver> threadLocal = new ThreadLocal<AppiumDriver>() {
        protected AppiumDriver initialValue() {
            switch (osName) {
                case "Android" -> {
                    if (isRemote.equals("false")) {
                        var localCaps = commonCapabilities(osName, androidPlatformVersion, deviceName, application);
                        CreateDriver(localCaps);
                    } else {
                        var cloudCaps = commonCapabilities(osName, androidPlatformVersion, browserStackAndroidDeviceName, browserStackAndroidAppUrl);
                        CreateDriver(cloudCaps);
                    }
                }
                case "iOS" -> {
                    var cloudCaps = commonCapabilities(osName, iOsPlatformVersion, browserStackIOsDeviceName, browserStackIOsAppUrl);
                    CreateDriver(cloudCaps);
                }
            }
            return appiumDriver;
        }
    };

    public AppiumDriver getAppiumDriver() {
        return appiumDriver;
    }

    public AppiumDriver initAppiumDriver() {
        return threadLocal.get();
    }

    private void CreateDriver(DesiredCapabilities caps) {
        try {
            if (osName.equals("Android")) {
                if (isRemote.equals("false")) {
                    appiumDriver = new AndroidDriver<>(startAppiumService(), caps);
                } else {
                    appiumDriver = new AndroidDriver<>(new URL(cloudUrl), caps);
                }
            } else {
                appiumDriver = new IOSDriver<>(new URL(cloudUrl), caps);
            }
            appiumDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            log.info("Create instance of " + osName + " Driver");
        } catch (Exception e) {
            e.printStackTrace();
            log.info("Instance of " + osName + " Driver is not created");
        }
    }

    private AppiumDriverLocalService startAppiumService() {
        boolean flag = checkIfServerIsRunning();
        if (!flag) {
            service = AppiumDriverLocalService.buildDefaultService();
            service.start();
            log.info("An appium server node is started!");
        }
        return service;
    }

    private boolean checkIfServerIsRunning() {
        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(4723);
            serverSocket.close();
        } catch (IOException e) {
            isServerRunning = true;
            log.info("An appium server node already started!");
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }
}
