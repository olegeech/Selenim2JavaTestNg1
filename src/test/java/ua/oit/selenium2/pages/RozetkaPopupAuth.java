package ua.oit.selenium2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Oleg on 02.06.2015.
 */
public class RozetkaPopupAuth extends Page{

    @FindBy(name = "login")        @CacheLookup public WebElement loginField;
    @FindBy(name = "password")     @CacheLookup public WebElement pwdAuthField;
    @FindBy(name = "auth_submit")  @CacheLookup public WebElement loginBtn;

    public RozetkaPopupAuth(WebDriver webDriver) {
        super(webDriver);
    }


    public void login(String email, String pwd) {
        setElementText(email, loginField);
        setElementText(pwd, pwdAuthField);
        clickElement(loginBtn);
    }

}
