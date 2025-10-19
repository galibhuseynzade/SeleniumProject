package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import helper.ClickHelper;
import util.Waiter;

public class AlertsPage {
    public AlertsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "alertButton")
    WebElement alertButton;

    @FindBy(id = "timerAlertButton")
    WebElement timerAlertButton;

    @FindBy(id = "confirmButton")
    WebElement confirmButton;

    @FindBy(id = "promtButton")
    WebElement promptButton;

    public void triggerImmediateAlert() {
        ClickHelper.click(alertButton);
        Waiter.untilAlertPresent().accept();
    }

    public void triggerTimerAlert() {
        ClickHelper.click(timerAlertButton);
        Waiter.untilAlertPresent().accept();
    }

    public void triggerConfirmAlert() {
        ClickHelper.click(confirmButton);
        Waiter.untilAlertPresent().dismiss();
    }

    public void triggerPromptAlert(String inputText) {
        ClickHelper.click(promptButton);
        Waiter.untilAlertPresent().sendKeys(inputText);
        Waiter.untilAlertPresent().accept();
    }
}
