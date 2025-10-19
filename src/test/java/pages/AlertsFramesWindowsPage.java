package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import helper.ClickHelper;

public class AlertsFramesWindowsPage {
    public AlertsFramesWindowsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[normalize-space()='Browser Windows']")
    WebElement browserWindowsMenu;

    @FindBy(xpath = "//span[normalize-space()='Alerts']")
    WebElement alertsMenu;

    @FindBy(xpath = "//span[normalize-space()='Frames']")
    WebElement framesMenu;

    @FindBy(xpath = "//span[normalize-space()='Nested Frames']")
    WebElement nestedFramesMenu;

    public void openBrowserWindows() {
        ClickHelper.click(browserWindowsMenu);
    }

    public void openAlerts() {
        ClickHelper.click(alertsMenu);
    }

    public void openFrames() {
        ClickHelper.click(framesMenu);
    }

    public void openNestedFrames() {
        ClickHelper.click(nestedFramesMenu);
    }
}
