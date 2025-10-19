package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import helper.ClickHelper;
import util.Waiter;

public class ButtonsPage {
    private final WebDriver driver;

    public ButtonsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "doubleClickBtn")
    WebElement doubleClickButton;

    @FindBy(id = "rightClickBtn")
    WebElement rightClickButton;

    @FindBy(xpath = "//button[@class='btn btn-primary' and text()='Click Me']")
    WebElement dynamicClickButton;

    @FindBy(id = "doubleClickMessage")
    WebElement doubleClickMessage;

    @FindBy(id = "rightClickMessage")
    WebElement rightClickMessage;

    @FindBy(id = "dynamicClickMessage")
    WebElement dynamicClickMessage;

    public void doubleClick() {
        ClickHelper.doubleClick(driver, doubleClickButton);
    }

    public void rightClick() {
        ClickHelper.rightClick(driver, rightClickButton);
    }

    public void dynamicClick() {
        ClickHelper.click(dynamicClickButton);
    }

    public String getDoubleClickMessage() {
        return Waiter.untilVisible(doubleClickMessage).getText();
    }

    public String getRightClickMessage() {
        return Waiter.untilVisible(rightClickMessage).getText();
    }

    public String getDynamicClickMessage() {
        return Waiter.untilVisible(dynamicClickMessage).getText();
    }
}
