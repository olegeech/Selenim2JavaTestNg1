package ua.oit.selenium2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Oleg on 07.06.2015.
 */
public class RozetkaHomePage extends Page {
    private String pageUrl = "https://rozetka.com.ua/";
    private String title = "Интернет-магазин ROZETKA™: фототехника, видеотехника, аудиотехника, компьютеры и компьютерные комплектующие"; //TODO: not works on maven

    public RozetkaHomePage () {
        super.initPage(pageUrl, title);
    }

    public String getPageUrl(){return pageUrl;}

    public String getTitle(){return title;}

}
