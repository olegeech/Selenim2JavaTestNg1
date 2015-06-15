package ua.oit.selenium2;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.oit.selenium2.pages.*;

/**
 * Created by Oleg on 02.06.2015.
 */
public class RozetkaUserAuthorisationTests extends TestBase {
    private RozetkaSignupPage signupPage;
    private RozetkaHeader header;
    private RozetkaHeaderLoginPopup loginPopup;
    private RozetkaPersonalDataPage personalDataPage;

    @BeforeMethod
    public void initPageObjects() {
        signupPage = PageFactory.initElements(driver, RozetkaSignupPage.class);
        header = PageFactory.initElements(driver, RozetkaHeader.class);
        loginPopup = PageFactory.initElements(driver, RozetkaHeaderLoginPopup.class);
        personalDataPage = PageFactory.initElements(driver, RozetkaPersonalDataPage.class);
    }

    @Test
    public void RozetkaRegisterUserAndVerifyLoginAndUserName() throws Exception {
        String name = "testName";
        String email = "tatarchykoleg@gmail.com";
        String pwd = "testPass";

        signupPage.initPage();

        //register new user
        signupPage.registerNewUser(name, email, pwd);

        //verify is user can login
        loginPopup.login(email, pwd);

        //verify is user logged in
        isElementPresent(personalDataPage.personalInformationContent);

        //verify if user name is displayed correctly
        Assert.assertEquals(header.userNameMenu.getText(), name);

    }
}
