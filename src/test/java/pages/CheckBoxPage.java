package pages;

import core.Js;
import core.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class CheckBoxPage {

    private final WebDriver driver;
    private final Js js;
    private final Waiter wait;

    public CheckBoxPage(WebDriver driver) {
        this.driver = driver;
        this.js = new Js(driver);
        this.wait = new Waiter(driver);
    }

    private final By expandAllButton = By.xpath("//button[@title='Expand all']");
    private final By desktopCheckbox = By.xpath("//span[@class='rct-title'][text()='Desktop']");
    private final By reactCheckbox = By.xpath("//span[@class='rct-title'][text()='React']");
    private final By angularCheckbox = By.xpath("//span[@class='rct-title'][text()='Angular']");
    private final By resultLabels = By.xpath("//span[@class='text-success']");
    private By halfCheckedHomeIcon = By.xpath("//label[@for='tree-node-home']//span[@class='rct-checkbox']//*[local-name()='svg' and contains(@class,'half')]");

    public void expandAll() {
        WebElement expandBtn = wait.untilClickable(expandAllButton);
        js.scrollIntoView(expandBtn);
        expandBtn.click();
    }

    public void selectDesktop() {
        WebElement item = wait.untilClickable(desktopCheckbox);
        js.scrollIntoView(item);
        item.click();
    }

    public void selectReact() {
        WebElement item = wait.untilClickable(reactCheckbox);
        js.scrollIntoView(item);
        item.click();
    }

    public void selectAngular() {
        WebElement item = wait.untilClickable(angularCheckbox);
        js.scrollIntoView(item);
        item.click();
    }

    public List<String> getSelectedResults() {
        List<WebElement> elements = driver.findElements(resultLabels);
        return elements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public boolean isHomeHalfSelected() {
        WebElement icon = wait.untilVisible(halfCheckedHomeIcon);
        return icon.isDisplayed();
    }
}
