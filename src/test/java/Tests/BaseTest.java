package Tests;

import core.setup.Driver;
import core.steps.CommonSteps;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.logging.Logger;

public class BaseTest {
    protected AppiumDriver driver;
    private WebDriverWait wait;
    protected CommonSteps steps = new CommonSteps();
    Logger log = Logger.getLogger("AD");

    @BeforeMethod
    public void setUp() {
        //Driver.startServer();
        driver = Driver.getAppiumDriver();
        //wait = new WebDriverWait(driver, 15);
        log.info("Appium Driver initialized");
    }

//    @AfterMethod
//    public void tearDown() {
//        //Driver.service.stop();
//    }
}
