package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.*;

import static org.junit.jupiter.api.Assertions.*;

public class RadioButtonTest extends BaseTest {

    @Test
    public void verifyRadioButtons() {
        HomePage home = new HomePage(driver);
        home.openElements();

        ElementsPage elements = new ElementsPage(driver);
        elements.openRadioButton();

        RadioButtonPage radio = new RadioButtonPage(driver);
        assertTrue(radio.isNoDisabled(), "'No' button should be disabled");

        radio.selectImpressive();
        assertEquals("Impressive", radio.getSelectedText());
    }
}
