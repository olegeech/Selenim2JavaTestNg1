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
    private RozetkaHeader header;
    private RozetkaHomePage homePage;
    private RozetkaSearchResultsPage searchResultsPage;

    @BeforeMethod
    public void initPageObjects() {
        header = PageFactory.initElements(driver, RozetkaHeader.class);
        homePage = PageFactory.initElements(driver, RozetkaHomePage.class);
        searchResultsPage = PageFactory.initElements(driver, RozetkaSearchResultsPage.class);
    }

    @Test
    public void RozetkaSearchAProductTest1() throws Exception {
        String productText = "test";
        homePage.initPage();

        //search product
        setElementText(productText, header.searchField);
        header.searchField.sendKeys(Keys.ENTER);
        //clickElement(header.searchBtn);

        //verify search results page
        Assert.assertEquals(searchResultsPage.searchResultsTitleText.getText(), productText);
        //count results on the page
        isElementPresent(searchResultsPage.searchResultsElementCss);
        List<WebElement> items = driver.findElements(By.xpath(searchResultsPage.searchResultsElementXpathLocator));
        int i = 0;
        for (WebElement e : items) {
            i++;
            String elementLinkText = e.findElement(By.xpath(searchResultsPage.searchResultsElementLinkXpathLocator)).getText();
            System.out.println(i+". "+elementLinkText);
        }
        System.out.println("Number of elements: "+i);
    }
}
