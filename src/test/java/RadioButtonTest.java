import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class RadioButtonTest {
    @Test
    public void radioButtonTest() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-notifications");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/");

        String elements = "//div[@class='card-body']//h5[text()='Elements']";
        WebElement elementsButton = driver.findElement(By.xpath(elements));
        elementsButton.click();

        String textBox = "//span[text()='Radio Button']";
        WebElement textBoxButton = driver.findElement(By.xpath(textBox));
        textBoxButton.click();

        String noRadio = "//label[@for='noRadio']";
        WebElement noRadioButton = driver.findElement(By.xpath(noRadio));
        String noRadioButtonClass = noRadioButton.getAttribute("class");
        Assertions.assertNotNull(noRadioButtonClass);
        if (noRadioButtonClass.contains("disabled")) System.out.println("No button is disabled");
        else noRadioButton.click();

        String result = "//span[@class='text-success']";
        List<WebElement> resultList = driver.findElements(By.xpath(result));
        List<String> resultTextList = resultList.stream().map(WebElement::getText).toList();
        String resultText = "";

        if (!resultTextList.isEmpty()) {
            resultText = resultTextList.get(0);
            Assertions.assertNotNull(resultText);
        }

        if (resultText.equals("Impressive")) {
            System.out.println(resultText + " already selected");
        } else {
            String impressiveRadio = "//label[@for='impressiveRadio']";
            WebElement impressiveRadioButton = driver.findElement(By.xpath(impressiveRadio));
            String impressiveRadioButtonClass = impressiveRadioButton.getAttribute("class");
            Assertions.assertNotNull(impressiveRadioButtonClass);
            if (impressiveRadioButtonClass.contains("disabled"))
                System.out.println("Impressive button is disabled");
            else impressiveRadioButton.click();

            resultList = driver.findElements(By.xpath(result));
            resultTextList = resultList.stream().map(WebElement::getText).toList();
            if (!resultTextList.isEmpty()) {
                resultText = resultTextList.get(0);
                System.out.println(resultText + " selected");
            }
        }

        driver.quit();
    }
}
