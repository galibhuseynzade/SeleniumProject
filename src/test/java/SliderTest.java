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

import java.time.Duration;
import java.util.Objects;

public class SliderTest {
    @Test
    public void sliderTest() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-notifications");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://demoqa.com/");

        String widgets = "//div[@class='card-body']//h5[text()='Widgets']";
        WebElement widgetsButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(widgets)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", widgetsButton);
        widgetsButton.click();

        WebElement sliderButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Slider']")));
        sliderButton.click();

        WebElement startValue = driver.findElement(By.xpath("//input[@id='sliderValue']"));
        int startValueInt = Integer.parseInt(Objects.requireNonNull(startValue.getAttribute("value")));
        int target = 77;

        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
        int width = slider.getSize().getWidth();
        System.out.println("width: " + width);

        int offset = (target - startValueInt) * (width / 100);

        actions.clickAndHold(slider)
                .moveByOffset(offset, 0)
                .release()
                .perform();


        System.out.println("Final value: " + driver.findElement(By.xpath("//input[@type='range']")).getAttribute("value"));

    }
}
