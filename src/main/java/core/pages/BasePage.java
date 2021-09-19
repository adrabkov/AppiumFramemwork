package core.pages;

import core.setup.Driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public abstract class BasePage {
    AndroidDriver driver = Driver.getInstance().getThreadLocalDriver();
    protected Wait<AndroidDriver> wait;

    public BasePage() {
        PageFactory.initElements(driver, this);
    }

    protected void scrollToText(String text) {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));");
    }

    public void scroll(WebElement element) {
        TouchActions action = new TouchActions(driver);
        action.scroll(element, 10, 100);
        action.perform();
        element.click();
    }

    public boolean waitForElement(WebElement element) {
        wait = getWait(120);
        return wait.until(driver -> element != null && element.isEnabled() && element.isDisplayed());
    }

    private FluentWait getWait(int timeout) {
        return new FluentWait<>(driver)
                .pollingEvery(Duration.ofSeconds(2))
                .withTimeout(Duration.ofSeconds(timeout))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }
}
