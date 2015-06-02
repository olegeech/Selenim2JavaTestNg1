package ua.oit.selenium2.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public class Page {
    protected WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    /*
     * Constructor injecting the WebDriver interface
     *
     * @param webDriver
     */
    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void isRightPage(String expectedPageTitle) {
        // Check that we're on the right page.
        String actualPageTitle = driver.getTitle();
        if (!actualPageTitle.contains(expectedPageTitle)) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("\n This is NOT the " + expectedPageTitle + " page\n this is page:"+ actualPageTitle);
            //System.out.printf("This is: %s page%n", actualPageTitle);
        }
    }

    public void setElementText(String name, By element) {
        WebElement e = driver.findElement(element);
        e.click();
        e.clear();
        e.sendKeys(name);
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
            throw new IllegalStateException("This is NOT the right text of the element: "+ expectedText +" \n the actual text of the element is: "+ actualElementText);
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
