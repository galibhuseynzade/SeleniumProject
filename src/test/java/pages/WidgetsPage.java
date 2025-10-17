package pages;

import core.Js;
import core.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WidgetsPage {

    private final WebDriver driver;
    private final Js js;
    private final Waiter wait;

    public WidgetsPage(WebDriver driver) {
        this.driver = driver;
        this.js = new Js(driver);
        this.wait = new Waiter(driver);
    }

    private final By sliderMenu = By.xpath("//span[normalize-space()='Slider']");
    private final By progressBarMenu = By.xpath("//span[normalize-space()='Progress Bar']");

    public void openSlider() {
        WebElement menu = wait.untilClickable(sliderMenu);
        js.scrollIntoView(menu);
        menu.click();
    }

    public void openProgressBar() {
        WebElement menu = wait.untilClickable(progressBarMenu);
        js.scrollIntoView(menu);
        menu.click();
    }
}
