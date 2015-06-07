package ua.oit.selenium2.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Oleg on 02.06.2015.
 */
public class RozetkaPopupAuth {

    @FindBy(name = "login")        @CacheLookup public WebElement loginField;
    @FindBy(name = "password")     @CacheLookup public WebElement pwdAuthField;
    @FindBy(name = "auth_submit")  @CacheLookup public WebElement loginBtn;

}
