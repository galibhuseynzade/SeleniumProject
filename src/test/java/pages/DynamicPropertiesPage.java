package pages;

import core.Js;
import core.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DynamicPropertiesPage {

    private final Js js;
    private final Waiter wait;

    public DynamicPropertiesPage(WebDriver driver) {
        this.js = new Js(driver);
        this.wait = new Waiter(driver);
    }

    private final By enableAfterButton = By.id("enableAfter");
    private final By visibleAfterButton = By.id("visibleAfter");

    public void clickEnableAfter() {
        WebElement button = wait.untilClickable(enableAfterButton);
        js.scrollIntoView(button);
        button.click();
    }

    public void clickVisibleAfter() {
        WebElement button = wait.untilVisible(visibleAfterButton);
        js.scrollIntoView(button);
        button.click();
    }
}
