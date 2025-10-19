package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.*;

public class PracticeFormTest extends BaseTest {

    @Test
    public void verifyPracticeForm() {
        HomePage home = new HomePage(driver);
        home.openForms();

        FormsPage forms = new FormsPage(driver);
        forms.openPracticeForm();

        PracticeFormPage form = new PracticeFormPage(driver);
        form.fillFirstName("Galib");
        form.fillLastName("Huseynzade");
        form.fillEmail("galibhuseynzade@gmail.com");
        form.selectGenderMale();
        form.fillMobile("0773782729");
        form.setBirthDate("1998", "April", "3");
        form.fillSubject("Eng");
        form.selectSports();
        form.uploadPicture("C:\\Users\\galib\\Downloads\\sampleFile.jpeg");
        form.fillAddress("Baku, Azerbaijan");
        form.submitForm();
    }
}
