package ua.oit.selenium2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

/**
 * Class {@code RozetkaHeader} describes header of the Rozetka site.
 * This class also in charge for interacting with web elements located on the page.
 * Use methods in this class for interact with this page or add new.
 *
 * @author Oleg Tatarchuk
 */
public class RozetkaHeader extends Page{
    // Page locators
    public static By userNameLink   = By.name("profile");
    public static By signinLink     = By.name("signin");
    public static By inputSearch    = By.name("text");


    public void clickSingninLink() {
        $(signinLink).click();
    }

    public String getSigninLinkText() {
        return $(signinLink).getText();
    }

    public void verifyUserName(String name) {
        $(userNameLink).shouldHave(text(name));
    }

    public void searchProduct(String productText) {
        $(inputSearch).setValue(productText);
        $(inputSearch).sendKeys(Keys.RETURN);
    }

}
