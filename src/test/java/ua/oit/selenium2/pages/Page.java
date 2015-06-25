package ua.oit.selenium2.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
abstract public class Page {
    protected WebDriver driver;

    /*
     * Constructor injecting the WebDriver interface
     *
     * @param webDriver
     */
    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isElementPresent(WebElement e) {
        if (driver.findElements(By.id(e.getTagName())).size() != 0) {
            return true;
        } else {
            return false;
        }
    }

    public void setElementText(String name, WebElement e) {
        e.click();
        e.clear();
        //clear edit box as a user (if needed)
/*      e.sendKeys(Keys.CONTROL + "a");
        Thread.sleep(200);
        e.sendKeys(Keys.DELETE);*/
        e.sendKeys(name);
    }

    public void clickElement(WebElement e) {
        e.click();
    }

    public void initPages(String pageUrl, String title) {
        driver.get(pageUrl);
        Assert.assertEquals(driver.getTitle(), title);
    }

    public String getElementText(WebElement e) {
        String text = e.getText();
        return text;
    }





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

}
