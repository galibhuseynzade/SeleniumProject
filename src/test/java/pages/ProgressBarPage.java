package pages;

import helper.ClickHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Waiter;

public class ProgressBarPage {

    public ProgressBarPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "startStopButton")
    WebElement startStopButton;

    @FindBy(xpath = "//div[@role='progressbar']")
    WebElement progressBar;

    public void startProgress() {
        ClickHelper.click(startStopButton);
    }

    public void stopWhenValue(int targetValue) {
        WebElement bar = Waiter.untilVisible(progressBar);
        while (true) {
            String text = bar.getText().replace("%", "").trim();
            if (!text.isEmpty()) {
                int currentValue = Integer.parseInt(text);
                if (currentValue >= targetValue) {
                    startProgress();
                    break;
                }
            }
        }
    }

    public int getProgressValue() {
        WebElement bar = Waiter.untilVisible(progressBar);
        String text = bar.getText().replace("%", "").trim();
        return text.isEmpty() ? 0 : Integer.parseInt(text);
    }
}
