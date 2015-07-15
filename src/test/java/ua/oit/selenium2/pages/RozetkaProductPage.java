package ua.oit.selenium2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Class {@code RozetkaProductPage} describes product page.
 * This class also in charge for interacting with web elements located on the page.
 * Use methods in this class for interact with this page or add new.
 *
 * This page is init using constructor.
 *
 * @author Oleg Tatarchuk
 */
public class RozetkaProductPage extends Page{

    public static By linkTowishlist        = By.name("towishlist"); //Отложить
    public static By linkUsersTowishlist   = By.name("users_towishlist");

    public RozetkaProductPage (String productUrl) {
        open(productUrl);
    }

    public RozetkaProductPage () {

    }

    public void clickUsersToWishlistLink() {
        $(linkUsersTowishlist).click();
    }

    public void clickToWishlistLink() {
        $(linkTowishlist).click();
    }








// TODO: Obsolete methods and locators, to refactor
    public String productTitleTextXpath = "//h1[@itemprop='name']";
    @FindBy(className = "content-inner")     public WebElement pageBody;
    @FindBy(xpath = "//span[@name='wishlists_users_added']/a")    public WebElement wishlistsUsersAddedLink;
    @FindBy(xpath = "//button[@class = 'btn-link-i']")    public WebElement wishlistPopupSaveBtn;
    @FindBy(xpath = "//div[@class = 'wishlists-success'/p/a]")    public WebElement wishlistPopupSucessToWishlistLink;

    public String getProductLinkText() {
        return pageBody.findElement(By.xpath(productTitleTextXpath)).getText();
    }

    public void addProductToUserWishlist() {
        //System.out.println(wishlistsUsersAddedLink.getAttribute("class"));
        if (wishlistsUsersAddedLink.getAttribute("class").equals("underline novisited")) {
            System.out.println("The product is already in wishlist");
        } else {
            clickUsersToWishlistLink();
            wishlistPopupSaveBtn.click();
            wishlistPopupSucessToWishlistLink.click();
        }
    }

    public void clickWishlistPopupSucessToWishlistLink() {
        wishlistPopupSucessToWishlistLink.click();
    }

}
