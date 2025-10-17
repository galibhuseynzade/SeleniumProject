package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckBoxTest extends BaseTest {

    @Test
    public void verifyCheckBoxSelection() {
        HomePage home = new HomePage(driver);
        home.openElements();

        ElementsPage elements = new ElementsPage(driver);
        elements.openCheckBox();

        CheckBoxPage checkBox = new CheckBoxPage(driver);
        checkBox.expandAll();
        checkBox.selectDesktop();
        checkBox.selectReact();
        checkBox.selectAngular();

        System.out.println("Selected: " + checkBox.getSelectedResults());
        assertTrue(checkBox.isHomeHalfSelected(), "Home checkbox should be half selected");
    }
}
