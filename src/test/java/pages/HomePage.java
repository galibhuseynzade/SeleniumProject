package pages;

import core.Js;
import core.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private final WebDriver driver;
    private final Js js;
    private final Waiter wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.js = new Js(driver);
        this.wait = new Waiter(driver);
    }

    private final By elementsCard = By.xpath("//div[@class='card-body']//h5[text()='Elements']");
    private final By formsCard = By.xpath("//div[@class='card-body']//h5[text()='Forms']");
    private final By alertsFrameWindowsCard = By.xpath("//div[@class='card-body']//h5[text()='Alerts, Frame & Windows']");
    private final By widgetsCard = By.xpath("//div[@class='card-body']//h5[text()='Widgets']");

    public void openElements() {
        WebElement element = wait.untilClickable(elementsCard);
        js.scrollIntoView(element);
        element.click();
    }

    public void openForms() {
        WebElement element = wait.untilClickable(formsCard);
        js.scrollIntoView(element);
        element.click();
    }

    public void openAlertsFramesWindows() {
        WebElement element = wait.untilClickable(alertsFrameWindowsCard);
        js.scrollIntoView(element);
        element.click();
    }

    public void openWidgets() {
        WebElement element = wait.untilClickable(widgetsCard);
        js.scrollIntoView(element);
        element.click();
    }
}
