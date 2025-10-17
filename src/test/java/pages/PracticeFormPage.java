package pages;

import core.Js;
import core.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

public class PracticeFormPage {

    private final WebDriver driver;
    private final Js js;
    private final Waiter wait;
    private final Actions actions;

    public PracticeFormPage(WebDriver driver) {
        this.driver = driver;
        this.js = new Js(driver);
        this.wait = new Waiter(driver);
        this.actions = new Actions(driver);
    }

    private final By firstNameInput = By.id("firstName");
    private final By lastNameInput = By.id("lastName");
    private final By emailInput = By.id("userEmail");
    private final By genderMaleLabel = By.xpath("//label[contains(@for,'gender')][text()='Male']");
    private final By mobileInput = By.id("userNumber");
    private final By birthDateInput = By.id("dateOfBirthInput");
    private final By yearSelect = By.xpath("//select[@class='react-datepicker__year-select']");
    private final By monthSelect = By.xpath("//select[@class='react-datepicker__month-select']");
    private final By subjectInput = By.id("subjectsInput");
    private final By sportsLabel = By.xpath("//label[contains(@for,'hobbies')][text()='Sports']");
    private final By uploadPicture = By.id("uploadPicture");
    private final By currentAddressInput = By.id("currentAddress");
    private final By stateDropdown = By.xpath("//div[contains(@class,'placeholder')][.='Select State']/..//div[contains(@class,'indicatorContainer')]");
    private final By submitButton = By.id("submit");

    public void fillFirstName(String firstName) {
        WebElement input = wait.untilClickable(firstNameInput);
        input.clear();
        input.sendKeys(firstName);
    }

    public void fillLastName(String lastName) {
        WebElement input = wait.untilClickable(lastNameInput);
        input.clear();
        input.sendKeys(lastName);
    }

    public void fillEmail(String email) {
        WebElement input = wait.untilClickable(emailInput);
        input.clear();
        input.sendKeys(email);
    }

    public void selectGenderMale() {
        WebElement gender = wait.untilClickable(genderMaleLabel);
        js.scrollIntoView(gender);
        gender.click();
    }

    public void fillMobile(String number) {
        WebElement input = wait.untilClickable(mobileInput);
        input.clear();
        input.sendKeys(number);
    }

    public void setBirthDate(String year, String month, String day) {
        WebElement dateInput = wait.untilClickable(birthDateInput);
        js.scrollIntoView(dateInput);
        dateInput.click();

        Select yearDropdown = new Select(wait.untilClickable(yearSelect));
        yearDropdown.selectByVisibleText(year);

        Select monthDropdown = new Select(wait.untilClickable(monthSelect));
        monthDropdown.selectByVisibleText(month);

        By dayLocator = By.xpath("//div[contains(@class,'react-datepicker__day') and text()='" + day + "']");
        WebElement dayEl = wait.untilClickable(dayLocator);
        dayEl.click();
    }

    public void fillSubject(String subject) {
        WebElement input = wait.untilClickable(subjectInput);
        input.sendKeys(subject);
        actions.sendKeys(Keys.ENTER).perform();
    }

    public void selectSports() {
        WebElement label = wait.untilClickable(sportsLabel);
        js.scrollIntoView(label);
        label.click();
    }

    public void uploadPicture(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            WebElement upload = wait.untilClickable(uploadPicture);
            upload.sendKeys(filePath);
        } else {
            throw new RuntimeException("File not found at: " + filePath);
        }
    }

    public void fillAddress(String address) {
        WebElement input = wait.untilClickable(currentAddressInput);
        input.clear();
        input.sendKeys(address);
    }

    public void submitForm() {
        WebElement button = wait.untilClickable(submitButton);
        js.scrollIntoView(button);
        button.click();
    }
}
