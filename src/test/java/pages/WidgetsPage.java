package pages;

import helper.ClickHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WidgetsPage {

    public WidgetsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[normalize-space()='Slider']")
    WebElement sliderMenu;

    @FindBy(xpath = "//span[normalize-space()='Progress Bar']")
    WebElement progressBarMenu;

    public void openSlider() {
        ClickHelper.click(sliderMenu);
    }

    public void openProgressBar() {
        ClickHelper.click(progressBarMenu);
    }
}
