package ua.oit.selenium2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Oleg on 02.06.2015.
 */
public class RozetkaSignupPage extends Page{

    public RozetkaSignupPage(WebDriver driver) {
        super(driver);
    }

    public By nameFieldLocator = By.name("title");



}
