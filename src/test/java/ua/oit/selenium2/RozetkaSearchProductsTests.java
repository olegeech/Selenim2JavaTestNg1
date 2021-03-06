package ua.oit.selenium2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ua.oit.selenium2.pages.*;

import java.util.List;

/**
 * Class {@code RozetkaSearchProductsTests} is test suite for search functionality.
 *
 * @author Oleg Tatarchuk
 */
//TODO: After use Selenide framework tests in this suite doesn't work. To refactor.
public class RozetkaSearchProductsTests extends TestBase {
    //Public variables

    @DataProvider (name = "product")
    public Object[][] createProductData(){
        return new Object[][] {
                {"Test"},
        };
    }

    private RozetkaHeader header;
    private RozetkaHomePage homePage;
    private RozetkaSearchResultsPage searchResultsPage;
    private RozetkaProductPage productPage;
    private RozetkaHeaderLoginPopup loginPopup;
    private RozetkaWishlistsPage wishlistsPage;


    @BeforeMethod
    public void initPageObjects() {
        header = PageFactory.initElements(driver, RozetkaHeader.class);
        homePage = PageFactory.initElements(driver, RozetkaHomePage.class);
        searchResultsPage = PageFactory.initElements(driver, RozetkaSearchResultsPage.class);
        productPage = PageFactory.initElements(driver, RozetkaProductPage.class);
        loginPopup = PageFactory.initElements(driver, RozetkaHeaderLoginPopup.class);
        wishlistsPage = PageFactory.initElements(driver, RozetkaWishlistsPage.class);
    }

    @Test (dataProvider = "product")
    public void RozetkaSearchProductAndCountProducts(String productText) throws Exception {

        homePage = new RozetkaHomePage();

        //search product
        header.searchProduct(productText);
        //clickElement(header.searchBtn);

        //verify search results page
        Assert.assertEquals(searchResultsPage.searchResultsTitleText.getText(), productText);

        //count results on the page
        List<WebElement> searchResults = searchResultsPage.getSearchResults();
        int i = 0;
        for (WebElement e : searchResults) {
            i++;
            System.out.println(i + ". " + searchResultsPage.getProductLinkText(e));
        }
        System.out.println("Number of elements: " + i);
    }

    @Test (dataProvider = "product")
    public void RozetkaSearchAndVerifyProductNameAddWishlist(String productText) throws Exception {
        //preconditions
        homePage = new RozetkaHomePage();
        loginPopup.fillLoginFormAndClickLogin("tatarchykoleg@gmail.com", "testPass");

        //search product
        header.searchProduct(productText);

        //click on the link of EACH product and verify product Name, and then add it to wishlist and verify that product is in wishlist
        List<WebElement> searchResults = searchResultsPage.getSearchResults();
        //searchResults.indexOf(searchResultsPage.searchResultsTitleText);
        for (WebElement e : searchResults) {

            //get text of the element from the search
            String searchResultsElementLinkText = searchResultsPage.getProductLinkText(e);
            searchResultsPage.clickProductLink(e);

            //Verify that the product name on product page contains text from the product on results page.
            Assert.assertTrue(productPage.getProductLinkText().contains(searchResultsElementLinkText));

            //Add the product to wishlist and verify that in it.
            productPage.addProductToUserWishlist();
            wishlistsPage.initPage();
            wishlistsPage.verifyIsGoodExist(searchResultsElementLinkText);

            break;
        }
    }


}
