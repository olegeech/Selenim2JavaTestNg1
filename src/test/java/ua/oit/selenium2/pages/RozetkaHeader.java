package ua.oit.selenium2.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Oleg on 02.06.2015.
 */
public class RozetkaHeader {

    @FindBy(className = "clearfix body-header-row-bottom")
                                @CacheLookup public WebElement headerContent;
    @FindBy(name = "signin")    @CacheLookup public WebElement signinLink;
    @FindBy(id = "user_menu")   @CacheLookup public WebElement userMenu;
    @FindBy(name = "profile")   @CacheLookup public WebElement userNameMenu;
    @FindBy(name = "text")      @CacheLookup public WebElement searchField;
    @FindBy(name = "submit")    @CacheLookup public WebElement searchBtn;

}
