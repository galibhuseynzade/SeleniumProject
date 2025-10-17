package pages;

import core.Js;
import core.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Objects;

public class SliderPage {

    private final WebDriver driver;
    private final Js js;
    private final Waiter wait;
    private final Actions actions;

    public SliderPage(WebDriver driver) {
        this.driver = driver;
        this.js = new Js(driver);
        this.wait = new Waiter(driver);
        this.actions = new Actions(driver);
    }

    private final By sliderInput = By.xpath("//input[@type='range']");
    private final By sliderValue = By.id("sliderValue");

    public void moveSliderTo(int targetValue) {
        WebElement slider = wait.untilVisible(sliderInput);
        WebElement valueField = wait.untilVisible(sliderValue);

        int startValue = Integer.parseInt(Objects.requireNonNull(valueField.getAttribute("value")));
        int width = slider.getSize().getWidth();

        int offset = (targetValue - startValue) * (width / 100);
        js.scrollIntoView(slider);

        actions.clickAndHold(slider)
                .moveByOffset(offset, 0)
                .release()
                .perform();
    }

    public int getSliderValue() {
        WebElement valueField = wait.untilVisible(sliderValue);
        return Integer.parseInt(valueField.getAttribute("value"));
    }
}
