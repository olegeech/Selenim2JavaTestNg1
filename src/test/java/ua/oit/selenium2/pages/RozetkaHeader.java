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
                                public WebElement headerContent;
    @FindBy(name = "signin")    public WebElement signinLink;
    @FindBy(id = "user_menu")   public WebElement userMenu;
    @FindBy(name = "profile")   public WebElement userNameMenu;
    @FindBy(name = "text")      public WebElement searchField;
    @FindBy(name = "submit")    public WebElement searchBtn;

    public RozetkaHeader (WebDriver webDriver) {
        super(webDriver);
    }

    public void clickSingninLink() {
        clickElement(signinLink);
    }

    public String getSigninLinkText() {
        return signinLink.getText();
    }

    public void searchProduct(String productText) {
        setElementText(productText, searchField);
        searchField.sendKeys(Keys.RETURN);
        //searchField.sendKeys(Keys.ENTER); //doesn't work on MacOS
    }


}
