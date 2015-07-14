package ua.oit.selenium2;

import org.openqa.selenium.*;

/**
 * Base class for TestNG-based test classes
 * For load property "site.url" use:
 * baseUrl = PropertyLoader.loadProperty("site.url");
 * gridHubUrl = PropertyLoader.loadProperty("grid.url");
 * capabilities = PropertyLoader.loadCapabilities();
 * WebDriverFactory.setMode(WebDriverFactoryMode.THREADLOCAL_SINGLETON);
 *
 *
 */

public class TestBase {
    protected static String baseUrl;
    protected WebDriver driver;
}
