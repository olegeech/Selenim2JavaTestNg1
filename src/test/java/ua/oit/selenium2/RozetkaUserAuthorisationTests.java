package ua.oit.selenium2;

import org.testng.annotations.Test;
import ua.oit.selenium2.pages.*;

/**
 * Class {@code RozetkaUserAuthorisationTests} is test suite for site authorization.
 *
 * @author Oleg Tatarchuk
 */
public class RozetkaUserAuthorisationTests extends TestBase {
    private RozetkaSignupPage signupPage             = new RozetkaSignupPage();
    private RozetkaHeader header                     = new RozetkaHeader();
    private RozetkaHeaderLoginPopup loginPopup       = new RozetkaHeaderLoginPopup();
    private RozetkaPersonalDataPage personalDataPage = new RozetkaPersonalDataPage();

    @Test
    public void RozetkaRegisterUserAndVerifyLoginAndUserName() throws Exception {
        String name     = "testName";
        String email    = "tatarchykoleg@gmail.com";
        String pwd      = "testPass";

        signupPage.initPage();
        signupPage.registerNewUser(name, email, pwd);
        loginPopup.login(email, pwd);
        personalDataPage.verifyPersonalInformationIsDisplayed();
        header.verifyUserName(name);
    }
}
