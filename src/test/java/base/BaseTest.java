package base;

import config.ConfigReader;
import core.DriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = DriverManager.getDriver();
        driver.get(ConfigReader.get("baseUrl"));
    }

    @AfterEach
    public void quitDriver() {
        DriverManager.quitDriver();
    }
}
