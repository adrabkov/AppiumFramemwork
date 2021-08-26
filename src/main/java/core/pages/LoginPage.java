package core.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "com.call4site.handymanservices:id/email")
    private WebElement emailField;

    @FindBy(id = "com.call4site.handymanservices:id/password")
    private WebElement passwordField;

    @FindBy(id = "com.call4site.handymanservices:id/email_sign_in_button")
    private WebElement signInButton;

    public void setEmailField(String email) {
        emailField.isDisplayed();
        emailField.sendKeys(email);
    }

    public void setPasswordField(String password) {
        passwordField.sendKeys(password);
    }

    public void clickSignInButton() {
        signInButton.click();
    }
}
