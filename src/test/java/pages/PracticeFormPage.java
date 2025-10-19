package pages;

import helper.ClickHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import util.Waiter;

import java.io.File;

public class PracticeFormPage {
    private final WebDriver driver;
    private final Actions actions;

    public PracticeFormPage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstName")
    WebElement firstNameInput;

    @FindBy(id = "lastName")
    WebElement lastNameInput;

    @FindBy(id = "userEmail")
    WebElement emailInput;

    @FindBy(xpath = "//label[contains(@for,'gender')][text()='Male']")
    WebElement genderMaleLabel;

    @FindBy(id = "userNumber")
    WebElement mobileInput;

    @FindBy(id = "dateOfBirthInput")
    WebElement birthDateInput;

    @FindBy(xpath = "//select[@class='react-datepicker__year-select']")
    WebElement yearSelect;

    @FindBy(xpath = "//select[@class='react-datepicker__month-select']")
    WebElement monthSelect;

    @FindBy(id = "subjectsInput")
    WebElement subjectInput;

    @FindBy(xpath = "//label[contains(@for,'hobbies')][text()='Sports']")
    WebElement sportsLabel;

    @FindBy(id = "uploadPicture")
    WebElement uploadPicture;

    @FindBy(id = "currentAddress")
    WebElement currentAddressInput;

    @FindBy(id = "submit")
    WebElement submitButton;

    public void fillFirstName(String firstName) {
        Waiter.untilClickable(firstNameInput).sendKeys(firstName);
    }

    public void fillLastName(String lastName) {
        Waiter.untilClickable(lastNameInput).sendKeys(lastName);
    }

    public void fillEmail(String email) {
        Waiter.untilClickable(emailInput).sendKeys(email);
    }

    public void selectGenderMale() {
        Waiter.untilClickable(genderMaleLabel).click();
    }

    public void fillMobile(String number) {
        Waiter.untilClickable(mobileInput).sendKeys(number);
    }

    public void setBirthDate(String year, String month, String day) {
        ClickHelper.click(birthDateInput);

        Select yearDropdown = new Select(Waiter.untilClickable(yearSelect));
        yearDropdown.selectByVisibleText(year);

        Select monthDropdown = new Select(Waiter.untilClickable(monthSelect));
        monthDropdown.selectByVisibleText(month);

        driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day') and text()='" + day + "']")).click();
    }

    public void fillSubject(String subject) {
        Waiter.untilClickable(subjectInput).sendKeys(subject);
        actions.sendKeys(Keys.ENTER).perform();
    }

    public void selectSports() {
        ClickHelper.click(sportsLabel);
    }

    public void uploadPicture(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            WebElement upload = Waiter.untilClickable(uploadPicture);
            upload.sendKeys(filePath);
        } else {
            throw new RuntimeException("File not found at: " + filePath);
        }
    }

    public void fillAddress(String address) {
        WebElement input = Waiter.untilClickable(currentAddressInput);
        input.clear();
        input.sendKeys(address);
    }

    public void submitForm() {
        ClickHelper.click(submitButton);
    }
}
