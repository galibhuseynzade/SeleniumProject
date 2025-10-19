package util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Js {
    public static void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
