package core.steps;

import core.pages.FormPage;

import java.text.Normalizer;

public class FormStep {
    private final FormPage formPage = new FormPage();

    public void iSelectCountryFromDropDown(String country){
        formPage.selectCountry(country);
    }

    public void iSpecifyName(String name){
        formPage.fillNameField(name);
    }

    public void iSelectFemaleOption(String gender){
        formPage.clickFemaleRadioButton(gender);
    }

    public void iClickLetsShopButton(){
        formPage.clickLetsShopButton();
    }
}
