import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ButtonTest {
    @Test
    public void buttonTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-notifications");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://demoqa.com/");

        String elements = "//div[@class='card-body']//h5[text()='Elements']";
        WebElement elementsButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elements)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementsButton);
        elementsButton.click();

        String buttons = "//span[text()='Buttons']";
        WebElement buttonsButton = driver.findElement(By.xpath(buttons));
        buttonsButton.click();

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);

        String doubleClickSuccessMessage = "You have done a double click";
        WebElement doubleClickButton = driver.findElement(By.id("doubleClickBtn"));
        actions.doubleClick(doubleClickButton).perform();

        String rightClickSuccessMessage = "You have done a right click";
        WebElement rightClickButton = driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(rightClickButton).perform();

        String dynamicClickSuccessMessage = "You have done a dynamic click";
        WebElement dynamicClickButton = driver.findElement(By.xpath("//button[@class='btn btn-primary'][.='Click Me']"));
        dynamicClickButton.click();

        List<WebElement> doubleClickMessageList = driver.findElements(By.id("doubleClickMessage"));
        if (!doubleClickMessageList.isEmpty()){
            if (doubleClickMessageList.get(0).getText().equals(doubleClickSuccessMessage)){
                System.out.println("Double click successful");
            }
        }

        List<WebElement> rightClickMessageList = driver.findElements(By.id("rightClickMessage"));
        if (!rightClickMessageList.isEmpty()){
            if (rightClickMessageList.get(0).getText().equals(rightClickSuccessMessage)){
                System.out.println("Right click successful");
            }
        }

        List<WebElement> clickMessageList = driver.findElements(By.id("dynamicClickMessage"));
        if (!clickMessageList.isEmpty()){
            if (clickMessageList.get(0).getText().equals(dynamicClickSuccessMessage)){
                System.out.println("Dynamic click successful");
            }
        }
    }
}
