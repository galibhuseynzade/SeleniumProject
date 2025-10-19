package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Waiter;

public class NestedFramesPage {

    private final WebDriver driver;

    public NestedFramesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "frame1")
    WebElement parentFrame;

    @FindBy(xpath = "//iframe[@srcdoc='<p>Child Iframe</p>']")
    WebElement childFrame;

    @FindBy(tagName = "body")
    WebElement body;

    public void switchToParentFrame() {
        driver.switchTo().frame(Waiter.untilVisible(parentFrame));
    }

    public void switchToChildFrame() {
        WebElement frame = Waiter.untilVisible(childFrame);
        driver.switchTo().frame(frame);
    }

    public String getBodyText() {
        WebElement text = Waiter.untilVisible(body);
        return text.getText();
    }

    public void switchToParentFromChild() {
        driver.switchTo().parentFrame();
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
}
