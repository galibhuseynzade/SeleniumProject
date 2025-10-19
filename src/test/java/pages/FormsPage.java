package pages;

import helper.ClickHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormsPage {

    public FormsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[normalize-space()='Practice Form']")
    WebElement practiceFormMenu;

    public void openPracticeForm() {
        ClickHelper.click(practiceFormMenu);
    }
}
