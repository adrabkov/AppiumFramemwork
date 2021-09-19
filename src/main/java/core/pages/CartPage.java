package core.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
    private WebElement totalPrice;
}
