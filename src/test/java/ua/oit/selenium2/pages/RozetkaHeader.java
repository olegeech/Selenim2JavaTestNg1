package ua.oit.selenium2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Oleg on 02.06.2015.
 */
public class RozetkaHeader extends Page{

    @FindBy(className = "clearfix body-header-row-bottom")
                                @CacheLookup public WebElement headerContent;
    @FindBy(name = "signin")    @CacheLookup public WebElement signinLink;
    public By signinLink1 = By.name("signin");

    //@FindBy(xpath = "//div[@id='user_menu']/span[2]/a")    @CacheLookup public WebElement signinLink;
    //@FindBy(id = "header_user_menu_parent") @CacheLookup public WebElement signinLink;
    // //div[@id='user_menu']/span[2]/a
    @FindBy(id = "user_menu")   @CacheLookup public WebElement userMenu;
    @FindBy(name = "profile")   @CacheLookup public WebElement userNameMenu;
    @FindBy(name = "text")      @CacheLookup public WebElement searchField;
    @FindBy(name = "submit")    @CacheLookup public WebElement searchBtn;

    public RozetkaHeader (WebDriver webDriver) {
        super(webDriver);
    }

    public void clickSingninLink() {
        clickElement(signinLink);
    }

    public void searchProduct(String productText) {
        setElementText(productText, searchField);
        searchField.sendKeys(Keys.RETURN);
        //searchField.sendKeys(Keys.ENTER); //doesn't work on MacOS
    }


}
