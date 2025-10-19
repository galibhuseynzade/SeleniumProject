package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ButtonTest extends BaseTest {

    @Test
    public void verifyButtonClicks() {
        HomePage home = new HomePage(driver);
        home.openElements();

        ElementsPage elements = new ElementsPage(driver);
        elements.openButtons();

        ButtonsPage buttons = new ButtonsPage(driver);
        buttons.doubleClick();
        assertEquals("You have done a double click", buttons.getDoubleClickMessage());

        buttons.rightClick();
        assertEquals("You have done a right click", buttons.getRightClickMessage());

        buttons.dynamicClick();
        assertEquals("You have done a dynamic click", buttons.getDynamicClickMessage());
    }
}
