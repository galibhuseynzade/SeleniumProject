package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.*;

public class FrameTest extends BaseTest {

    @Test
    public void verifyFrames() {
        HomePage home = new HomePage(driver);
        home.openAlertsFramesWindows();

        AlertsFramesWindowsPage section = new AlertsFramesWindowsPage(driver);
        section.openFrames();

        FramesPage frames = new FramesPage(driver);
        frames.switchToFrame1();
        System.out.println("Frame 1 text: " + frames.getFrameText());
        frames.switchToDefault();

        frames.switchToFrame2();
        System.out.println("Frame 2 text: " + frames.getFrameText());
        frames.switchToDefault();
    }
}
