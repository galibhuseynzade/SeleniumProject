package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.*;

public class LinkTest extends BaseTest {

    @Test
    public void verifyLinks() {
        HomePage home = new HomePage(driver);
        home.openElements();

        ElementsPage elements = new ElementsPage(driver);
        elements.openLinks();

        LinksPage links = new LinksPage(driver);
        links.openSimpleLink();
        links.openDynamicLink();
        links.switchToNewTab();

        System.out.println("New tab URL: " + driver.getCurrentUrl());
        links.switchBackToMainTab();

        links.clickCreatedLink();
        System.out.println("Status: " + links.getResponseStatusCode());
        System.out.println("Text: " + links.getResponseText());
    }
}
