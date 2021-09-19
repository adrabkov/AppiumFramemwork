package core.steps;

import core.pages.FormPage;

public class AtFormPage {

    FormPage atFormPage = new FormPage();

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
}
