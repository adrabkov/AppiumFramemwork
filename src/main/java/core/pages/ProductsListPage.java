package core.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsListPage extends BasePage{

    @FindBy(id="com.androidsample.generalstore:id/toolbar_title")
    private WebElement toolBarTitle;

    @FindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    private WebElement cartButton;

    @FindBy(xpath = "//*[@text='ADD TO CART']")
    private WebElement addToCartLink;

    @FindBy(id = "com.androidsample.generalstore:id/productPrice")
    private WebElement price;

    @FindBy(id = "com.androidsample.generalstore:id/productName")
    private WebElement productName;

    @FindBy(id = "com.androidsample.generalstore:id/appbar_btn_back")
    private WebElement backButton;

    public String getTextFromToolBar(){
        return toolBarTitle.getText();
    }

    public void waitUntilProductListIsDisplayed(){
        //waitForElement(toolBarTitle);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
