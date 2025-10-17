package pages;

import core.Js;
import core.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonPage {

    private final WebDriver driver;
    private final Js js;
    private final Waiter wait;

    public RadioButtonPage(WebDriver driver) {
        this.driver = driver;
        this.js = new Js(driver);
        this.wait = new Waiter(driver);
    }

    private final By yesRadioLabel = By.xpath("//label[@for='yesRadio']");
    private final By impressiveRadioLabel = By.xpath("//label[@for='impressiveRadio']");
    private final By noRadioLabel = By.xpath("//label[@for='noRadio']");
    private final By resultText = By.xpath("//span[@class='text-success']");

    public void selectYes() {
        WebElement yes = wait.untilClickable(yesRadioLabel);
        js.scrollIntoView(yes);
        yes.click();
    }

    public void selectImpressive() {
        WebElement impressive = wait.untilClickable(impressiveRadioLabel);
        js.scrollIntoView(impressive);
        impressive.click();
    }

    public boolean isNoDisabled() {
        WebElement noLabel = driver.findElement(noRadioLabel);
        String classAttr = noLabel.getAttribute("class");
        return classAttr != null && classAttr.contains("disabled");
    }

    public String getSelectedText() {
        WebElement text = wait.untilVisible(resultText);
        return text.getText();
    }
}
