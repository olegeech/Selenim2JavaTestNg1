package ua.oit.selenium2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Oleg on 02.06.2015.
 */
public class RozetkaPersonalDataPage extends Page{
    public String expectedPageTitle = "Личные данные";

    public RozetkaPersonalDataPage(WebDriver driver) {
        super(driver);
    }

    public By personalInformation = By.id("personal_information");


}
