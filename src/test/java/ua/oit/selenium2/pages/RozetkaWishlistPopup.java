package ua.oit.selenium2.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;


/**
 * Class {@code RozetkaWishlistPopup} describes wishlist popup (displays when click to wishlist link).
 * This class also in charge for interacting with web elements located on the page.
 * Use methods in this class for interact with this page or add new.
 *
 * @author Oleg Tatarchuk
 */
public class RozetkaWishlistPopup extends Page implements Popup {
    public static String popupTitleText = "Добавление в список желаний";
    public static By popup              = By.xpath("/html/body/div[1]");
    public static By popupTitle         = By.xpath("/html/body/div[1]/div/div/form/div/h2");
    public static By inputWishlistTitle = By.name("wishlist_title");
    public static By inputEmail         = By.name("email");
    public static By inputPassword      = By.name("password");
    public static By buttonSave         = By.xpath("/html/body/div[1]/div/div/form/div/div[2]/div[1]/div[2]/span/button");
    public static By hintEmail          = By.name("email_hint");
    public static By buttonLinkVkontakte= By.xpath("/html/body/div[1]/div/div/form/div/div[3]/div[2]/div[2]/span/a");
    public static By buttonLinkFacebook = By.xpath("/html/body/div[1]/div/div/form/div/div[3]/div[2]/div[3]/span/a");


    public void verifyPopupTitle() {
        $(popupTitle).shouldHave(text(popupTitleText));
    }

    public void verifyInputWishlistTitleDefaultText(String s) {
        $(inputWishlistTitle).shouldHave(value(s));
    }

    public void setEmail(String email) {
        $(inputEmail).setValue(email);
    }

    public void setPassword(String password) {
        $(inputPassword).setValue(password);
    }

    public void clickSaveBtn() {
        $(buttonSave).click();
    }

    public void verifyEmailHint(String email) {
        $(hintEmail).shouldHave(text("Пользователь с логином "
                + email + " уже зарегистрирован. Чтобы оставить заявку авторизируйтесь"));
    }

    public void verifyVkontakteBtn() {
        $(buttonLinkVkontakte).shouldHave(exist);
    }

    public void verifyFacebookBtn() {
        $(buttonLinkFacebook).shouldHave(exist);
    }
}
