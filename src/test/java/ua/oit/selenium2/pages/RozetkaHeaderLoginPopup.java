package ua.oit.selenium2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Oleg on 02.06.2015.
 */
public class RozetkaHeaderLoginPopup extends RozetkaHeader{

    @FindBy(name = "login")        @CacheLookup public WebElement loginField;
    @FindBy(name = "password")     @CacheLookup public WebElement pwdAuthField;
    @FindBy(name = "auth_submit")  @CacheLookup public WebElement loginBtn;

    public RozetkaHeaderLoginPopup(WebDriver webDriver) {
        super(webDriver);
    }


    public void login(String email, String pwd) {
        // TODO: Miracle, not working

        String signinLinkTextActual = signinLink.getText();
        String signinLinkTextExpected = "войдите в личный кабинет";

/*        //Verification some miracle occurrence when the same string was not equaled))) due to encoding
        char[] signinLinkTextChars1 = signinLinkTextActual.toCharArray();
        char[] signinLinkTextChars2 = signinLinkTextExpected.toCharArray();

        for (int i=0; i < signinLinkTextChars1.length; i++){
            boolean b = signinLinkTextChars1[i] == signinLinkTextChars2[i];
            System.out.print(signinLinkTextChars1[i]+" ");
            System.out.println(signinLinkTextChars2[i]);
            if (!b){
                System.out.println(signinLinkTextChars1[i]);
                System.out.println(signinLinkTextChars2[i]);
            }
        }*/

        boolean isUserNotLoggedIn = signinLinkTextExpected.equals(signinLinkTextActual);
        if (isUserNotLoggedIn) {
            signinLink.click();
            setElementText(email, loginField);
            setElementText(pwd, pwdAuthField);
            clickElement(loginBtn);
        } else {System.out.println("User is already logged in");}
    }

}
