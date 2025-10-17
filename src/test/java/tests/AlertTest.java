package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.*;

public class AlertTest extends BaseTest {

    @Test
    public void verifyAlerts() {
        HomePage home = new HomePage(driver);
        home.openAlertsFramesWindows();

        AlertsFramesWindowsPage section = new AlertsFramesWindowsPage(driver);
        section.openAlerts();

        AlertsPage alerts = new AlertsPage(driver);
        alerts.triggerImmediateAlert();
        alerts.triggerTimerAlert();
        alerts.triggerConfirmAlert(false);
        alerts.triggerPromptAlert("hello");
    }
}
