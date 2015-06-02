package ua.oit.selenium2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Oleg on 02.06.2015.
 */
public class RozetkaSignupPage extends Page{
    public String expectedPageTitle = "Регистрация";

    public RozetkaSignupPage(WebDriver driver) {
        super(driver);
    }


    public By nameField = By.name("title");
    public By emailField = By.name("email");
    public By pwdField = By.name("password");
    public By regBtn = By.xpath("//div[1]/div/div/div/div/form/div[4]/span/button");
    public By alreadyRegisteredUserMessage = By.name("app-message");



}
