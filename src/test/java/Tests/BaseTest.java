package Tests;

import core.setup.Driver;
import core.steps.User;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.BeforeMethod;

import java.util.logging.Logger;

public class BaseTest {
    protected AppiumDriver driver;
    protected User user = new User();
    Logger log = Logger.getLogger("AD");

    @BeforeMethod
    public void setUp() {
        driver = Driver.getInstance().getAppiumDriver();
        log.info("Appium Driver initialized");
    }
}
