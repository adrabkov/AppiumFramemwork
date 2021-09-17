package core.setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver extends Configurations {

    private AndroidDriver appiumDriver;


    private Driver() {
    }

    private static final Driver instance = new Driver();

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

    public AndroidDriver getAppiumDriver() {
        return appiumDriver;
    }

    public AndroidDriver initAppiumDriver() {
        return threadLocal.get();
    }

    private void CreateDriver(DesiredCapabilities capabilities) {
        try {
            if (osName.equals("Android")){
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
