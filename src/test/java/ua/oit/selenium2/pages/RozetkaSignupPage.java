package ua.oit.selenium2.pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * Class {@code RozetkaSignupPage} describes sign up page.
 * This class also in charge for interacting with web elements located on the page.
 * Use methods in this class for interact with this page or add new.
 *
 * @author Oleg Tatarchuk
 */
public class RozetkaSignupPage extends Page{
    //Page URL, title and locators initialisation
    public static String pageUrl      = "https://my.rozetka.com.ua/signup/";
    public static String title        = "ROZETKA — Регистрация";
    public static By frameSignup      = By.name("signup");
    public static By inputName        = By.name("title");
    public static By inputEmail       = By.name("email");
    public static By inputPassword    = By.name("password");
    public static By buttonReg        = byText("Зарегистрироваться");
    public static By registeredUserMessage = By.name("app-message");

    public void initPage (){
        initPages(pageUrl, title);
    }

    public void registerNewUser(String name, String email, String pwd) {
        //Implemented using Selenide
        $(frameSignup).shouldHave(text("Регистрация"));
        $(inputName).setValue(name);
        $(inputEmail).setValue(email);
        $(inputPassword).setValue(pwd);
        $(buttonReg).click();
        //verify if the user is already exist and print actual message text in console
        if ($(registeredUserMessage).is(exist)) {
            System.out.println(" >> "+$(registeredUserMessage).getText()+"\n");
        }
    }
}
