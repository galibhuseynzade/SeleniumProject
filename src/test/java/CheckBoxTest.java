import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class CheckBoxTest {
    @Test
    public void checkboxTest() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-notifications");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);

        driver.get("https://demoqa.com/");

        String elements = "//div[@class='card-body']//h5[text()='Elements']";
        WebElement elementsButton = driver.findElement(By.xpath(elements));
        elementsButton.click();

        String checkBox = "//span[text()='Check Box']";
        WebElement checkBoxButton = driver.findElement(By.xpath(checkBox));
        checkBoxButton.click();

        String expandAll = "//button[@title='Expand all']";
        WebElement expandAllButton = driver.findElement(By.xpath(expandAll));
        expandAllButton.click();

        String spanText = "//span[@class='rct-text']";
        WebElement spanTextButton = driver.findElement(By.xpath(spanText));
        WebElement svg = spanTextButton.findElement(By.tagName("svg"));
        String iconClass = svg.getAttribute("class");
        Assertions.assertNotNull(iconClass);
        if (iconClass.contains("open")) {

            String desktop = "//span[@class='rct-title'][text()='Desktop']";
            if (!driver.findElements(By.xpath(desktop)).isEmpty()) {
                WebElement desktopButton = driver.findElement(By.xpath(desktop));
                desktopButton.click();
            }

            String react = "//span[@class='rct-title'][text()='React']";
            if (!driver.findElements(By.xpath(react)).isEmpty()) {
                WebElement reactButton = driver.findElement(By.xpath(react));
                reactButton.click();
            }

            String angular = "//span[@class='rct-title'][text()='Angular']";
            if (!driver.findElements(By.xpath(angular)).isEmpty()) {
                WebElement angularButton = driver.findElement(By.xpath(angular));
                angularButton.click();
            }

            actions.sendKeys(Keys.PAGE_DOWN).perform();

            String result = "//span[@class='text-success']";
            List<WebElement> resultList = driver.findElements(By.xpath(result));
            List<String> resultText = resultList.stream().map(WebElement::getText).toList();
            System.out.println(resultText);
        } else System.out.println("Test failed!");

        driver.quit();
    }
}
