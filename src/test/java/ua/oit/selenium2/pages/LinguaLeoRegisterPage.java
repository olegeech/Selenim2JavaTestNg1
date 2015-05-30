package ua.oit.selenium2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Oleg on 30.05.2015.
 */
public class LinguaLeoRegisterPage {
    private final WebDriver driver;

    public LinguaLeoRegisterPage(WebDriver driver) {
        this.driver = driver;

/*        // Check that we're on the right page.
        if (!"Login".equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("This is not the login page");
        }*/
    }

    By emailLocator = By.id("r_email");

    public LinguaLeoRegisterPage typeEmail(String email) {
        driver.findElement(emailLocator).click();
        driver.findElement(emailLocator).clear();
        driver.findElement(emailLocator).sendKeys(email);

        return this;
    }

}