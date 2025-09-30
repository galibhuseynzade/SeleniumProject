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
import java.util.List;

public class NestedFrameTest {
    @Test
    public void nestedFrameTest() {
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

        WebElement frames = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Nested Frames']")));
        frames.click();

        driver.switchTo().frame("frame1");

        WebElement body = driver.findElement(By.xpath("//body[.='Parent frame']"));
        System.out.println(body.getText());

        WebElement frame2 = driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));
        driver.switchTo().frame(frame2);
        body = driver.findElement(By.xpath("//body[.='Child Iframe']"));
        System.out.println(body.getText());

        driver.switchTo().parentFrame();
        body = driver.findElement(By.xpath("//body[.='Parent frame']"));
        System.out.println(body.getText());

        driver.switchTo().defaultContent();
    }
}
