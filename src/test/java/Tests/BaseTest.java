package Tests;

import core.setup.Driver;
import core.steps.CommonSteps;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.logging.Logger;

public class BaseTest {
    private AndroidDriver<AndroidElement> driver;
    private WebDriverWait wait;
    protected CommonSteps steps = new CommonSteps();
    Logger log = Logger.getLogger("AD");

    @BeforeTest
    public void setUp() {
        driver = Driver.getInstance().initAppiumDriver();
        wait = new WebDriverWait(driver, 15);
        log.info("Appium Driver initialized");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
