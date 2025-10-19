package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SliderTest extends BaseTest {

    @Test
    public void verifySliderMovement() {
        HomePage home = new HomePage(driver);
        home.openWidgets();

        WidgetsPage widgets = new WidgetsPage(driver);
        widgets.openSlider();

        SliderPage slider = new SliderPage(driver);
        slider.moveSliderTo(77);

        assertEquals(77, slider.getSliderValue());
    }
}
