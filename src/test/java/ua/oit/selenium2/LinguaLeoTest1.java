package ua.oit.selenium2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.oit.selenium2.pages.LinguaLeoRegisterPage;

import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;

/**
 * Created by Oleg on 30.05.2015.
 * Change 1
 *
 */
public class LinguaLeoTest1 extends TestBase {
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    private LinguaLeoRegisterPage registrationpage;

    @BeforeMethod
    public void initPageObjects() {
        //homepage = PageFactory.initElements(driver, HomePage.class);
        registrationpage = PageFactory.initElements(driver, LinguaLeoRegisterPage.class);
    }

    @Test
    public void testLingvaleoRegister1() throws Exception {
        //TODO: remove InterruptedException and add Explicit and Implicit Waits (http://www.seleniumhq.org/docs/04_webdriver_advanced.jsp)
        baseUrl = "https://lingualeo.com/register";
        String email = "vitalyachief+30@gmail.com";

        driver.get(baseUrl);
        registrationpage.typeEmail(email);

        //TODO refactor this code below
        driver.findElement(By.id("r_password")).click();
        driver.findElement(By.id("r_password")).clear();
        driver.findElement(By.id("r_password")).sendKeys("6512381");
        //driver.findElement(By.xpath("//input[@value='Создать аккаунт']")).click();
        driver.findElement(By.xpath("//input[@class='btn-upper-orange btn-big au-form__btn']")).click();
        assertTrue(isElementPresent(By.cssSelector("div.dash-intro__greeting.clearfix")));
        assertTrue(isElementPresent(By.cssSelector("div.dash-intro__title")));
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
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
