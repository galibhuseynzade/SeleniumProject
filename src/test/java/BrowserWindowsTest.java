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
import java.util.Set;

public class BrowserWindowsTest {
    @Test
    public void browserWindowsTest() {
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

        WebElement browserWindows = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Browser Windows']")));
        browserWindows.click();

        String mainMenu = driver.getWindowHandle();

        WebElement newTab = driver.findElement(By.id("tabButton"));
        newTab.click();

        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(mainMenu)) {
                driver.switchTo().window(windowHandle);
            }
        }

        driver.switchTo().window(mainMenu);

        WebElement newWindow = driver.findElement(By.id("windowButton"));
        newWindow.click();

        Set<String> allNewWindows = driver.getWindowHandles();
        for (String windowHandle : allNewWindows) {
            if (!windowHandle.equals(mainMenu)) {
                driver.switchTo().window(windowHandle);
                driver.manage().window().maximize();
            }
        }
    }
}
