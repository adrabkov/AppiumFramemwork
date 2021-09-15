package Tests;

import org.testng.annotations.Test;

public class FormTest extends BaseTest {
    private String tabName = "Products";

    @Test(dataProvider = "RegistrationData", dataProviderClass = TestData.DataProviders.class)
    public void signInTest(String country, String name, String gender) {
        steps.getFormSteps()
                .iSelectCountryFromDropDown(country)
                .iSpecifyName(name)
                .iSelectFemaleOption(gender)
                .iClickLetsShopButton();
        steps.getProductsListStep()
                .waitUntilProductListIsOpen()
                .verifyThatRightTabIsOpen(tabName);
    }
}
