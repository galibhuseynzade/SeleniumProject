package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import helper.ClickHelper;
import util.Waiter;

import java.util.List;
import java.util.stream.Collectors;

public class CheckBoxPage {
    public CheckBoxPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@title='Expand all']")
    WebElement expandAllButton;

    @FindBy(xpath = "//span[@class='rct-title'][text()='Desktop']")
    WebElement desktopCheckbox;

    @FindBy(xpath = "//span[@class='rct-title'][text()='React']")
    WebElement reactCheckbox;

    @FindBy(xpath = "//span[@class='rct-title'][text()='Angular']")
    WebElement angularCheckbox;

    @FindBy(xpath = "//span[@class='text-success']")
    List<WebElement> resultLabels;

    @FindBy(xpath = "//label[@for='tree-node-home']//span[@class='rct-checkbox']//*[local-name()='svg' and contains(@class,'half')]")
    WebElement halfCheckedHomeIcon;

    public void expandAll() {
        ClickHelper.click(expandAllButton);
    }

    public void selectDesktop() {
        ClickHelper.click(desktopCheckbox);
    }

    public void selectReact() {
        ClickHelper.click(reactCheckbox);
    }

    public void selectAngular() {
        ClickHelper.click(angularCheckbox);
    }

    public List<String> getSelectedResults() {
        return resultLabels.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public boolean isHomeHalfSelected() {
        return Waiter.untilVisible(halfCheckedHomeIcon).isDisplayed();
    }
}
