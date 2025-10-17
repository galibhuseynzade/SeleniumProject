package core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Js {

    private final JavascriptExecutor js;

    public Js(WebDriver driver) {
        this.js = (JavascriptExecutor) driver;
    }

    public void scrollIntoView(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
