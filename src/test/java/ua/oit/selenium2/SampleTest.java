package ua.oit.selenium2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import ua.oit.selenium2.pages.HomePage;

public class SampleTest extends TestBase {

  private HomePage homepage;

  @BeforeMethod
  public void initPageObjects() {
    homepage = PageFactory.initElements(driver, HomePage.class);
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


}
