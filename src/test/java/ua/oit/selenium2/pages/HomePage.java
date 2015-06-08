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

  @FindBy(how = How.TAG_NAME, using = "h1") @CacheLookup public WebElement header;
  @FindBy(tagName = "h1") @CacheLookup public WebElement same_header;
  By same_header_by = By.tagName("h1");
  By emailLocator = By.id("r_email");

  public HomePage(WebDriver webDriver) {
    super(webDriver);
  }

}
