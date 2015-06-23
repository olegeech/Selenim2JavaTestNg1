package ua.oit.selenium2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Oleg on 02.06.2015.
 */
public class RozetkaSignupPage extends Page{

    private String pageUrl = "https://my.rozetka.com.ua/signup/";
    private String title = "ROZETKA Ч –егистраци€";

    @FindBy(name = "title")         public WebElement nameField;
    @FindBy(name = "email")         public WebElement emailField;
    @FindBy(name = "password")      public WebElement pwdField;
    @FindBy(xpath = "//div[1]/div/div/div/div/form/div[4]/span/button")
                                    public WebElement regBtn;
    @FindBy(name = "app-message")   public WebElement registeredUserMessage;
    @FindBy(name = "signup")        public WebElement signupContent;

    public RozetkaSignupPage (WebDriver webDriver) {
        super(webDriver);
    }

    public void initPage (){
        initPages(pageUrl, title);
    }


    public void registerNewUser(String name, String email, String pwd) {
        isElementPresent(signupContent);
        setElementText(name, nameField);
        setElementText(email, emailField);
        setElementText(pwd, pwdField);
        clickElement(regBtn);

        //verify if the user is already exist
        if (isElementDisplayed(registeredUserMessage)) {
            String alreadyRegisteredUserMessageText = getElementText(registeredUserMessage);
            System.out.println(" >> "+alreadyRegisteredUserMessageText+"\n");
        }
    }

}
