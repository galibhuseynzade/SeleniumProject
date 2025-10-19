package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import helper.ClickHelper;

import java.util.Set;

public class BrowserWindowsPage {

    private final WebDriver driver;

    public BrowserWindowsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "tabButton")
    WebElement newTabButton;

    @FindBy(id = "windowButton")
    WebElement newWindowButton;

    public void openNewTab() {
        ClickHelper.click(newTabButton);
    }

    public void openNewWindow() {
        ClickHelper.click(newWindowButton);
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
