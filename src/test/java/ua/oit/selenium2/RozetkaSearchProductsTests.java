package ua.oit.selenium2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.oit.selenium2.pages.*;

import java.util.List;

/**
 * Created by Oleg on 07.06.2015.
 */
public class RozetkaSearchProductsTests extends TestBase {
    //Public variables
    public String productText = "test";

    private RozetkaHeader header;
    private RozetkaHomePage homePage;
    private RozetkaSearchResultsPage searchResultsPage;
    private RozetkaProductPage productPage;

    @BeforeMethod
    public void initPageObjects() {
        header = PageFactory.initElements(driver, RozetkaHeader.class);
        homePage = PageFactory.initElements(driver, RozetkaHomePage.class);
        searchResultsPage = PageFactory.initElements(driver, RozetkaSearchResultsPage.class);
        productPage = PageFactory.initElements(driver, RozetkaProductPage.class);
    }

    @Test
    public void RozetkaSearchAProductTest1() throws Exception {
        homePage.initPage();

        //search product
        searchProduct(productText);
        //clickElement(header.searchBtn);

        //verify search results page
        Assert.assertEquals(searchResultsPage.searchResultsTitleText.getText(), productText);
        //count results on the page
        List<WebElement> items = searchResultsPage.searchResultsConteiner
                .findElements(By.xpath(searchResultsPage.searchResultsElementXpath));
        int i = 0;
        for (WebElement e : items) {
            i++;
            String elementLinkText = e.findElement(By.xpath(searchResultsPage.searchResultsElementLinkXpath)).getText();
            System.out.println(i+". "+elementLinkText);
        }
        System.out.println("Number of elements: "+i);
    }

    @Test
    public void RozetkaSearchAndVerifyProductName() throws Exception {
        homePage.initPage();

        //search product
        searchProduct(productText);

        //click on the link of EACH product and verify product Name
        List<WebElement> items = searchResultsPage.searchResultsConteiner
                .findElements(By.xpath(searchResultsPage.searchResultsElementXpath));
        for (WebElement e : items) {
            String elementLinkTextOnSearchResultsPage = e.findElement(By.xpath(searchResultsPage.searchResultsElementLinkXpath)).getText();
            e.findElement(By.xpath(searchResultsPage.searchResultsElementLinkXpath)).click();

            String elementLinkTextOnProductPage = productPage.pageBody
                    .findElement(By.xpath(productPage.productTitleTextXpath)).getText();
            Assert.assertEquals(elementLinkTextOnSearchResultsPage, elementLinkTextOnProductPage);
            break;
        }
    }

    public void searchProduct(String productText) {
        setElementText(productText, header.searchField);
        header.searchField.sendKeys(Keys.ENTER);
        isElementPresent(searchResultsPage.searchResultsConteiner);
    }
}
