package ua.oit.selenium2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Class {@code ZHomePage} is just example of a page and recycle been for some methods.
 * Use this class for obsolete methods or something you need to store but want clean code in main classes.
 *
 * @author Oleg Tatarchuk
 */
public class ZHomePage extends Page {

  public final String HEADER_LOCATOR = "h1";

  @FindBy(how = How.TAG_NAME, using = HEADER_LOCATOR) @CacheLookup public WebElement header;
  @FindBy(tagName = HEADER_LOCATOR) @CacheLookup public WebElement sameHeader;
  public By sameHeaderBy = By.tagName(HEADER_LOCATOR);
  public By emailLocator = By.id("r_email");

/*  public ZHomePage(WebDriver webDriver) {
    super(webDriver);
  }*/


  /*
 * Obsolete methods
 *
 */
  public void assertElementText(WebElement e, String expectedText) {
    String actualElementText = getElementText(e);
    if (!actualElementText.equals(expectedText)) {
      throw new IllegalStateException(
              "\n >> Web element: "+e+
                      "\n >> Expected text of the element: "+expectedText+
                      "\n >> Actual text of the element: "+actualElementText);
    }
  }

  public void waitForElement(WebElement e) {
    new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(e));
  }

  public void waitForPageToLoad() {
    driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
  }


  public String getElementAttribute(WebElement e) {
    String text = e.getAttribute(String.valueOf(e));
    return text;
  }

  public String getTitle() {
    return driver.getTitle();
  }

  public void isRightPage(String expectedPageTitle) {
    // Check that we're on the right page.
    String actualPageTitle = driver.getTitle();
    if (!actualPageTitle.contains(expectedPageTitle)) {
      // Alternatively, we could navigate to the fillLoginFormAndClickLogin page, perhaps logging out first
      throw new IllegalStateException(
              "\n >> Expected page: "+expectedPageTitle+
                      "\n >> actual page:"+ actualPageTitle);
      //System.out.printf("This is: %s page%n", actualPageTitle);
    }
  }

/*    public void getAttribute(By element; String attribute) {
        WebElement e = driver.findElement(element);
        e.attribute;
    }*/

}
