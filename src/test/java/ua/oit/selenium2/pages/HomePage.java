package ua.oit.selenium2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Sample page
 */
public class HomePage extends Page {

  public final String HEADER_LOCATOR = "h1";

  @FindBy(how = How.TAG_NAME, using = HEADER_LOCATOR) @CacheLookup public WebElement header;
  @FindBy(tagName = HEADER_LOCATOR) @CacheLookup public WebElement sameHeader;
  public By sameHeaderBy = By.tagName(HEADER_LOCATOR);
  public By emailLocator = By.id("r_email");

  public HomePage(WebDriver webDriver) {
    super(webDriver);
  }

}
