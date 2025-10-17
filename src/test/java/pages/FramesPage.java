package pages;

import core.Js;
import core.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FramesPage {

    private final WebDriver driver;
    private final Js js;
    private final Waiter wait;

    public FramesPage(WebDriver driver) {
        this.driver = driver;
        this.js = new Js(driver);
        this.wait = new Waiter(driver);
    }

    private final By frame1 = By.id("frame1");
    private final By frame2 = By.id("frame2");
    private final By sampleHeading = By.id("sampleHeading");

    public void switchToFrame1() {
        driver.switchTo().frame(wait.untilVisible(frame1));
    }

    public void switchToFrame2() {
        driver.switchTo().frame(wait.untilVisible(frame2));
    }

    public String getFrameText() {
        WebElement text = wait.untilVisible(sampleHeading);
        return text.getText();
    }

    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }
}
