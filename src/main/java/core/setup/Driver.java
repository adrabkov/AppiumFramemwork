package core.setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver extends Configurations {

    private AndroidDriver appiumDriver;
    public static AndroidDriver driver;
    //private static AndroidDriver appiumDriver;
    public static AppiumDriverLocalService service;


    private Driver() {
    }

    private static final Driver instance = new Driver();

    public static AndroidDriver getAppiumDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Google_Pixel_3");

        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
        capabilities.setCapability(AndroidMobileCapabilityType.AVD, "Google_Pixel_3");
        capabilities.setCapability("adbExecTimeout", "30000");
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, "false");


        capabilities.setCapability(MobileCapabilityType.APP, "D:\\TestProject\\AppiumFramemwork\\src\\test\\resources\\General-Store.apk");
        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }

    public static Driver getInstance() {
        return instance;
    }

    private final ThreadLocal<AndroidDriver> threadLocal = new ThreadLocal<AndroidDriver>() {
        protected AndroidDriver initialValue() {
            switch (osName) {
                case "Android":
                    if (isRemote.equals("false")) {
                        var localCaps = androidCapabilities(osName, androidPlatformVersion, deviceName, application);
                        certainUrl = appiumHub;
                        CreateDriver(localCaps);
                    } else {
                        var cloudCaps = androidCapabilities(osName, androidPlatformVersion, browserStackAndroidDeviceName, browserStackAndroidAppUrl);
                        certainUrl = cloudUrl;
                        CreateDriver(cloudCaps);
                    }
                    break;
                case "iOS":
                    var cloudCaps = androidCapabilities(osName, iOsPlatformVersion, browserStackIOsDeviceName, browserStackIOsAppUrl);
                    CreateDriver(cloudCaps);
                    break;
            }
            return appiumDriver;
        }
    };

//    public AndroidDriver getAppiumDriver() {
//        return appiumDriver;
//    }

    public AndroidDriver initAppiumDriver() {
        return threadLocal.get();
    }

    private void CreateDriver(DesiredCapabilities capabilities) {
        try {
            if (osName.equals("Android")) {
                appiumDriver = new AndroidDriver(new URL(certainUrl), capabilities);
            }
            //appiumDriver = new AppiumDriver(new URL(certainUrl), capabilities);
            appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            log.info("Create instance of " + osName + " Driver");
        } catch (Exception e) {
            e.printStackTrace();
            log.info("Instance of " + osName + " Driver is not created");
        }
    }
}
