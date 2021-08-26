package core.setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver extends Configurations {

    private AppiumDriver appiumDriver;
    public static AppiumDriverLocalService service;
    private URL url;

    private Driver() {
    }

    private static Driver instance = new Driver();

    public static Driver getInstance() {
        return instance;
    }

    private void startAppiumService() {
        service = AppiumDriverLocalService.buildDefaultService();
        if (service != null && service.isRunning()) {
            terminateAllNodeProcess();
        }
        service.start();
        log.info("An appium server node is started!");
        url = service.getUrl();
    }

    private ThreadLocal<AppiumDriver> threadLocal = new ThreadLocal<AppiumDriver>() {
        protected AppiumDriver initialValue() {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            if (appiumDriver == null) {
                switch (osName) {
                    case "Android" -> {

                        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, osName);
                        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, androidPlatformVersion);
                        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
                        capabilities.setCapability(MobileCapabilityType.APP, application);
                        try {
                            runAndroidEmulator(deviceName);
                            appiumDriver = new AppiumDriver(url, capabilities);
                            appiumDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                            log.info("Create instance of Android Driver");

                        } catch (Exception e) {
                            e.printStackTrace();
                            log.info("Instance of Android Driver is not created");
                        }
                    }
                    case "iOS" -> {
                        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, osName);
                        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, iOsPlatformVersion);
                        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
                        capabilities.setCapability(MobileCapabilityType.APP, application);
                        try {
                            appiumDriver = new AppiumDriver(url, capabilities);
                            appiumDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                            log.info("Create instance of iOS Driver");

                        } catch (Exception e) {
                            e.printStackTrace();
                            log.info("Instance of iOS Driver is not created");
                        }
                    }
                }
            }
            return appiumDriver;
        }
    };

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

    public void terminateAllNodeProcess() {
        try {
            Runtime.getRuntime().exec("cmd.exe /c Taskkill /IM node.exe /F");
            log.info("The process 'node.exe' has been terminated");
            Thread.sleep(1000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public AppiumDriver getAppiumDriver() {
        return appiumDriver;
    }

    public AppiumDriver initAppiumDriver() {
        startAppiumService();
        return threadLocal.get();
    }
}
