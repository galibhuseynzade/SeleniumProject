import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class TextBoxTest {
    @Test
    public void textBoxTest() throws InterruptedException {
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

        String textBox = "//span[text()='Text Box']";
        WebElement textBoxButton = driver.findElement(By.xpath(textBox));
        textBoxButton.click();

        String fullName = "//input[@id='userName']";
        String inputFullName = "Galib Huseynzade";
        WebElement fullNameTextBox = driver.findElement(By.xpath(fullName));
        fullNameTextBox.click();
        fullNameTextBox.sendKeys(inputFullName);

        String email = "//input[@id='userEmail']";
        String inputEmail = "galibhuseynzade@gmail.com";
        WebElement emailTextBox = driver.findElement(By.xpath(email));
        emailTextBox.click();
        emailTextBox.sendKeys(inputEmail);

        String currentAddress = "//textarea[@id='currentAddress']";
        String inputCurrentAddress = "Baku";
        WebElement currentAddressTextBox = driver.findElement(By.xpath(currentAddress));
        currentAddressTextBox.click();
        currentAddressTextBox.sendKeys(inputCurrentAddress);

        String permanentAddress = "//textarea[@id='permanentAddress']";
        String inputPermanentAddress = "Azerbaijan";
        WebElement permanentAddressTextBox = driver.findElement(By.xpath(permanentAddress));
        permanentAddressTextBox.click();
        permanentAddressTextBox.sendKeys(inputPermanentAddress);

        String submit = "//button[@id='submit']";
        WebElement submitButton = driver.findElement(By.xpath(submit));
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(1000);
        submitButton.click();

        String output = "//div[@id='output']//div/p[@id='name']";
        WebElement outputText = driver.findElement(By.xpath(output));
        if (outputText.getText().contains("Galib Huseynzade")) System.out.println("Test passed!");
        else System.out.println("Test failed!");

        driver.quit();
    }
}