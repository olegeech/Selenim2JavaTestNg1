package ua.oit.selenium2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Oleg on 02.06.2015.
 */
public class RozetkaHeader extends Page{

    public RozetkaHeader(WebDriver driver) {
        super(driver);
    }

    public By signinLink = By.name("signin");
    public By userMenu = By.id("user_menu");
    public By userNameMenu = By.name("profile");


}
