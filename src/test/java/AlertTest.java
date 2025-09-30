import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertTest {
    @Test
    public void testAlert() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-notifications");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://demoqa.com/");

        String windows = "//div[@class='card-body']//h5[text()='Alerts, Frame & Windows']";
        WebElement windowsButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(windows)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", windowsButton);
        windowsButton.click();

        WebElement alerts = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Alerts']")));
        alerts.click();

        WebElement clickMeAlert = driver.findElement(By.id("alertButton"));
        clickMeAlert.click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(2000);
        alert.accept();

        WebElement timerAlertButton = driver.findElement(By.id("timerAlertButton"));
        timerAlertButton.click();

        alert = wait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(2000);
        alert.accept();

        WebElement confirmButton = driver.findElement(By.id("confirmButton"));
        confirmButton.click();

        alert = wait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(2000);
        alert.dismiss();

        WebElement promtButton = driver.findElement(By.id("promtButton"));
        promtButton.click();

        alert = wait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(2000);
        alert.sendKeys("hello");
        alert.accept();

    }
}
