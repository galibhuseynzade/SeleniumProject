package pages;

import core.Js;
import core.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class BrowserWindowsPage {

    private final WebDriver driver;
    private final Js js;
    private final Waiter wait;

    public BrowserWindowsPage(WebDriver driver) {
        this.driver = driver;
        this.js = new Js(driver);
        this.wait = new Waiter(driver);
    }

    private final By newTabButton = By.id("tabButton");
    private final By newWindowButton = By.id("windowButton");

    public void openNewTab() {
        WebElement tab = wait.untilClickable(newTabButton);
        js.scrollIntoView(tab);
        tab.click();
    }

    public void openNewWindow() {
        WebElement window = wait.untilClickable(newWindowButton);
        js.scrollIntoView(window);
        window.click();
    }

    public void switchToNewWindow() {
        String mainWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String handle : allWindows) {
            if (!handle.equals(mainWindow)) {
                driver.switchTo().window(handle);
                driver.manage().window().maximize();
                break;
            }
        }
    }

    public void switchBackToMainWindow() {
        driver.switchTo().window(driver.getWindowHandles().iterator().next());
    }
}
