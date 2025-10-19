package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import helper.ClickHelper;

public class DynamicPropertiesPage {
    public DynamicPropertiesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "enableAfter")
    WebElement enableAfterButton;

    @FindBy(id = "visibleAfter")
    WebElement visibleAfterButton;

    public void clickEnableAfter() {
        ClickHelper.click(enableAfterButton);
    }

    public void clickVisibleAfter() {
        ClickHelper.click(visibleAfterButton);
    }
}
