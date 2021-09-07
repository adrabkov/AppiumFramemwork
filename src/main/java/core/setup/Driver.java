package core.setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver extends Configurations {

    private AppiumDriver appiumDriver;
    public static AppiumDriverLocalService service;
    private String localUrl;

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
                        startAppiumService();
                        runAndroidEmulator(deviceName);
                        var localCaps = commonCapabilities(osName, androidPlatformVersion, deviceName, application);
                        CreateDriver(localCaps, localUrl);
                    } else {
                        var cloudCaps = commonCapabilities(osName, androidPlatformVersion, browserStackAndroidDeviceName, browserStackAndroidAppUrl);
                        CreateDriver(cloudCaps, cloudUrl);
                    }
                }
                case "iOS" -> {
                    if (isRemote.equals("false")) {
                        var localCaps = commonCapabilities(osName, iOsPlatformVersion, deviceName, application);
                        CreateDriver(localCaps, localUrl);
                    } else {
                        var cloudCaps = commonCapabilities(osName, iOsPlatformVersion, browserStackIOsDeviceName, browserStackAndroidAppUrl);
                        CreateDriver(cloudCaps, cloudUrl);
                    }
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

    private void CreateDriver(DesiredCapabilities caps, String Url) {
        try {
            if (osName.equals("Android")) {
                appiumDriver = new AndroidDriver<>(new URL(Url), caps);
            } else {
                appiumDriver = new IOSDriver<>(new URL(Url), caps);
            }
            appiumDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            log.info("Create instance of " + osName + " Driver");
        } catch (Exception e) {
            e.printStackTrace();
            log.info("Instance of " + osName + " Driver is not created");
        }
    }

    private void startAppiumService() {
        service = AppiumDriverLocalService.buildDefaultService();
        terminateAllNodeProcess();
        service.start();
        log.info("An appium server node is started!");
        localUrl = service.getUrl().toString();
    }

    private void runAndroidEmulator(String deviceName) {
        ProcessBuilder builder = new ProcessBuilder();
        String path = System.getenv("ANDROID_HOME").concat("\\emulator");
        builder
                .command("cmd.exe", "/c", "cd /d " + path + " && emulator -avd " + deviceName);
        try {
            builder.start();
            Thread.sleep(10000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            log.info("Android emulator is not started");
        }
    }

    private void terminateAllNodeProcess() {
        try {
            Runtime.getRuntime().exec("cmd.exe /c Taskkill /IM node.exe /F");
            log.info("The process 'node.exe' has been terminated");
            Thread.sleep(1000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
