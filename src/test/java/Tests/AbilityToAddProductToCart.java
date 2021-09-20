package Tests;

import org.testng.annotations.Test;

public class AbilityToAddProductToCart extends BaseTest {

    @Test
    public void abilityToAddProductToCartTest() {
        user.atFormPage().specifyRegistrationDateAndGoToProductTab();
        user.atProductsListPage()
                .waitUntilProductListIsOpen()
                .addProductToCart()
                .verifyThatCartCounterIsDisplayed();
    }
}
