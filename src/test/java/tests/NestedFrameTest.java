package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.*;

public class NestedFrameTest extends BaseTest {

    @Test
    public void verifyNestedFrames() {
        HomePage home = new HomePage(driver);
        home.openAlertsFramesWindows();

        AlertsFramesWindowsPage section = new AlertsFramesWindowsPage(driver);
        section.openNestedFrames();

        NestedFramesPage nested = new NestedFramesPage(driver);
        nested.switchToParentFrame();
        System.out.println("Parent Frame: " + nested.getBodyText());

        nested.switchToChildFrame();
        System.out.println("Child Frame: " + nested.getBodyText());

        nested.switchToParentFromChild();
        System.out.println("Back to Parent Frame: " + nested.getBodyText());

        nested.switchToDefaultContent();
    }
}
