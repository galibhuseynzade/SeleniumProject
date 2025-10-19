package pages;

import helper.ClickHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='card-body']//h5[text()='Elements']")
    WebElement elementsCard;

    @FindBy(xpath = "//div[@class='card-body']//h5[text()='Forms']")
    WebElement formsCards;

    @FindBy(xpath = "//div[@class='card-body']//h5[text()='Alerts, Frame & Windows']")
    WebElement alertsFrameWindowsCard;

    @FindBy(xpath = "//div[@class='card-body']//h5[text()='Widgets']")
    WebElement widgetsCard;

    public void openElements() {
        ClickHelper.click(elementsCard);
    }

    public void openForms() {
        ClickHelper.click(formsCards);
    }

    public void openAlertsFramesWindows() {
        ClickHelper.click(alertsFrameWindowsCard);
    }

    public void openWidgets() {
        ClickHelper.click(widgetsCard);
    }
}
