package ua.oit.selenium2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Oleg on 02.06.2015.
 */
public class RozetkaPopupAuth extends Page{

    public RozetkaPopupAuth(WebDriver driver) {
        super(driver);
    }

    public By loginField = By.name("login");
    public By pwdAuthField = By.name("password");
    public By loginBtn = By.name("auth_submit");

}
