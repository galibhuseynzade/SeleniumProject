package util;

import config.ConfigReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiter {

    private static final WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Integer.parseInt(ConfigReader.get("explicitWait"))));

    public static WebElement untilVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement untilClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static Alert untilAlertPresent() {
        return wait.until(ExpectedConditions.alertIsPresent());
    }
}
