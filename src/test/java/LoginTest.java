import core.steps.LoginSteps;
import org.junit.Test;

public class LoginTest extends BaseTest {
    private LoginSteps loginSteps = new LoginSteps();
    private final String email = "test@gmail.com";
    private final String password = "12345678";


    @Test
    public void loginTest() throws InterruptedException {
        loginSteps.iFillInEmail(email);
        loginSteps.iFillInPassword(password);
        loginSteps.iClickSignInButton();


    }
}
