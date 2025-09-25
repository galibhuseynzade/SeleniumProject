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

public class WebTablesTest {
    @Test
    public void webTablesTest() {
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

        String webTables = "//span[@class='text'][text()='Web Tables']";
        WebElement webTablesButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(webTables)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", webTablesButton);
        webTablesButton.click();

        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("addNewRecordButton")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", addButton);
        addButton.click();

        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Galib");
        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Huseynzade");
        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("galibhuseynzade@gmail.com");
        WebElement age = driver.findElement(By.id("age"));
        age.sendKeys("28");
        WebElement salary = driver.findElement(By.id("salary"));
        salary.sendKeys("100");
        WebElement department = driver.findElement(By.id("department"));
        department.sendKeys("IT Development");
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        String delete = "//div[contains(@class, 'rt-tr')]/div[@class='rt-td' and text()='Cierra']/..//span[@title='Delete']";
        WebElement deleteButton = driver.findElement(By.xpath(delete));
        deleteButton.click();
    }
}
