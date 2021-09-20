package Tests;

import org.testng.annotations.Test;

import static core.TestData.TestVariables.CART_TAB_NAME;
import static core.TestData.TestVariables.PRODUCT_TAB_NAME;

public class AbilityToPressBackButton extends BaseTest {

    @Test
    public void abilityToPressBackButtonFromProductsTabTest() {
        user.atFormPage().specifyRegistrationDateAndGoToProductTab();
        user.atProductsListPage()
                .waitUntilProductListIsOpen()
                .verifyThatRightTabIsOpen(PRODUCT_TAB_NAME)
                .clickBackButton();
        user.atFormPage().verifyThatFormTabIsOpened();
    }

    @Test
    public void abilityToPressBackButtonFromCartTabTest() {
        user.atFormPage().specifyRegistrationDateAndGoToProductTab();
        user.atProductsListPage()
                .waitUntilProductListIsOpen()
                .verifyThatRightTabIsOpen(PRODUCT_TAB_NAME)
                .addProductToCart()
                .clickCartButton();
        user.atCartPage()
                .waitUntilCartTabIsOpened()
                .verifyThatCartPageIsOpened(CART_TAB_NAME)
                .clickBackButton();
        user.atProductsListPage()
                .waitUntilProductListIsOpen()
                .verifyThatRightTabIsOpen(PRODUCT_TAB_NAME);
    }
}
