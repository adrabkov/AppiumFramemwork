package core.pages;

import core.setup.Driver;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;

import java.util.logging.Logger;

public abstract class BasePage {

    protected Logger log = Logger.getLogger("AD");
    protected Wait<AppiumDriver> wait;

    public BasePage() {
        PageFactory.initElements(Driver.getInstance().initAppiumDriver(), this);
    }
}
