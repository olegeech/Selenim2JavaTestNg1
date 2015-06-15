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
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        WebDriverFactory.dismissAll();
    }



    public boolean isElementPresent(WebElement e) {
        try {
            e.findElement(By.id(e.getTagName()));
            return true;
        } catch (NoSuchElementException ex) {
            return false;
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
