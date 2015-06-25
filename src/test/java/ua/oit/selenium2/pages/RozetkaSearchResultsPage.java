package ua.oit.selenium2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Oleg on 07.06.2015.
 */
public class RozetkaSearchResultsPage extends Page {

    public RozetkaSearchResultsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String searchResultsElementXpath = "//div[@data-location='searchResults']";
    public final String searchResultsElementLinkXpath = "//div[@class='g-i-list-middle-part']/div/a";

    @FindBy(xpath = searchResultsElementLinkXpath)      @CacheLookup public WebElement searchResultsElementLink;
    @FindBy(className = "search-container")             @CacheLookup public WebElement searchResultsConteiner;
    @FindBy(className = "search-result-title-text")     @CacheLookup public WebElement searchResultsTitleText;
    @FindBy(className = "g-i-list available clearfix")  @CacheLookup public WebElement searchResultsElementCss;
    //@FindBy(xpath = searchResultsElementXpath)         @CacheLookup public WebElement searchResultsElementXpath;


    public void initPage() {
        isElementPresent(searchResultsConteiner);

    }

    public List<WebElement> getSearchResults() {
        return searchResultsConteiner.findElements(By.xpath(searchResultsElementXpath));
    }

    public String getProductLinkText(WebElement e) {
        return e.findElement(By.xpath(searchResultsElementLinkXpath)).getText();
    }

    public void clickProductLink(WebElement e) {
        e.findElement(By.xpath(searchResultsElementLinkXpath)).click();
    }


}
