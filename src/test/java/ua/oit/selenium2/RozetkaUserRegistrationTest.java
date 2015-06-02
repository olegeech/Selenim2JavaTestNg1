package ua.oit.selenium2;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.oit.selenium2.pages.RozetkaHeader;
import ua.oit.selenium2.pages.RozetkaPersonalDataPage;
import ua.oit.selenium2.pages.RozetkaPopupAuth;
import ua.oit.selenium2.pages.RozetkaSignupPage;

/**
 * Created by Oleg on 02.06.2015.
 */
public class RozetkaUserRegistrationTest extends TestBase {
    private RozetkaSignupPage signupPage;
    private RozetkaHeader header;
    private RozetkaPopupAuth loginPopup;
    private RozetkaPersonalDataPage personalDataPage;

    @BeforeMethod
    public void initPageObjects() {
        signupPage = PageFactory.initElements(driver, RozetkaSignupPage.class);
        header = PageFactory.initElements(driver, RozetkaHeader.class);
        loginPopup = PageFactory.initElements(driver, RozetkaPopupAuth.class);
        personalDataPage = PageFactory.initElements(driver, RozetkaPersonalDataPage.class);
    }

    @Test
    public void RozetkaUserRegistrationTest() throws Exception {
        baseUrl = "https://my.rozetka.com.ua/signup/";
        String name = "testName";
        //String dot = "."; //can be random or datetime...
        //String emailDomainPart = "tatarchykoleg"+dot;
        String email = "tatarchykoleg@gmail.com";
        String pwd = "testPass";
        driver.get(baseUrl);

        //register new user

        //signupPage.isRightPage(signupPage.expectedPageTitle);
        signupPage.setElementText(name, signupPage.nameField);
        signupPage.setElementText(email, signupPage.emailField);
        signupPage.setElementText(pwd, signupPage.pwdField);
        signupPage.clickElement(signupPage.regBtn);

        //verify if user is already exist
        signupPage.waitForElement(signupPage.alreadyRegisteredUserMessage);
        if (signupPage.isElementDisplayed(signupPage.alreadyRegisteredUserMessage)) {
            String alreadyRegisteredUserMessageText = signupPage.getElementText(signupPage.alreadyRegisteredUserMessage);
            System.out.println(alreadyRegisteredUserMessageText);
            //TODO: tbd...
        }

        //verify is user can login
        header.clickElement(header.signinLink);
        loginPopup.setElementText(email, loginPopup.loginField);
        loginPopup.setElementText(pwd, loginPopup.pwdAuthField);
        loginPopup.clickElement(loginPopup.loginBtn);

        //verify is user logged in
        personalDataPage.waitForElement(personalDataPage.personalInformation);
        //personalDataPage.isRightPage(personalDataPage.expectedPageTitle);
        header.assertElementText(header.userNameMenu, name);

    }


}
