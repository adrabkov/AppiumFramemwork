package core.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class ProductsListPage extends BasePage {

    @FindBy(id = "com.androidsample.generalstore:id/toolbar_title")
    private WebElement toolBarTitle;

    @FindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    private WebElement cartButton;

    @FindBy(id = "com.androidsample.generalstore:id/counterText")
    private WebElement counterForCartText;

    @FindBy(xpath = "//*[@text='ADD TO CART']")
    private WebElement addToCartLink;

    @FindBys({
            @FindBy(xpath = "//*[@text='ADD TO CART']")
    })
    private List<WebElement> addToCart;

    @FindBys({
            @FindBy(xpath = "//*[@text='ADDED TO CART']")
    })
    private List<WebElement> addedToCart;

    @FindBy(id = "com.androidsample.generalstore:id/productPrice")
    private WebElement price;

    @FindBy(id = "com.androidsample.generalstore:id/productName")
    private WebElement productName;

    @FindBy(id = "com.androidsample.generalstore:id/appbar_btn_back")
    private WebElement backButton;

    public String getTextFromToolBar() {
        return toolBarTitle.getText();
    }

    public void waitUntilProductListIsDisplayed() {
        waitForElement(toolBarTitle);
    }

    public WebElement getAddToCartElement(){
        return addToCart.get(0);
    }

    public void clickAddToCartButton(){
        addToCart.get(0).click();
    }

    public WebElement getAddedToCartElement(){
        return addedToCart.get(0);
    }

    public void removeProductFromCart(){
        addedToCart.get(0).click();
    }

    public String getCountOfCartCounter(){
        return counterForCartText.getText();
    }

    public WebElement getCounterElement(){
        return counterForCartText;
    }

    public void clickTheCartButton(){
        cartButton.click();
    }

    public void clickBackButton(){
        backButton.click();
    }
}
