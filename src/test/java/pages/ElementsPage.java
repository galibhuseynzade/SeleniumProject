package pages;

import core.Js;
import core.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementsPage {

    private final WebDriver driver;
    private final Js js;
    private final Waiter wait;

    public ElementsPage(WebDriver driver) {
        this.driver = driver;
        this.js = new Js(driver);
        this.wait = new Waiter(driver);
    }

    private final By textBoxMenu = By.xpath("//span[text()='Text Box']");
    private final By checkBoxMenu = By.xpath("//span[text()='Check Box']");
    private final By radioButtonMenu = By.xpath("//span[text()='Radio Button']");
    private final By webTablesMenu = By.xpath("//span[text()='Web Tables']");
    private final By buttonsMenu = By.xpath("//span[text()='Buttons']");
    private final By linksMenu = By.xpath("//span[text()='Links']");
    private final By uploadDownloadMenu = By.xpath("//span[text()='Upload and Download']");
    private final By dynamicPropertiesMenu = By.xpath("//span[text()='Dynamic Properties']");

    public void openTextBox() {
        WebElement item = wait.untilClickable(textBoxMenu);
        js.scrollIntoView(item);
        item.click();
    }

    public void openCheckBox() {
        WebElement item = wait.untilClickable(checkBoxMenu);
        js.scrollIntoView(item);
        item.click();
    }

    public void openRadioButton() {
        WebElement item = wait.untilClickable(radioButtonMenu);
        js.scrollIntoView(item);
        item.click();
    }

    public void openWebTables() {
        WebElement item = wait.untilClickable(webTablesMenu);
        js.scrollIntoView(item);
        item.click();
    }

    public void openButtons() {
        WebElement item = wait.untilClickable(buttonsMenu);
        js.scrollIntoView(item);
        item.click();
    }

    public void openLinks() {
        WebElement item = wait.untilClickable(linksMenu);
        js.scrollIntoView(item);
        item.click();
    }

    public void openUploadDownload() {
        WebElement item = wait.untilClickable(uploadDownloadMenu);
        js.scrollIntoView(item);
        item.click();
    }

    public void openDynamicProperties() {
        WebElement item = wait.untilClickable(dynamicPropertiesMenu);
        js.scrollIntoView(item);
        item.click();
    }
}
