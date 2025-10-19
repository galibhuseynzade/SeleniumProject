package pages;

import helper.ClickHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LinksPage {

    private final WebDriver driver;

    public LinksPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "simpleLink")
    WebElement simpleLink;

    @FindBy(id = "dynamicLink")
    WebElement dynamicLink;

    @FindBy(id = "created")
    WebElement createdLink;

    @FindBy(xpath = "//p[@id='linkResponse']/b[1]")
    WebElement responseStatusCode;

    @FindBy(xpath = "//p[@id='linkResponse']/b[2]")
    WebElement responseText;

    public void openSimpleLink() {
        ClickHelper.click(simpleLink);
    }

    public void openDynamicLink() {
        ClickHelper.click(dynamicLink);
    }

    public void switchToNewTab() {
        String main = driver.getWindowHandle();
        Set<String> allTabs = driver.getWindowHandles();
        List<String> tabs = new ArrayList<>(allTabs);
        for (String handle : tabs) {
            if (!handle.equals(main)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    public void switchBackToMainTab() {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
    }

    public void clickCreatedLink() {
        ClickHelper.click(createdLink);
    }

    public String getResponseStatusCode() {
        return responseStatusCode.getText();
    }

    public String getResponseText() {
        return responseText.getText();
    }
}
