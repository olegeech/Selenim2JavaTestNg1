package ua.oit.selenium2.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Oleg on 02.06.2015.
 */
public class RozetkaHeader {

    @FindBy(name = "signin")  @CacheLookup public WebElement signinLink;
    @FindBy(id = "user_menu")  @CacheLookup public WebElement userMenu;
    @FindBy(name = "profile")  @CacheLookup public WebElement userNameMenu;

}
