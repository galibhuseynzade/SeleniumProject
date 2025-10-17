package pages;

import core.Js;
import core.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ButtonsPage {

    private final WebDriver driver;
    private final Js js;
    private final Waiter wait;
    private final Actions actions;

    public ButtonsPage(WebDriver driver) {
        this.driver = driver;
        this.js = new Js(driver);
        this.wait = new Waiter(driver);
        this.actions = new Actions(driver);
    }

    private final By doubleClickButton = By.id("doubleClickBtn");
    private final By rightClickButton = By.id("rightClickBtn");
    private final By dynamicClickButton = By.xpath("//button[@class='btn btn-primary' and text()='Click Me']");

    private final By doubleClickMessage = By.id("doubleClickMessage");
    private final By rightClickMessage = By.id("rightClickMessage");
    private final By dynamicClickMessage = By.id("dynamicClickMessage");

    public void doubleClick() {
        WebElement btn = wait.untilClickable(doubleClickButton);
        js.scrollIntoView(btn);
        actions.doubleClick(btn).perform();
    }

    public void rightClick() {
        WebElement btn = wait.untilClickable(rightClickButton);
        js.scrollIntoView(btn);
        actions.contextClick(btn).perform();
    }

    public void dynamicClick() {
        WebElement btn = wait.untilClickable(dynamicClickButton);
        js.scrollIntoView(btn);
        btn.click();
    }

    public String getDoubleClickMessage() {
        return wait.untilVisible(doubleClickMessage).getText();
    }

    public String getRightClickMessage() {
        return wait.untilVisible(rightClickMessage).getText();
    }

    public String getDynamicClickMessage() {
        return wait.untilVisible(dynamicClickMessage).getText();
    }
}
