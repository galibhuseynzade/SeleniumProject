package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.*;

public class WebTablesTest extends BaseTest {

    @Test
    public void verifyWebTableAddAndDelete() {
        HomePage home = new HomePage(driver);
        home.openElements();

        ElementsPage elements = new ElementsPage(driver);
        elements.openWebTables();

        WebTablesPage table = new WebTablesPage(driver);
        table.clickAddButton();
        table.fillForm("Galib", "Huseynzade", "galib@example.com", "28", "100", "IT Development");
        table.submitForm();
        table.deleteRecordByFirstName("Cierra");
    }
}
