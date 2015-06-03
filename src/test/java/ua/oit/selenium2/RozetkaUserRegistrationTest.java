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
        String email = "tatarchykoleg@gmail.com";
        String pwd = "testPass";
        driver.get(baseUrl);

        //register new user
        isElementPresent(signupPage.signupContent);
        setElementText(name, signupPage.nameField);
        setElementText(email, signupPage.emailField);
        setElementText(pwd, signupPage.pwdField);
        clickElement(signupPage.regBtn);

        //verify if the user is already exist
        waitForElement(signupPage.alreadyRegisteredUserMessage);
        if (isElementDisplayed(signupPage.alreadyRegisteredUserMessage)) {
            String alreadyRegisteredUserMessageText = getElementText(signupPage.alreadyRegisteredUserMessage);
            System.out.println(" >> "+alreadyRegisteredUserMessageText+"\n");
            //TODO: tbd...
        }

        //verify is user can login
        clickElement(header.signinLink);
        setElementText(email, loginPopup.loginField);
        setElementText(pwd, loginPopup.pwdAuthField);
        clickElement(loginPopup.loginBtn);

        //verify is user logged in
        waitForElement(personalDataPage.personalInformationContent);
        isElementPresent(personalDataPage.personalInformationContent);
        assertElementText(header.userNameMenu, name);

    }


}
