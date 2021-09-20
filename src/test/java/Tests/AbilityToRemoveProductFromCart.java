package Tests;

import org.testng.annotations.Test;

public class AbilityToRemoveProductFromCart extends BaseTest {

    @Test
    public void abilityToAddProductToCartTest() {
        user.atFormPage().specifyRegistrationDateAndGoToProductTab();
        user.atProductsListPage()
                .waitUntilProductListIsOpen()
                .addProductToCart()
                .verifyThatCartCounterIsDisplayed()
                .verifyThatAddToCartButtonNameChangedToAddedToCart()
                .removeAddedProductFromCart()
                .verifyThatAddedToCartButtonNameChangedToAddToCart();
    }
}
