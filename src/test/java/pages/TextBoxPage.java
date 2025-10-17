package pages;

import core.Js;
import core.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TextBoxPage {

    private final WebDriver driver;
    private final Js js;
    private final Waiter wait;
    private final Actions actions;

    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
        this.js = new Js(driver);
        this.wait = new Waiter(driver);
        this.actions = new Actions(driver);
    }

    private final By fullNameInput = By.id("userName");
    private final By emailInput = By.id("userEmail");
    private final By currentAddressInput = By.id("currentAddress");
    private final By permanentAddressInput = By.id("permanentAddress");
    private final By submitButton = By.id("submit");
    private final By outputName = By.xpath("//div[@id='output']//div/p[@id='name']");

    public void fillFullName(String name) {
        WebElement el = wait.untilClickable(fullNameInput);
        el.clear();
        el.sendKeys(name);
    }

    public void fillEmail(String email) {
        WebElement el = wait.untilClickable(emailInput);
        el.clear();
        el.sendKeys(email);
    }

    public void fillCurrentAddress(String address) {
        WebElement el = wait.untilClickable(currentAddressInput);
        el.clear();
        el.sendKeys(address);
    }

    public void fillPermanentAddress(String address) {
        WebElement el = wait.untilClickable(permanentAddressInput);
        el.clear();
        el.sendKeys(address);
    }

    public void submitForm() {
        WebElement button = wait.untilClickable(submitButton);
        js.scrollIntoView(button);
        actions.moveToElement(button).click().perform();
    }

    public String getOutputNameText() {
        WebElement nameOutput = wait.untilVisible(outputName);
        return nameOutput.getText();
    }
}
