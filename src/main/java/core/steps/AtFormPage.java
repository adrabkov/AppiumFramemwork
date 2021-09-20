package core.steps;

import core.pages.FormPage;

import static core.TestData.TestVariables.*;


public class AtFormPage {

    FormPage atFormPage = new FormPage();

    public AtFormPage verifyThatFormTabIsOpened(){
        atFormPage.getTitleFromFormTab();
        return this;
    }

    public AtFormPage selectCountryFromDropDown(String country) {
        atFormPage.selectCountry(country);
        return this;
    }

    public AtFormPage specifyUserName(String name) {
        atFormPage.fillNameField(name);
        return this;
    }

    public AtFormPage selectGenderOption(String gender) {
        atFormPage.clickFemaleRadioButton(gender);
        return this;
    }

    public AtFormPage clickLetsShopButton() {
        atFormPage.clickLetsShopButton();
        return this;
    }

    public AtFormPage specifyRegistrationDateAndGoToProductTab(){
        atFormPage.selectCountry(COUNTRY);
        atFormPage.fillNameField(USER_NAME);
        atFormPage.clickFemaleRadioButton(USER_GENDER);
        atFormPage.clickLetsShopButton();
        return this;
    }
}
