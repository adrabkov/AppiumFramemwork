import core.setup.Driver;
import io.appium.java_client.AppiumDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public class BaseTest {
    private AppiumDriver appiumDriver;
    private WebDriverWait wait;
    Logger log = Logger.getLogger("AD");

    @Before
    public void setUp(){
        appiumDriver = Driver.getInstance().getAppiumDriver();
        wait = new WebDriverWait(appiumDriver, 15);
        log.info("wait was set up");
    }

    @After
    public void  tearDown() {
        if (appiumDriver != null) {
            appiumDriver.quit();
        }
        if (Driver.service != null) {
            Driver.service.stop();
        }
    }
}
