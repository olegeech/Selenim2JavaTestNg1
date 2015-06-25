package ua.oit.selenium2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Oleg on 02.06.2015.
 */
public class RozetkaHeaderLoginPopup extends RozetkaHeader{
    private final String socialBindCloseLinkLocator = "close";

    @FindBy(name = "login")       @CacheLookup public WebElement loginField;
    @FindBy(name = "password")    @CacheLookup public WebElement pwdAuthField;
    @FindBy(name = "auth_submit") @CacheLookup public WebElement loginBtn;
    @FindBy(name = socialBindCloseLinkLocator) @CacheLookup public WebElement socialBindCloseLink;

    //@FindBy(css = "social-bind-tiny-close novisited") @CacheLookup public WebElement socialBindCloseLink;

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

 /*           if (driver.findElements(By.name(socialBindCloseLinkLocator)).size() != 0) {
                driver.findElement(By.name(socialBindCloseLinkLocator)).click();
            }*/



        } else {System.out.println("\n *** User is already logged in *** \n");}
    }

}
