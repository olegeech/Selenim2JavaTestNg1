package ua.oit.selenium2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

/**
 * Class {@code RozetkaHeaderLoginPopup} describes Login popup.
 * This class also in charge for interacting with web elements located on the page.
 * Use methods in this class for interact with this page or add new.
 *
 * @author Oleg Tatarchuk
 */
public class RozetkaHeaderLoginPopup extends RozetkaHeader implements Popup{
    public static By inputLogin     = By.name("login");
    public static By inputPassword  = By.name("password");
    public static By buttonLogin    = By.name("auth_submit");

    public void login(String email, String pwd) {
        if (getSigninLinkText().equals("войдите в личный кабинет")) {
            clickSingninLink();
            $(inputLogin).setValue(email);
            $(inputPassword).setValue(pwd);
            $(buttonLogin).click();
        } else {System.out.println("\n >> User is already logged in \n");}
    }
}
