package ua.oit.selenium2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

/**
 * Class {@code RozetkaPersonalDataPage} describes user personal data page.
 * This class also in charge for interacting with web elements located on the page.
 * Use methods in this class for interact with this page or add new.
 *
 * @author Oleg Tatarchuk
 */
public class RozetkaPersonalDataPage extends Page{
    public static By personalInformation = By.id("personal_information");

    public void verifyPersonalInformationIsDisplayed() {
        $(personalInformation).shouldHave(text("Личные данные"));
    }
}
