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

public class FrameTest {
    @Test
    public void frameTest() {
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

        WebElement frames = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Frames']")));
        frames.click();

        driver.switchTo().frame("frame1");

        WebElement textElement = driver.findElement(By.id("sampleHeading"));
        String text = textElement.getText();
        System.out.println(text);

        driver.switchTo().defaultContent();

    }
}
