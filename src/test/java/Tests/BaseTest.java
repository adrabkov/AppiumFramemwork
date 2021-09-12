package Tests;

import core.setup.Driver;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.logging.Logger;

public class BaseTest {
    Logger log = Logger.getLogger("AD");
    private AppiumDriver appiumDriver;
    private WebDriverWait wait;

    @BeforeTest
    public void setUp() {
        appiumDriver = Driver.getInstance().initAppiumDriver();
        wait = new WebDriverWait(appiumDriver, 15);
        log.info("Appium Driver initialized");
    }

    @AfterTest
    public void tearDown() {
        if (appiumDriver != null) {
            appiumDriver.quit();
        }
        if (Driver.service != null) {
            Driver.service.stop();
        }
    }
}
