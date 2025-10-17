package pages;

import core.Js;
import core.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LinksPage {

    private final WebDriver driver;
    private final Js js;
    private final Waiter wait;

    public LinksPage(WebDriver driver) {
        this.driver = driver;
        this.js = new Js(driver);
        this.wait = new Waiter(driver);
    }

    private final By simpleLink = By.id("simpleLink");
    private final By dynamicLink = By.id("dynamicLink");
    private final By createdLink = By.id("created");
    private final By responseStatusCode = By.xpath("//p[@id='linkResponse']/b[1]");
    private final By responseText = By.xpath("//p[@id='linkResponse']/b[2]");

    public void openSimpleLink() {
        WebElement link = wait.untilClickable(simpleLink);
        js.scrollIntoView(link);
        link.click();
    }

    public void openDynamicLink() {
        WebElement link = wait.untilClickable(dynamicLink);
        js.scrollIntoView(link);
        link.click();
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
        WebElement created = wait.untilClickable(createdLink);
        js.scrollIntoView(created);
        created.click();
    }

    public String getResponseStatusCode() {
        WebElement code = wait.untilVisible(responseStatusCode);
        return code.getText();
    }

    public String getResponseText() {
        WebElement text = wait.untilVisible(responseText);
        return text.getText();
    }
}
