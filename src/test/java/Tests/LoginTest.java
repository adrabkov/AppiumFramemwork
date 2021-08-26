package Tests;

import core.steps.LoginSteps;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {
    private LoginSteps loginSteps = new LoginSteps();

    @Test(dataProvider = "CredentialsData", dataProviderClass = TestData.DataProviders.class)
    public void loginTest(String email, String password) {
        loginSteps.iFillInEmail(email);
        loginSteps.iFillInPassword(password);
        loginSteps.iClickSignInButton();
    }
}
