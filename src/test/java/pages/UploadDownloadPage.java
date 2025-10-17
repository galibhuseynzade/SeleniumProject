package pages;

import core.Js;
import core.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;

public class UploadDownloadPage {

    private final WebDriver driver;
    private final Js js;
    private final Waiter wait;

    public UploadDownloadPage(WebDriver driver) {
        this.driver = driver;
        this.js = new Js(driver);
        this.wait = new Waiter(driver);
    }

    private final By downloadButton = By.id("downloadButton");
    private final By uploadButton = By.id("uploadFile");

    public void clickDownloadButton() {
        WebElement download = wait.untilClickable(downloadButton);
        js.scrollIntoView(download);
        download.click();
    }

    public boolean isFileDownloaded(String filePath) {
        File file = new File(filePath);
        return file.exists() && file.length() > 0;
    }

    public void uploadFile(String filePath) {
        WebElement upload = wait.untilClickable(uploadButton);
        js.scrollIntoView(upload);
        upload.sendKeys(filePath);
    }
}
