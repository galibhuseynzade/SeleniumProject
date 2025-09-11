import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TextBoxTest {
    @Test
    public void test() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/");

        String elements = "//div[@class='card-body']//h5[text()='Elements']";
        WebElement elementsButton = driver.findElement(By.xpath(elements));
        elementsButton.click();

        String textBox = "//span[text()='Text Box']";
        WebElement textBoxButton = driver.findElement(By.xpath(textBox));
        textBoxButton.click();

        String fullName = "//input[@id='userName']";
        WebElement fullNameTextBox = driver.findElement(By.xpath(fullName));
        fullNameTextBox.click();
        fullNameTextBox.sendKeys("Galib Huseynzade");

        String email = "//input[@id='userEmail']";
        WebElement emailTextBox = driver.findElement(By.xpath(email));
        emailTextBox.click();
        emailTextBox.sendKeys("galibhuseynzade@gmail.com");

        String currentAddress = "//textarea[@id='currentAddress']";
        WebElement currentAddressTextBox = driver.findElement(By.xpath(currentAddress));
        currentAddressTextBox.click();
        currentAddressTextBox.sendKeys("Baku");

        String permanentAddress = "//textarea[@id='permanentAddress']";
        WebElement permanentAddressTextBox = driver.findElement(By.xpath(permanentAddress));
        permanentAddressTextBox.click();
        permanentAddressTextBox.sendKeys("Azerbaijan");

        String submit = "//button[@id='submit']";
        WebElement submitButton = driver.findElement(By.xpath(submit));
        submitButton.click();
    }
}
