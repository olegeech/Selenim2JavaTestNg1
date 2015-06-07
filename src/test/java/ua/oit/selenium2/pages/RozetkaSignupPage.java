package ua.oit.selenium2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Oleg on 02.06.2015.
 */
public class RozetkaSignupPage {

    @FindBy(name = "title")         @CacheLookup public WebElement nameField;
    @FindBy(name = "email")         @CacheLookup public WebElement emailField;
    @FindBy(name = "password")      @CacheLookup public WebElement pwdField;
    @FindBy(xpath = "//div[1]/div/div/div/div/form/div[4]/span/button")
                                    @CacheLookup public WebElement regBtn;
    @FindBy(name = "app-message")   @CacheLookup public WebElement registeredUserMessage;
    @FindBy(name = "signup")        @CacheLookup public WebElement signupContent;

}
