package ua.oit.selenium2.pages;

import org.openqa.selenium.*;
import static com.codeborne.selenide.Selenide.*;
import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;

/**
 * Abstract class representation of a Page in the UI. Page object pattern.
 * All pages in this inheritance tree in charge for interacting with web elements located on the page.
 * Use methods in this class for interact with pages or add new.
 *
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

    public Page() {
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

    public void initPages(String pageUrl, String title) {
        open(pageUrl);
        assertEquals(title, title());
    }

    public String getElementText(WebElement e) {
        String text = e.getText();
        return text;
    }

}
