package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Js;

import java.util.Objects;

public class SliderPage {
    private final Actions actions;

    public SliderPage(WebDriver driver) {
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@type='range']")
    WebElement sliderInput;

    @FindBy(id = "sliderValue")
    WebElement sliderValue;

    public void moveSliderTo(int targetValue) {
        int startValue = Integer.parseInt(Objects.requireNonNull(sliderValue.getAttribute("value")));
        int width = sliderInput.getSize().getWidth();

        int offset = (targetValue - startValue) * (width / 100);
        Js.scrollIntoView(sliderInput);

        actions.clickAndHold(sliderInput)
                .moveByOffset(offset, 0)
                .release()
                .perform();
    }

    public int getSliderValue() {
        return Integer.parseInt(Objects.requireNonNull(sliderValue.getAttribute("value")));
    }
}
