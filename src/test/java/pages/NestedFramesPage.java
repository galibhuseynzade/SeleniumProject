package pages;

import core.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NestedFramesPage {

    private final WebDriver driver;
    private final Waiter wait;

    public NestedFramesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new Waiter(driver);
    }

    private final By parentFrame = By.id("frame1");
    private final By childFrame = By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']");
    private final By body = By.tagName("body");

    public void switchToParentFrame() {
        driver.switchTo().frame(wait.untilVisible(parentFrame));
    }

    public void switchToChildFrame() {
        WebElement frame = wait.untilVisible(childFrame);
        driver.switchTo().frame(frame);
    }

    public String getBodyText() {
        WebElement text = wait.untilVisible(body);
        return text.getText();
    }

    public void switchToParentFromChild() {
        driver.switchTo().parentFrame();
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
}
