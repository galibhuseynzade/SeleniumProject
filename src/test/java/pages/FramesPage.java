package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Waiter;

public class FramesPage {

    private final WebDriver driver;

    public FramesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "frame1")
    WebElement frame1;

    @FindBy(id = "frame2")
    WebElement frame2;

    @FindBy(id = "sampleHeading")
    WebElement sampleHeading;

    public void switchToFrame1() {
        driver.switchTo().frame(Waiter.untilVisible(frame1));
    }

    public void switchToFrame2() {
        driver.switchTo().frame(Waiter.untilVisible(frame2));
    }

    public String getFrameText() {
        return Waiter.untilVisible(sampleHeading).getText();
    }

    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }
}
