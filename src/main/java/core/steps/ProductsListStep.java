package core.steps;

import core.pages.ProductsListPage;
import org.testng.Assert;

public class ProductsListStep {
    ProductsListPage productsListPage = new ProductsListPage();

    public void waitUntilProductListIsOpen(){
        productsListPage.waitUntilProductListIsDisplayed();
    }

    public void verifyThatRightTabIsOpen(String tabName){
        Assert.assertEquals(productsListPage.getTextFromToolBar(), tabName,  tabName + " page is not open");
    }
}
