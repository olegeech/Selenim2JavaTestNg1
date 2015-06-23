package ua.oit.selenium2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Oleg on 02.06.2015.
 */
public class RozetkaHeaderLoginPopup extends RozetkaHeader{

    @FindBy(name = "login")        public WebElement loginField;
    @FindBy(name = "password")     public WebElement pwdAuthField;
    @FindBy(name = "auth_submit")  public WebElement loginBtn;
    @FindBy(xpath = "//div[@class='social-bind social-bind-tiny']/a")
    public WebElement socialBindCloseLink;

    public RozetkaHeaderLoginPopup(WebDriver webDriver) {
        super(webDriver);
    }


    public void login(String email, String pwd) {
        String signinLinkTextActual = getSigninLinkText();
        String signinLinkTextExpected = "войдите в личный кабинет";

        boolean isUserNotLoggedIn = signinLinkTextExpected.equals(signinLinkTextActual);
        if (isUserNotLoggedIn) {
            clickSingninLink();
            setElementText(email, loginField);
            setElementText(pwd, pwdAuthField);
            clickElement(loginBtn);
            if (socialBindCloseLink.isDisplayed()) {
                socialBindCloseLink.click();
            }
        } else {System.out.println("\n *** User is already logged in *** \n");}
    }

}
