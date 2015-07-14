package ua.oit.selenium2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import ua.oit.selenium2.pages.ZHomePage;

public class ZSampleTest extends TestBase {

  private ZHomePage homepage;

  @BeforeMethod
  public void initPageObjects() {
    homepage = PageFactory.initElements(driver, ZHomePage.class);
  }

  //@Test
  public void testHomePageHasAHeader() {
    driver.get(baseUrl);

    //Explicit wait examples
    WebDriverWait wait = new WebDriverWait(driver, 1);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id(homepage.HEADER_LOCATOR)));
    wait.until(ExpectedConditions.visibilityOf(homepage.header));
    wait.until(ExpectedConditions.visibilityOfElementLocated(homepage.sameHeaderBy));
    wait.until(ExpectedConditions.elementToBeClickable(homepage.sameHeader));
    wait.until(ExpectedConditions.elementToBeSelected(homepage.sameHeaderBy));
    wait.until(ExpectedConditions.elementToBeSelected(homepage.header));
    wait.until(ExpectedConditions.textToBePresentInElement(homepage.header, "Header"));
    wait.until(ExpectedConditions.stalenessOf(homepage.header));
    //wait.until(ExpectedConditions.alertIsPresent(homepage.header));
    wait.until(ExpectedConditions.titleContains("Header"));


    Assert.assertFalse("".equals(homepage.header.getText()));

  }


  /*
  * Obsolete methods from TestBase
  *
  *
  * */

  //private StringBuffer verificationErrors = new StringBuffer();

/*    @BeforeSuite
    public void initTestSuite() throws IOException {
        gridHubUrl = PropertyLoader.loadProperty("grid.url");
        if ("".equals(gridHubUrl) | "${grid.url}".equals(gridHubUrl)) {
            gridHubUrl = null;
        }
        capabilities = PropertyLoader.loadCapabilities();
        WebDriverFactory.setMode(WebDriverFactoryMode.THREADLOCAL_SINGLETON);
    }

*//*    @BeforeMethod
    public void initWebDriver() {
        driver = WebDriverFactory.getDriver(gridHubUrl, capabilities);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }*//*

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        WebDriverFactory.dismissAll();
    }*/
}
