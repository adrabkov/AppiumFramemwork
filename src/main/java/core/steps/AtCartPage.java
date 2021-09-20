package core.steps;

import core.pages.CartPage;
import org.testng.Assert;

public class AtCartPage {
    CartPage atCartPage = new CartPage();

    public AtCartPage verifyThatCartPageIsOpened(String tabName){
        Assert.assertEquals(atCartPage.getTextFromCartTab(), tabName, tabName + " tab is not displayed");
        return this;
    }

    public AtCartPage clickBackButton(){
        atCartPage.clickBackButton();
        return this;
    }

    public AtCartPage waitUntilCartTabIsOpened(){
        atCartPage.waitUntilCartTabIsDisplayed();
        return this;
    }

}
