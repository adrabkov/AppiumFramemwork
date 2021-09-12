package core.setup;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.logging.Logger;

public class Configurations {
    protected final Logger log = Logger.getLogger("AD");
    protected final String osName = getProperty("OS");
    protected final String isRemote = getProperty("isRemote");
    protected final String application = getFile(getProperty("application")).getAbsolutePath();
    protected final String deviceName = getProperty("deviceName");
    protected final String iOsPlatformVersion = getProperty("iOsPlatformVersion");
    protected final String androidPlatformVersion = getProperty("androidPlatformVersion");

    protected final String browserStackUser = getProperty("browserStackUser");
    protected final String browserStackKey = getProperty("browserStackKey");
    protected final String browserStackAndroidAppUrl = getProperty("browserStackAndroidAppUrl");
    protected final String browserStackAndroidDeviceName = getProperty("browserStackAndroidDeviceName");
    protected final String browserStackIOsDeviceName = getProperty("browserStackIOsDeviceName");
    protected final String browserStackIOsAppUrl = getProperty("browserStackIOsAppUrl");
    protected final String cloudUrl = getProperty("cloudURL");

    protected DesiredCapabilities commonCapabilities(String osName, String platformVersion, String deviceName, String application) {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (isRemote.equals("true")) {
            capabilities.setCapability("browserstack.user", browserStackUser);
            capabilities.setCapability("browserstack.key", browserStackKey);
        }
        if (osName.equals("Android")){
            capabilities.setCapability(AndroidMobileCapabilityType.AVD, deviceName);
            capabilities.setCapability(AndroidMobileCapabilityType.DONT_STOP_APP_ON_RESET, true);
            //capabilities.setCapability(AndroidMobileCapabilityType.ANDROID_INSTALL_TIMEOUT, 2000);
        }
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, osName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.APP, application);

        return capabilities;
    }

    private String getProperty(String propertyName) {
        Properties property = new Properties();
        try (InputStream inputStream = new FileInputStream(getFile("config.properties"))) {
            property.load(inputStream);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return property.getProperty(propertyName);
    }

    private File getFile(String fileName) {
        return new File(new File(getPathToDir()), fileName);
    }

    private String getPathToDir() {
        var baseDir = System.getProperty("user.dir");
        return Paths.get(baseDir, "src", "test", "resources").toString();
    }
}
