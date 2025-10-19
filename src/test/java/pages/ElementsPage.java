package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import helper.ClickHelper;

public class ElementsPage {
    public ElementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Text Box']")
    WebElement textBoxMenu;

    @FindBy(xpath = "//span[text()='Check Box']")
    WebElement checkBoxMenu;

    @FindBy(xpath = "//span[text()='Radio Button']")
    WebElement radioButtonMenu;

    @FindBy(xpath = "//span[text()='Web Tables']")
    WebElement webTablesMenu;

    @FindBy(xpath = "//span[text()='Buttons']")
    WebElement buttonsMenu;

    @FindBy(xpath = "//span[text()='Links']")
    WebElement linksMenu;

    @FindBy(xpath = "//span[text()='Upload and Download']")
    WebElement uploadDownloadMenu;

    @FindBy(xpath = "//span[text()='Dynamic Properties']")
    WebElement dynamicPropertiesMenu;

    public void openTextBox() {
        ClickHelper.click(textBoxMenu);
    }

    public void openCheckBox() {
        ClickHelper.click(checkBoxMenu);
    }

    public void openRadioButton() {
        ClickHelper.click(radioButtonMenu);
    }

    public void openWebTables() {
        ClickHelper.click(webTablesMenu);
    }

    public void openButtons() {
        ClickHelper.click(buttonsMenu);
    }

    public void openLinks() {
        ClickHelper.click(linksMenu);
    }

    public void openUploadDownload() {
        ClickHelper.click(uploadDownloadMenu);
    }

    public void openDynamicProperties() {
        ClickHelper.click(dynamicPropertiesMenu);
    }
}
