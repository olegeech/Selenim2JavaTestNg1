package ua.oit.selenium2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * Created by Oleg on 07.06.2015.
 */
public class RozetkaHomePage extends Page {

    public RozetkaHomePage (WebDriver webDriver) {
        super(webDriver);
    }

    String pageUrl = "https://rozetka.com.ua/";
    String title = "Интернет-магазин ROZETKA™: фототехника, видеотехника, аудиотехника, компьютеры и компьютерные комплектующие";
    @FindBy(tagName = "title")  @CacheLookup public WebElement homePageTitle;
    @FindBy(className = "aligned-center promo-wrap")  @CacheLookup public WebElement homePageContent;


    public void initPage() {
        driver.get(pageUrl);
        Assert.assertEquals(driver.getTitle(), title);
        isElementPresent(homePageContent);
    }


}
