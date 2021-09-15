package core.setup;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver extends Configurations {

    private AndroidDriver<AndroidElement> appiumDriver;
    public static AppiumDriverLocalService service;

    private Driver() {
    }

    private static final Driver instance = new Driver();

    public static Driver getInstance() {
        return instance;
    }

    private final ThreadLocal<AndroidDriver> threadLocal = new ThreadLocal<AndroidDriver>() {
        protected AndroidDriver initialValue() {
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

    public AndroidDriver getAppiumDriver() {
        return appiumDriver;
    }

    public AndroidDriver initAppiumDriver() {
        return threadLocal.get();
    }

    private void CreateDriver(DesiredCapabilities caps) {
        try {
            if (osName.equals("Android")) {
                if (isRemote.equals("false")) {
                    appiumDriver = new AndroidDriver<AndroidElement>(caps);
                } else {
                    appiumDriver = new AndroidDriver<>(new URL(cloudUrl), caps);
                }
            } else {
                //appiumDriver = new IOSDriver<>(new URL(cloudUrl), caps);
            }
            appiumDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            log.info("Create instance of " + osName + " Driver");
        } catch (Exception e) {
            e.printStackTrace();
            log.info("Instance of " + osName + " Driver is not created");
        }
    }
}
