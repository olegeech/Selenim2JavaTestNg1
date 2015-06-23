package ua.oit.selenium2.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Oleg on 02.06.2015.
 */
public class RozetkaPersonalDataPage {

    @FindBy(id = "personal_information_content")  public WebElement personalInformationContent;
    @FindBy(id = "personal_information")          public WebElement personalInformation;
    @FindBy(className = "profile-info-l-i")       public WebElement profileInfoEmail;

}
