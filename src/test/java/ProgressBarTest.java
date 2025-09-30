import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProgressBarTest {
    @Test
    public void progressBarTest() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-notifications");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://demoqa.com/");

        String widgets = "//div[@class='card-body']//h5[text()='Widgets']";
        WebElement widgetsButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(widgets)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", widgetsButton);
        widgetsButton.click();

        WebElement progressBar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Progress Bar']")));
        progressBar.click();

        WebElement startStopButton = driver.findElement(By.id("startStopButton"));
        startStopButton.click();

        WebElement progressbar = driver.findElement(By.xpath("//div[@role='progressbar']"));
        while (true) {
            if (progressbar.getText().contains("77")) {
                startStopButton.click();
                break;
            }
        }
    }
}
