package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.*;

public class DynamicPropertiesTest extends BaseTest {

    @Test
    public void verifyDynamicButtons() {
        HomePage home = new HomePage(driver);
        home.openElements();

        ElementsPage elements = new ElementsPage(driver);
        elements.openDynamicProperties();

        DynamicPropertiesPage dynamic = new DynamicPropertiesPage(driver);
        dynamic.clickEnableAfter();
        dynamic.clickVisibleAfter();
    }
}
