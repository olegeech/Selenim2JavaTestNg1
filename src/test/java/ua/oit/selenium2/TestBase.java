package ua.oit.selenium2;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import ru.stqa.selenium.factory.WebDriverFactory;
import ru.stqa.selenium.factory.WebDriverFactoryMode;

import ua.oit.selenium2.util.PropertyLoader;

/**
 * Base class for TestNG-based test classes
 */

public class TestBase {

    protected static String gridHubUrl;
    protected static String baseUrl;
    protected static Capabilities capabilities;

    protected WebDriver driver;

    private boolean acceptNextAlert = true;
    //private StringBuffer verificationErrors = new StringBuffer();

    @BeforeSuite
    public void initTestSuite() throws IOException {
        baseUrl = PropertyLoader.loadProperty("site.url");
/*        if ("".equals(baseUrl) | "${site.url}".equals(baseUrl)) {
            baseUrl = null;
        }*/
        gridHubUrl = PropertyLoader.loadProperty("grid.url");
        if ("".equals(gridHubUrl) | "${grid.url}".equals(gridHubUrl)) {
            gridHubUrl = null;
        }
        capabilities = PropertyLoader.loadCapabilities();
        WebDriverFactory.setMode(WebDriverFactoryMode.THREADLOCAL_SINGLETON);
    }

    @BeforeMethod
    public void initWebDriver() {
        driver = WebDriverFactory.getDriver(gridHubUrl, capabilities);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        WebDriverFactory.dismissAll();
    }



    /**
     * This is functions library below
     *
     */


    public String getTitle() {
        return driver.getTitle();
    }

    public void isRightPage(String expectedPageTitle) {
        // Check that we're on the right page.
        String actualPageTitle = driver.getTitle();
        if (!actualPageTitle.contains(expectedPageTitle)) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
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

    public String getElementText(WebElement e) {
        String text = e.getText();
        return text;
    }

    public void waitForElement(WebElement e) {
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(e));
    }

    public void waitForPageToLoad() {
        driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
    }

    public boolean isElementDisplayed(WebElement e) {
        boolean isDisplayed = e.isDisplayed();
        return isDisplayed;
    }

    public String getElementAttribute(WebElement e) {
        String text = e.getAttribute(String.valueOf(e));
        return text;
    }

    public boolean isElementPresent(WebElement e) {
        try {
            e.findElement(By.id(e.getTagName()));
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public void assertElementText(WebElement e, String expectedText) {
        String actualElementText = getElementText(e);
        if (!actualElementText.equals(expectedText)) {
            throw new IllegalStateException(
                    "\n >> Web element: "+e+
                    "\n >> Expected text of the element: "+expectedText+
                    "\n >> Actual text of the element: "+actualElementText);
        }
    }

    public String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
