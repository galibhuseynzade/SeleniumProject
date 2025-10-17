package pages;

import core.Js;
import core.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTablesPage {

    private final WebDriver driver;
    private final Js js;
    private final Waiter wait;

    public WebTablesPage(WebDriver driver) {
        this.driver = driver;
        this.js = new Js(driver);
        this.wait = new Waiter(driver);
    }

    private final By addButton = By.id("addNewRecordButton");
    private final By firstNameInput = By.id("firstName");
    private final By lastNameInput = By.id("lastName");
    private final By emailInput = By.id("userEmail");
    private final By ageInput = By.id("age");
    private final By salaryInput = By.id("salary");
    private final By departmentInput = By.id("department");
    private final By submitButton = By.id("submit");

    public void clickAddButton() {
        WebElement btn = wait.untilClickable(addButton);
        js.scrollIntoView(btn);
        btn.click();
    }

    public void fillForm(String firstName, String lastName, String email, String age, String salary, String department) {
        wait.untilVisible(firstNameInput).sendKeys(firstName);
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(ageInput).sendKeys(age);
        driver.findElement(salaryInput).sendKeys(salary);
        driver.findElement(departmentInput).sendKeys(department);
    }

    public void submitForm() {
        WebElement btn = driver.findElement(submitButton);
        js.scrollIntoView(btn);
        btn.click();
    }

    public void deleteRecordByFirstName(String firstName) {
        String deleteXpath = "//div[contains(@class, 'rt-tr')]/div[@class='rt-td' and text()='" + firstName + "']/..//span[@title='Delete']";
        WebElement deleteBtn = wait.untilClickable(By.xpath(deleteXpath));
        js.scrollIntoView(deleteBtn);
        deleteBtn.click();
    }
}
