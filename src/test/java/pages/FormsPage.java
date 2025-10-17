package pages;

import core.Js;
import core.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormsPage {

    private final WebDriver driver;
    private final Js js;
    private final Waiter wait;

    public FormsPage(WebDriver driver) {
        this.driver = driver;
        this.js = new Js(driver);
        this.wait = new Waiter(driver);
    }

    private final By practiceFormMenu = By.xpath("//span[normalize-space()='Practice Form']");

    public void openPracticeForm() {
        WebElement menu = wait.untilClickable(practiceFormMenu);
        js.scrollIntoView(menu);
        menu.click();
    }
}
