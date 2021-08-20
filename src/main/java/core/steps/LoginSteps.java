package core.steps;

import core.pages.LoginPage;

public class LoginSteps {
    private LoginPage loginPage = new LoginPage();

    public void iFillInEmail(String email) throws InterruptedException {
        loginPage.setEmailField(email);
    }

    public void iFillInPassword(String password) {
        loginPage.setPasswordField(password);
    }

    public void iClickSignInButton() {
        loginPage.clickSignInButton();
    }


}
