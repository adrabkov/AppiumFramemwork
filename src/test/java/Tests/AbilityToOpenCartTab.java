package Tests;

import org.testng.annotations.Test;

import static core.TestData.TestVariables.CART_TAB_NAME;

public class AbilityToOpenCartTab extends BaseTest {

    @Test
    public void abilityToOpenCartTabTest() {
        user.atFormPage().specifyRegistrationDateAndGoToProductTab();
        user.atProductsListPage()
                .waitUntilProductListIsOpen()
                .addProductToCart()
                .verifyThatCartCounterIsDisplayed()
                .clickCartButton();
        user.atCartPage()
                .waitUntilCartTabIsOpened()
                .verifyThatCartPageIsOpened(CART_TAB_NAME);
    }
}
