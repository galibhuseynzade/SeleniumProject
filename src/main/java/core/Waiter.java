package core;

import config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiter {

    private final WebDriverWait wait;

    public Waiter(WebDriver driver) {
        int timeout = Integer.parseInt(ConfigReader.get("explicitWait"));
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    public WebElement untilVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement untilClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void untilAlertPresent() {
        wait.until(ExpectedConditions.alertIsPresent());
    }
}
