package ua.oit.selenium2.pages;

import org.openqa.selenium.*;

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

}
