package ua.oit.selenium2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Oleg on 08.06.2015.
 */
public class RozetkaProductPage {

    public String productTitleTextXpath = "//h1[@itemprop='name']";

    @FindBy(className = "content-inner") @CacheLookup public WebElement pageBody;
    @FindBy(name = "users_towishlist") @CacheLookup public WebElement usersWishlistLink;
    @FindBy(xpath = "//span[@name='wishlists_users_added']/a") @CacheLookup public WebElement wishlistsUsersAddedLink;
    @FindBy(xpath = "//button[@class = 'btn-link-i']") @CacheLookup public WebElement wishlistPopupSaveBtn;
    @FindBy(xpath = "//div[@class = 'wishlists-success'/p/a]") @CacheLookup public WebElement wishlistPopupSucessToWishlistLink;



    public String getProductLinkText() {
        return pageBody.findElement(By.xpath(productTitleTextXpath)).getText();
    }

    public void clickUsersWishlistLink() {
        usersWishlistLink.click();
    }

    public void addProductToUserWishlist() {
        //System.out.println(wishlistsUsersAddedLink.getAttribute("class"));
        if (wishlistsUsersAddedLink.getAttribute("class").equals("underline novisited")) {
            System.out.println("The product is already in wishlist");
        } else {
            clickUsersWishlistLink();
            wishlistPopupSaveBtn.click();
            wishlistPopupSucessToWishlistLink.click();
        }
    }

    public void clickWishlistPopupSucessToWishlistLink() {
        wishlistPopupSucessToWishlistLink.click();
    }

}
