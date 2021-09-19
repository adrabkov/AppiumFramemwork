package core.setup;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver extends Configurations {

    private final ThreadLocalDriver threadLocalDriver = new ThreadLocalDriver();
    AndroidDriver driver;

    private Driver() {
    }

    private static final Driver instance = new Driver();

    public static Driver getInstance() {
        return instance;
    }

    public AndroidDriver<MobileElement> getAppiumDriver() {
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
                var cloudCaps = iOsCapabilities(osName, iOsPlatformVersion, browserStackIOsDeviceName, browserStackIOsAppUrl);
                certainUrl = cloudUrl;
                CreateDriver(cloudCaps);
                break;
        }
        threadLocalDriver.setTLDriver(driver);
        return driver;
    }

    public AndroidDriver<MobileElement> getThreadLocalDriver() {
        return threadLocalDriver.getTLDriver();
    }

    private void CreateDriver(DesiredCapabilities capabilities) {
        try {
            driver = new AndroidDriver(new URL(certainUrl), capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            log.info("Create instance of " + osName + " Driver");
        } catch (Exception e) {
            e.printStackTrace();
            log.info("Instance of " + osName + " Driver is not created");
        }
    }
}
