package pages;

import core.Js;
import core.Waiter;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlertsPage {

    private final WebDriver driver;
    private final Js js;
    private final Waiter wait;

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
        this.js = new Js(driver);
        this.wait = new Waiter(driver);
    }

    private final By alertButton = By.id("alertButton");
    private final By timerAlertButton = By.id("timerAlertButton");
    private final By confirmButton = By.id("confirmButton");
    private final By promptButton = By.id("promtButton");

    public void triggerImmediateAlert() {
        WebElement btn = wait.untilClickable(alertButton);
        js.scrollIntoView(btn);
        btn.click();
        wait.untilAlertPresent();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void triggerTimerAlert() {
        WebElement btn = wait.untilClickable(timerAlertButton);
        js.scrollIntoView(btn);
        btn.click();
        wait.untilAlertPresent();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void triggerConfirmAlert(boolean accept) {
        WebElement btn = wait.untilClickable(confirmButton);
        js.scrollIntoView(btn);
        btn.click();
        wait.untilAlertPresent();
        Alert alert = driver.switchTo().alert();
        if (accept) alert.accept();
        else alert.dismiss();
    }

    public void triggerPromptAlert(String inputText) {
        WebElement btn = wait.untilClickable(promptButton);
        js.scrollIntoView(btn);
        btn.click();
        wait.untilAlertPresent();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(inputText);
        alert.accept();
    }
}
