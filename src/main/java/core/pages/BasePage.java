package core.pages;

import core.setup.Driver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getInstance().getAppiumDriver(), this);
    }
}
