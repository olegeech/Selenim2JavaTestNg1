package ua.oit.selenium2;

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

    WebDriverWait wait = new WebDriverWait(driver, 1);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id(homepage.HEADER_LOCATOR)));

    Assert.assertFalse("".equals(homepage.header.getText()));




  }


}
