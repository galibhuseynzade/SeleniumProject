package pages;

import helper.ClickHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Js;
import util.Waiter;

import java.io.File;

public class UploadDownloadPage {
    public UploadDownloadPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "downloadButton")
    WebElement downloadButton;

    @FindBy(id = "uploadFile")
    WebElement uploadButton;

    public void clickDownloadButton() {
        ClickHelper.click(downloadButton);
    }

    public boolean isFileDownloaded(String filePath) {
        File file = new File(filePath);
        return file.exists() && file.length() > 0;
    }

    public void uploadFile(String filePath) {
        WebElement upload = Waiter.untilClickable(uploadButton);
        Js.scrollIntoView(upload);
        upload.sendKeys(filePath);
    }
}
