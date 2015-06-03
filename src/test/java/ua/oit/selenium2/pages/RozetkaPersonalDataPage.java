package ua.oit.selenium2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Oleg on 02.06.2015.
 */
public class RozetkaPersonalDataPage extends Page{

    public RozetkaPersonalDataPage(WebDriver driver) {
        super(driver);
    }

    public By personalInformationContent = By.id("personal_information_content");
    public By personalInformation = By.id("personal_information");
    public By profileInfoEmail = By.className("profile-info-l-i");


}
