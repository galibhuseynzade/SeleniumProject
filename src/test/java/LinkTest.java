import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LinkTest {
    @Test
    public void linkTest() {
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

        String links = "//span[@class='text'][.='Links']";
        WebElement linksButton = driver.findElement(By.xpath(links));
        linksButton.click();
        String mainMenu = driver.getWindowHandle();

        WebElement homeLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Home")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", homeLink);
        homeLink.click();

        Set<String> allWindows = driver.getWindowHandles();
        List<String> windowList = new ArrayList<>(allWindows);

        for (String window : windowList) {
            if (!window.equals(mainMenu)) {
                driver.switchTo().window(window);
                break;
            }
         }

        System.out.println(driver.getCurrentUrl());

        driver.switchTo().window(mainMenu);

        WebElement createdLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("created")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", createdLink);
        createdLink.click();

        WebElement createdResponse = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='linkResponse']/b")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", createdResponse);
        System.out.println("Created link click response: " + createdLink.getText());
    }
}
