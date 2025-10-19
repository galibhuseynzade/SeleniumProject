package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import util.Js;
import util.Waiter;

public class ClickHelper {
    public static void click(WebElement element) {
        setUp(element);
        element.click();
    }

    public static void rightClick(WebDriver driver, WebElement element) {
        setUp(element);
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }

    public static void doubleClick(WebDriver driver, WebElement element) {
        setUp(element);
        Actions actions = new Actions(driver);
        element.click();
        actions.doubleClick(element).perform();
    }

    private static void setUp(WebElement element) {
        Waiter.untilClickable(element);
        Js.scrollIntoView(element);
    }
}
