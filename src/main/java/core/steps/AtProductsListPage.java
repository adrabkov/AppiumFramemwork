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
}
