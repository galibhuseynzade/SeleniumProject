package pages;

import core.Js;
import core.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlertsFramesWindowsPage {

    private final WebDriver driver;
    private final Js js;
    private final Waiter wait;

    public AlertsFramesWindowsPage(WebDriver driver) {
        this.driver = driver;
        this.js = new Js(driver);
        this.wait = new Waiter(driver);
    }

    // Locators
    private final By browserWindowsMenu = By.xpath("//span[normalize-space()='Browser Windows']");
    private final By alertsMenu = By.xpath("//span[normalize-space()='Alerts']");
    private final By framesMenu = By.xpath("//span[normalize-space()='Frames']");
    private final By nestedFramesMenu = By.xpath("//span[normalize-space()='Nested Frames']");

    // Navigation methods
    public void openBrowserWindows() {
        WebElement menu = wait.untilClickable(browserWindowsMenu);
        js.scrollIntoView(menu);
        menu.click();
    }

    public void openAlerts() {
        WebElement menu = wait.untilClickable(alertsMenu);
        js.scrollIntoView(menu);
        menu.click();
    }

    public void openFrames() {
        WebElement menu = wait.untilClickable(framesMenu);
        js.scrollIntoView(menu);
        menu.click();
    }

    public void openNestedFrames() {
        WebElement menu = wait.untilClickable(nestedFramesMenu);
        js.scrollIntoView(menu);
        menu.click();
    }
}
