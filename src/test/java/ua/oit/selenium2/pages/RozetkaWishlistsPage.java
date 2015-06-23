package ua.oit.selenium2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
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
    private final String wishlistItemLinkXPath = "//div[@class='g-i-tile-i-title']";


    @FindBy(name = "wishlist-container")        public WebElement wishlistContainer;
    @FindBy(name = "wishlist-block-goods")      public WebElement wishlistGoodsBlock;
    @FindBy(name = "wishlist-cell")             public WebElement wishlistCell;
    @FindBy(name = "wishlist-block-goods-item") public WebElement wishlistItem;
    @FindBy(xpath = wishlistItemLinkXPath)      public WebElement wishlistItemLink;


    public String getPageUrl(){return pageUrl;}

    public void initPage (){
        initPages(pageUrl, title);
    }

    public void verifyIsGoodExist(String expectedGoodName) {
        System.out.println("Expected good name: " +expectedGoodName);
        List<WebElement> wishlistItemsLinks = wishlistGoodsBlock.findElements(By.xpath(wishlistItemLinkXPath));
        List<String> wishlistItemsLinksText = new ArrayList<String>();
        for (WebElement wishlistItemsLink : wishlistItemsLinks) {
            String wishlistItemsLinkText = wishlistItemsLink.getText();
            System.out.println("Actual goods exist in the wishlist: " + wishlistItemsLinkText);
            wishlistItemsLinksText.add(wishlistItemsLinkText);
        }
        Assert.assertTrue(wishlistItemsLinksText.contains(expectedGoodName));
    }




}
