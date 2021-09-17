package core.steps;

import org.testng.Assert;

public class AtProductsListStep extends BaseStep {

    public AtProductsListStep waitUntilProductListIsOpen() {
        productsListPage.waitUntilProductListIsDisplayed();
        return this;
    }

    public AtProductsListStep verifyThatRightTabIsOpen(String tabName) {
        Assert.assertEquals(productsListPage.getTextFromToolBar(), tabName, tabName + " page is not open");
        return this;
    }
}
