package pages;

import core.Js;
import core.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProgressBarPage {

    private final WebDriver driver;
    private final Js js;
    private final Waiter wait;

    public ProgressBarPage(WebDriver driver) {
        this.driver = driver;
        this.js = new Js(driver);
        this.wait = new Waiter(driver);
    }

    private final By startStopButton = By.id("startStopButton");
    private final By progressBar = By.xpath("//div[@role='progressbar']");

    public void startProgress() {
        WebElement startButton = wait.untilClickable(startStopButton);
        js.scrollIntoView(startButton);
        startButton.click();
    }

    public void stopWhenValue(int targetValue) {
        WebElement bar = wait.untilVisible(progressBar);
        while (true) {
            String text = bar.getText().replace("%", "").trim();
            if (!text.isEmpty()) {
                int currentValue = Integer.parseInt(text);
                if (currentValue >= targetValue) {
                    driver.findElement(startStopButton).click();
                    break;
                }
            }
        }
    }

    public int getProgressValue() {
        WebElement bar = wait.untilVisible(progressBar);
        String text = bar.getText().replace("%", "").trim();
        return text.isEmpty() ? 0 : Integer.parseInt(text);
    }
}
