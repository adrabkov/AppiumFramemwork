package core.steps;

public class FormStep extends BaseStep {

    public FormStep iSelectCountryFromDropDown(String country) {
        formPage.selectCountry(country);
        return this;
    }

    public FormStep iSpecifyName(String name) {
        formPage.fillNameField(name);
        return this;
    }

    public FormStep iSelectFemaleOption(String gender) {
        formPage.clickFemaleRadioButton(gender);
        return this;
    }

    public FormStep iClickLetsShopButton() {
        formPage.clickLetsShopButton();
        return this;
    }
}
