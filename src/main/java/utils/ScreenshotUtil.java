package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static void takeScreenshot(WebDriver driver, String testName) {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String folderPath = "target/screenshots/";
            Files.createDirectories(Path.of(folderPath));

            String fileName = folderPath + testName + "_" + timestamp + ".png";
            Files.copy(screenshot.toPath(), Path.of(fileName), StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Screenshot saved: " + fileName);
        } catch (IOException e) {
            System.err.println("Failed to save screenshot: " + e.getMessage());
        }
    }
}
