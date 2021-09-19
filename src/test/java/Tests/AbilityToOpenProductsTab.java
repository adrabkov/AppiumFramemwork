package Tests;

import org.testng.annotations.Test;

public class AbilityToOpenProductsTab extends BaseTest {
    private String tabName = "Products";

    @Test(dataProvider = "RegistrationData", dataProviderClass = TestData.DataProviders.class)
    public void abilityToOpenProductsTabTest(String country, String name, String gender) {
        user.atFormPage()
                .selectCountryFromDropDown(country)
                .specifyUserName(name)
                .selectGenderOption(gender)
                .clickLetsShopButton();
        user.atProductsListPage()
                .waitUntilProductListIsOpen()
                .verifyThatRightTabIsOpen(tabName);
    }
}
