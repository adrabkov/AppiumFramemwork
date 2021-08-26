import core.setup.Driver;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.logging.Logger;

public class BaseTest {
    private AppiumDriver appiumDriver;
    private WebDriverWait wait;
    Logger log = Logger.getLogger("AD");

    @BeforeTest
    public void setUp() {
        appiumDriver = Driver.getInstance().getAppiumDriver();
        wait = new WebDriverWait(appiumDriver, 15);
        log.info("wait was set up");
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
