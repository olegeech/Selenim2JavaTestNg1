package ua.oit.selenium2;

import org.testng.annotations.Test;
import ua.oit.selenium2.pages.*;

/**
 * Class {@code RozetkaUserAuthorisationTests} is test suite for site authorization.
 *
 * @author Oleg Tatarchuk
 */
public class RozetkaUserAuthorisationTests extends TestBase {
    private RozetkaSignupPage signupPage;
    private RozetkaHeader header;
    private RozetkaHeaderLoginPopup loginPopup;
    private RozetkaPersonalDataPage personalDataPage;

    @Test
    public void RozetkaRegisterUserAndVerifyLoginAndUserName() throws Exception {
        String name     = "testName";
        String email    = "tatarchykoleg@gmail.com";
        String pwd      = "testPass";

        signupPage = new RozetkaSignupPage();
        signupPage.registerNewUser(name, email, pwd);
        loginPopup = new RozetkaHeaderLoginPopup();
        loginPopup.fillLoginFormAndClickLogin(email, pwd);
        personalDataPage = new RozetkaPersonalDataPage();
        personalDataPage.verifyPersonalInformationIsDisplayed();
        header = new RozetkaHeader();
        header.verifyUserName(name);
    }
}
