package pages;

import helper.ClickHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Js;

public class WebTablesPage {
    private final WebDriver driver;

    public WebTablesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "addNewRecordButton")
    WebElement addButton;

    @FindBy(id = "firstName")
    WebElement firstNameInput;

    @FindBy(id = "lastName")
    WebElement lastNameInput;

    @FindBy(id = "userEmail")
    WebElement emailInput;

    @FindBy(id = "age")
    WebElement ageInput;

    @FindBy(id = "salary")
    WebElement salaryInput;

    @FindBy(id = "department")
    WebElement departmentInput;

    @FindBy(id = "submit")
    WebElement submitButton;


    public void clickAddButton() {
        ClickHelper.click(addButton);
    }

    public void fillForm(String firstName, String lastName, String email, String age, String salary, String department) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        ageInput.sendKeys(age);
        salaryInput.sendKeys(salary);
        departmentInput.sendKeys(department);
    }

    public void submitForm() {
        ClickHelper.click(submitButton);
    }

    public void deleteRecordByFirstName(String firstName) {
        String deleteXpath = "//div[contains(@class, 'rt-tr')]/div[@class='rt-td' and text()='" + firstName + "']/..//span[@title='Delete']";
        WebElement deleteBtn = driver.findElement(By.xpath(deleteXpath));
        Js.scrollIntoView(deleteBtn);
        deleteBtn.click();
    }
}
