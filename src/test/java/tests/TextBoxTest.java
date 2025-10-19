package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.TextBoxPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TextBoxTest extends BaseTest {

    @Test
    public void verifyTextBox() {
        HomePage home = new HomePage(driver);
        home.openElements();

        ElementsPage elements = new ElementsPage(driver);
        elements.openTextBox();

        TextBoxPage textBox = new TextBoxPage(driver);
        textBox.fillFullName("Galib Huseynzade");
        textBox.fillEmail("galibhuseynzade@gmail.com");
        textBox.fillCurrentAddress("Baku");
        textBox.fillPermanentAddress("Azerbaijan");
        textBox.submitForm();

        assertTrue(textBox.getOutputNameText().contains("Galib"));
    }
}
