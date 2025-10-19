package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.*;

public class BrowserWindowsTest extends BaseTest {

    @Test
    public void verifyBrowserWindows() {
        HomePage home = new HomePage(driver);
        home.openAlertsFramesWindows();

        AlertsFramesWindowsPage section = new AlertsFramesWindowsPage(driver);
        section.openBrowserWindows();

        BrowserWindowsPage browser = new BrowserWindowsPage(driver);
        browser.openNewTab();
        browser.switchToNewWindow();
        browser.switchBackToMainWindow();

        browser.openNewWindow();
        browser.switchToNewWindow();
    }
}
