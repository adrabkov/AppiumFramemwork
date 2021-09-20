package core.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(id = "com.androidsample.generalstore:id/toolbar_title")
    private WebElement tabName;

    @FindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
    private WebElement totalPrice;

    @FindBy(id = "com.androidsample.generalstore:id/appbar_btn_back")
    private WebElement backButton;

    public String getTextFromCartTab(){
        return tabName.getText();
    }

    public void clickBackButton(){
        backButton.click();
    }

    public void waitUntilCartTabIsDisplayed() {
        waitForElement(tabName);
    }
}
