package ua.oit.selenium2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Oleg on 07.06.2015.
 */
public class RozetkaSearchResultsPage extends Page {

    public RozetkaSearchResultsPage (WebDriver webDriver) {
        super(webDriver);
    }

    public String searchResultsElementXpathLocator = "//div[@data-location='searchResults']";
    public String searchResultsElementLinkXpathLocator = "//div[@class='g-i-list-middle-part']/div/a";

    @FindBy(className = "search-container")                   @CacheLookup public WebElement searchResultsConteiner;
    @FindBy(className = "search-result-title-text")           @CacheLookup public WebElement searchResultsTitleText;
    @FindBy(className = "g-i-list available clearfix")        @CacheLookup public WebElement searchResultsElementCss;
    //@FindBy(xpath = searchResultsElementXpathLocator)         @CacheLookup public WebElement searchResultsElementXpath;


    public void initPage() {
        isElementPresent(searchResultsConteiner);

    }


}
