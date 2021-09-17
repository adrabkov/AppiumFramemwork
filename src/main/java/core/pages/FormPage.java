package core.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormPage extends BasePage {

    @FindBy(id = "com.androidsample.generalstore:id/nameField")
    private WebElement nameField;

    @FindBy(xpath = "//*[@text='Female']")
    private WebElement femaleOption;

    @FindBy(id = "android:id/text1")
    private WebElement countrySelection;

    @FindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    private WebElement letsShopButton;

    public void fillNameField(String name) {
        nameField.sendKeys(name);
    }

    public void clickFemaleRadioButton(String gender) {
        driver.findElement(By.xpath("//*[@text='" + gender + "']")).click();
        femaleOption.click();
    }

    public void selectCountry(String country) {
        countrySelection.click();
        scrollToText(country);
        //scroll(driver.findElement(By.xpath("//*[@text='" + country + "']")));
        driver.findElement(By.xpath("//*[@text='" + country + "']")).click();


    }

    public void clickLetsShopButton() {
        letsShopButton.click();
    }

}
