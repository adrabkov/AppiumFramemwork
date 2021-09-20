package Tests;

import core.TestData.DataProviders;
import org.testng.annotations.Test;

import static core.TestData.TestVariables.PRODUCT_TAB_NAME;

public class AbilityToOpenProductsTab extends BaseTest {

    @Test(dataProvider = "RegistrationData", dataProviderClass = DataProviders.class)
    public void abilityToOpenProductsTabTest(String country, String name, String gender) {
        user.atFormPage()
                .selectCountryFromDropDown(country)
                .specifyUserName(name)
                .selectGenderOption(gender)
                .clickLetsShopButton();
        user.atProductsListPage()
                .waitUntilProductListIsOpen()
                .verifyThatRightTabIsOpen(PRODUCT_TAB_NAME);
    }
}
