import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class FileDownloadUploadTest {
    @Test
    public void fileDownloadUploadTest() throws InterruptedException {
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

        String uploadDownload = "//span[@class='text'][text()='Upload and Download']";
        WebElement uploadDownloadButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uploadDownload)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", uploadDownloadButton);
        uploadDownloadButton.click();

        WebElement downloadButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("downloadButton")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", downloadButton);
        downloadButton.click();

        Thread.sleep(2000);

        String filePath = "C:/Users/galib/Downloads/";
        String fileName = "sampleFile.jpeg";
        File file = new File(filePath + fileName);

        if (file.exists()) {
            System.out.println("File downloaded successfully");
        } else {
            System.out.println("File not found");
        }

        WebElement uploadButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("uploadFile")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", uploadButton);
        uploadButton.sendKeys(filePath);
    }
}
