package core.steps;

import core.pages.LoginPage;

public class LoginSteps {
    private final LoginPage loginPage = new LoginPage();

    public void iFillInEmail(String email) {
        loginPage.setEmailField(email);
    }

    public void iFillInPassword(String password) {
        loginPage.setPasswordField(password);
    }

    public void iClickSignInButton() {
        loginPage.clickSignInButton();
    }


}
