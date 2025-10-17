package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileDownloadUploadTest extends BaseTest {

    @Test
    public void verifyFileDownloadAndUpload() throws InterruptedException {
        HomePage home = new HomePage(driver);
        home.openElements();

        ElementsPage elements = new ElementsPage(driver);
        elements.openUploadDownload();

        UploadDownloadPage page = new UploadDownloadPage(driver);
        page.clickDownloadButton();

        Thread.sleep(2000);

        String filePath = "C:\\Users\\galib\\Downloads\\sampleFile.jpeg";
        assertTrue(page.isFileDownloaded(filePath), "File should be downloaded");
        page.uploadFile(filePath);
    }
}
