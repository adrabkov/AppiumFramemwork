package Tests;

import core.steps.CommonSteps;
import org.testng.annotations.Test;

public class FormTest extends BaseTest{
    private String tabName = "Products";

    @Test(dataProvider = "RegistrationData", dataProviderClass = TestData.DataProviders.class)
    public void signInTest(String country, String name, String gender){
        CommonSteps.getFormSteps().iSelectCountryFromDropDown(country);
        CommonSteps.getFormSteps().iSpecifyName(name);
        CommonSteps.getFormSteps().iSelectFemaleOption(gender);
        CommonSteps.getFormSteps().iClickLetsShopButton();
        CommonSteps.getProductsListStep().waitUntilProductListIsOpen();
        CommonSteps.getProductsListStep().verifyThatRightTabIsOpen(tabName);
    }
}
