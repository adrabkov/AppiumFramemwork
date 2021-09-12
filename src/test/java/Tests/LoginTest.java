package Tests;

import core.steps.CommonSteps;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Test(dataProvider = "CredentialsData", dataProviderClass = TestData.DataProviders.class)
    public void loginTest(String email, String password) {
        CommonSteps.getLoginSteps().iFillInEmail(email);
        CommonSteps.getLoginSteps().iFillInPassword(password);
        CommonSteps.getLoginSteps().iClickSignInButton();
    }
}
