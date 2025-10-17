package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProgressBarTest extends BaseTest {

    @Test
    public void verifyProgressBarStopsAt77() {
        HomePage home = new HomePage(driver);
        home.openWidgets();

        WidgetsPage widgets = new WidgetsPage(driver);
        widgets.openProgressBar();

        ProgressBarPage progress = new ProgressBarPage(driver);
        progress.startProgress();
        progress.stopWhenValue(77);

        assertTrue(progress.getProgressValue() >= 77);
    }
}
