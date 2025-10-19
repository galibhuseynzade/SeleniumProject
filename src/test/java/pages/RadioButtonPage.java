package pages;

import helper.ClickHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Waiter;

public class RadioButtonPage {

    public RadioButtonPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//label[@for='yesRadio']")
    WebElement yesRadioLabel;

    @FindBy(xpath = "//label[@for='impressiveRadio']")
    WebElement impressiveRadioLabel;

    @FindBy(xpath = "//label[@for='noRadio']")
    WebElement noRadioLabel;

    @FindBy(xpath = "//span[@class='text-success']")
    WebElement resultText;

    public void selectYes() {
        ClickHelper.click(yesRadioLabel);
    }

    public void selectImpressive() {
        ClickHelper.click(impressiveRadioLabel);
    }

    public boolean isNoDisabled() {
        String classAttr = noRadioLabel.getAttribute("class");
        return classAttr != null && classAttr.contains("disabled");
    }

    public String getSelectedText() {
        return Waiter.untilVisible(resultText).getText();
    }
}
