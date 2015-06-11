package ua.oit.selenium2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

/**
 * Created by Oleg on 11.06.2015.
 */
public class RozetkaWishlistsPage extends Page {
    public RozetkaWishlistsPage (WebDriver webDriver) {
        super(webDriver);
    }

    private final String pageUrl = "https://my.rozetka.com.ua/profile/wishlists/";
    private final String title = "ROZETKA Ч —писки желаний | Ћичный кабинет";


    @FindBy(name = "wishlist-container")     @CacheLookup public WebElement wishlistContainer;
    @FindBy(xpath = "//div[@class='g-i-tile-i-title']")    @CacheLookup public WebElement goodsLink;


    public String getPageUrl(){return pageUrl;}

    public void initPage (){
        initPages(pageUrl, title);
    }

    public void verifyIsGoodExist(String s) {
        System.out.println("Expected good name: " +s);
        System.out.println("Actual good name: " +goodsLink.getText());
        Assert.assertTrue(goodsLink.getText().contains(s));
    }




}
