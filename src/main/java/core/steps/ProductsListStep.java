package core.steps;

import org.testng.Assert;

public class ProductsListStep extends BaseStep {

    public ProductsListStep waitUntilProductListIsOpen() {
        productsListPage.waitUntilProductListIsDisplayed();
        return this;
    }

    public ProductsListStep verifyThatRightTabIsOpen(String tabName) {
        Assert.assertEquals(productsListPage.getTextFromToolBar(), tabName, tabName + " page is not open");
        return this;
    }
}
