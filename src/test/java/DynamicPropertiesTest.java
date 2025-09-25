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

public class DynamicPropertiesTest {
    @Test
    public void dynamicPropertiesTest() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-notifications");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://demoqa.com/");

        String elements = "//div[@class='card-body']//h5[text()='Elements']";
        WebElement elementsButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elements)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementsButton);
        elementsButton.click();

        String dynamicProperties = "//span[@class='text'][text()='Dynamic Properties']";
        WebElement dynamicPropertiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicProperties)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", dynamicPropertiesButton);
        dynamicPropertiesButton.click();

        WebElement enableAfter = wait.until(ExpectedConditions.elementToBeClickable(By.id("enableAfter")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", enableAfter);
        enableAfter.click();

        WebElement visibleAfter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", visibleAfter);
        visibleAfter.click();
    }
}
