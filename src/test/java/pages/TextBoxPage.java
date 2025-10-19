package pages;

import helper.ClickHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Waiter;

public class TextBoxPage {
    public TextBoxPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userName")
    WebElement fullNameInput;

    @FindBy(id = "userEmail")
    WebElement emailInput;

    @FindBy(id = "currentAddress")
    WebElement currentAddressInput;

    @FindBy(id = "permanentAddress")
    WebElement permanentAddressInput;

    @FindBy(id = "submit")
    WebElement submitButton;

    @FindBy(xpath = "//div[@id='output']//div/p[@id='name']")
    WebElement outputName;

    public void fillFullName(String name) {
        Waiter.untilClickable(fullNameInput).sendKeys(name);
    }

    public void fillEmail(String email) {
        Waiter.untilClickable(emailInput).sendKeys(email);
    }

    public void fillCurrentAddress(String address) {
        Waiter.untilClickable(currentAddressInput).sendKeys(address);
    }

    public void fillPermanentAddress(String address) {
        Waiter.untilClickable(permanentAddressInput).sendKeys(address);
    }

    public void submitForm() {
        ClickHelper.click(submitButton);
    }

    public String getOutputNameText() {
        return Waiter.untilVisible(outputName).getText();
    }
}
