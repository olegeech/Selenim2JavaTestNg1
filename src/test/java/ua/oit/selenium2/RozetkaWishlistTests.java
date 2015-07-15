package ua.oit.selenium2;

import org.testng.annotations.Test;
import ua.oit.selenium2.pages.*;

/**
 * Class {@code RozetkaWishlistTests} is test suite for Wishlist functionality.
 *
 * @author Oleg Tatarchuk
 */
public class RozetkaWishlistTests extends TestBase {

    @Test
    /**
     * Method {@code smokeUsersToWishList} implements test case
     * RWLT002: Verify availability of the feature, using "список желаний" link.
     */
    public void smokeUsersToWishList() throws Exception {
        //Test case data
        String productUrl= "http://rozetka.com.ua/acer_aspire_es1-111m-c09t_nx_mrseu_002/p1705052/";

        //Steps
        RozetkaProductPage productPage = new RozetkaProductPage(productUrl); //init page using constructor
        productPage.clickUsersToWishlistLink();
        RozetkaWishlistPopup wishlistPopup = new RozetkaWishlistPopup();
        //Expected results
        wishlistPopup.verifyPopupTitle();
    }

    @Test
    /**
     * Method {@code authUserNotLoggedIn} implements test case
     * RWLT003: Authorisation: User is NOT logged in. Using "Отложить" link
     */
    public void authUserNotLoggedIn() throws Exception {
        //Test case data
        String productUrl   = "http://rozetka.com.ua/acer_aspire_es1-111m-c09t_nx_mrseu_002/p1705052/";
        String email        = "tatarchykoleg@gmail.com";
        String password     = "testPass";

        //Steps
        RozetkaProductPage productPage = new RozetkaProductPage(productUrl);
        productPage.clickToWishlistLink();
        RozetkaWishlistPopup wishlistPopup = new RozetkaWishlistPopup();
        wishlistPopup.verifyInputWishlistTitleDefaultText("Мой список желаний");
        wishlistPopup.setEmail(email);
        wishlistPopup.clickSaveBtn();
        //Expected results
        wishlistPopup.verifyEmailHint(email);
        wishlistPopup.setPassword(password);
        wishlistPopup.verifyVkontakteBtn();
        wishlistPopup.verifyFacebookBtn();
    }

}
