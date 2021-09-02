package core.pages;

import core.setup.Driver;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public abstract class BasePage {

    protected Logger log = Logger.getLogger("AD");

    public BasePage() {
        PageFactory.initElements(Driver.getInstance().initAppiumDriver(), this);
        log.info("Appium driver initiated");
    }
}
