package ua.oit.selenium2.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Oleg on 08.06.2015.
 */
public class RozetkaProductPage {

    public String productTitleTextXpath = "//h1[@itemprop='name']";

    @FindBy(className = "content-inner") @CacheLookup public WebElement pageBody;

}
