import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class PracticeFormTest {
    @Test
    public void practiceVoidTest() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-notifications");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://demoqa.com/");

        String forms = "//div[@class='card-body']//h5[text()='Forms']";
        WebElement formsButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(forms)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", formsButton);
        formsButton.click();

        String practiceForm = "//span[@class='text'][text()='Practice Form']";
        WebElement practiceFormButton =  driver.findElement(By.xpath(practiceForm));
        practiceFormButton.click();

        WebElement firstName = wait.until(ExpectedConditions.elementToBeClickable(By.id("firstName")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstName);
        firstName.sendKeys("Galib");

        WebElement lastName = wait.until(ExpectedConditions.elementToBeClickable(By.id("lastName")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lastName);
        lastName.sendKeys("Huseynzade");

        WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.id("userEmail")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", email);
        email.sendKeys("galibhuseynzade@gmail.com");

        WebElement gender = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(@for, 'gender')][text()='Male']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", gender);
        gender.click();

        WebElement mobileNumber = wait.until(ExpectedConditions.elementToBeClickable(By.id("userNumber")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mobileNumber);
        mobileNumber.sendKeys("0773782729");

        WebElement birthDate = wait.until(ExpectedConditions.elementToBeClickable(By.id("dateOfBirthInput")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", birthDate);
        birthDate.click();

        WebElement year = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@class='react-datepicker__year-select']")));
        Select yearSelect = new Select(year);
        yearSelect.selectByVisibleText("1998");

        WebElement month = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@class='react-datepicker__month-select']")));
        Select monthSelect = new Select(month);
        monthSelect.selectByVisibleText("April");

        WebElement day = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='react-datepicker__week']/div[@class='react-datepicker__day react-datepicker__day--003']")));
        day.click();

        WebElement subject = driver.findElement(By.id("subjectsInput"));
        subject.click();
        subject.sendKeys("Eng");
        actions.sendKeys(Keys.ENTER).perform();

        WebElement sports = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(@for, 'hobbies')][text()='Sports']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", sports);
        sports.click();

        String filepath = "C:\\Users\\galib.huseynzade.n\\Downloads\\background.jpg";
        File file = new File(filepath);

        if (file.exists()) {
            WebElement uploadPicture = driver.findElement(By.id("uploadPicture"));
            uploadPicture.sendKeys(filepath);
        } else {
            System.out.println("File Not Found");
        }

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Baku, Azerbaijan");

        String state = "//div[contains(@class, 'placeholder')][.='Select State']/../following-sibling::div//div[contains(@class,'indicatorContainer')]";
        WebElement selectState = driver.findElement(By.xpath(state));
        selectState.click();

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
    }
}
