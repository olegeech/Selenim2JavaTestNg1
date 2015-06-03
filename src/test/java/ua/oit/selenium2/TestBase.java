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
    private StringBuffer verificationErrors = new StringBuffer();

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
    public void setElementText(String name, By element) {
        WebElement e = driver.findElement(element);
        e.click();
        e.clear();
        e.sendKeys(name);
    }

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

    public void clickElement(By element) {
        WebElement e = driver.findElement(element);
        e.click();
    }

/*    public void getAttribute(By element; String attribute) {
        WebElement e = driver.findElement(element);
        e.attribute;
    }*/

    public String getElementText(By element) {
        WebElement e = driver.findElement(element);
        String text = e.getText();
        return text;
    }

    public void waitForElement(By element) {
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForPageToLoad() {
        driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
    }

    public boolean isElementDisplayed(By element) {
        WebElement e = driver.findElement(element);
        boolean isDisplayed = e.isDisplayed();
        return isDisplayed;
    }

    public void getElementAttribute(By element) {
        WebElement e = driver.findElement(element);
        e.getAttribute(String.valueOf(element));
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void assertElementText(By element, String expectedText) {
        String actualElementText = getElementText(element);
        if (!actualElementText.equals(expectedText)) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException(
                    "\n >> Web element: "+element+
                    "\n >> Expected text of the element: "+expectedText+
                    "\n >> Actual text of the element: "+actualElementText);
            //System.out.printf("This is: %s page%n", actualPageTitle);
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
