package core.steps;

import core.pages.ProductsListPage;
import org.testng.Assert;

public class AtProductsListPage {

    ProductsListPage atProductsListPage = new ProductsListPage();

    public AtProductsListPage waitUntilProductListIsOpen() {
        atProductsListPage.waitUntilProductListIsDisplayed();
        return this;
    }

    public AtProductsListPage verifyThatRightTabIsOpen(String tabName) {
        Assert.assertEquals(atProductsListPage.getTextFromToolBar(), tabName, tabName + " page is not open");
        return this;
    }

    public AtProductsListPage addProductToCart(){
        atProductsListPage.clickAddToCartButton();
        return this;
    }

    public AtProductsListPage verifyThatAddedToCartButtonNameChangedToAddToCart(){
        atProductsListPage.getAddToCartElement();
        return this;
    }

    public AtProductsListPage verifyThatAddToCartButtonNameChangedToAddedToCart(){
        Assert.assertTrue(atProductsListPage.getAddedToCartElement().isDisplayed(), "The name of the 'Add to cart' button does not changed");
        return this;
    }

    public AtProductsListPage removeAddedProductFromCart(){
        atProductsListPage.removeProductFromCart();
        return this;
    }

    public AtProductsListPage verifyThatCartCounterIsDisplayed(){
        Assert.assertTrue(atProductsListPage.getCounterElement().isDisplayed(), "Counter for the cart is not displayed");
        return this;
    }

    public AtProductsListPage verifyThatCartCounterCountsCorrectly(String productNumber){
        Assert.assertEquals(atProductsListPage.getCountOfCartCounter(), productNumber);
        return this;
    }

    public AtProductsListPage clickCartButton(){
        atProductsListPage.clickTheCartButton();
        return this;
    }

    public AtProductsListPage clickBackButton(){
        atProductsListPage.clickBackButton();
        return this;
    }
}
