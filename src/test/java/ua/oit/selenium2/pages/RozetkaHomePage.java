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

    private final String pageUrl = "https://rozetka.com.ua/";
    private final String title = "»нтернет-магазин ROZETKAЩ: фототехника, видеотехника, аудиотехника, компьютеры и компьютерные комплектующие"; //TODO: not works on maven

    @FindBy(tagName = "title")                          public WebElement homePageTitle;
    @FindBy(className = "aligned-center promo-wrap")    public WebElement homePageContent;


    public void initPage (){
        initPages(pageUrl, title);
    }

    public String getPageUrl(){return pageUrl;}
    public String getTitle(){return title;}


}
