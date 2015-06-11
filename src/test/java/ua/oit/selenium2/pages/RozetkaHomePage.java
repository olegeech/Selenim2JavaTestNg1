package ua.oit.selenium2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

/**
 * Created by Oleg on 07.06.2015.
 */
public class RozetkaHomePage extends Page {

    public RozetkaHomePage (WebDriver webDriver) {
        super(webDriver);
    }

    private String pageUrl = "https://rozetka.com.ua/";
    private String title = "Интернет-магазин ROZETKA™: фототехника, видеотехника, аудиотехника, компьютеры и компьютерные комплектующие"; //TODO: not works on maven
    @FindBy(tagName = "title")  @CacheLookup public WebElement homePageTitle;
    @FindBy(className = "aligned-center promo-wrap")  @CacheLookup public WebElement homePageContent;


    public void initPage() {
        driver.get(pageUrl);
        Assert.assertEquals(driver.getTitle(), title);
        isElementPresent(homePageContent);
    }

    public String getPageUrl(){return pageUrl;}
    public void setPageUrl(String p){pageUrl=p;}

    public String getTitle(){return title;}
    public void setTitle(String t){title=t;}


}
