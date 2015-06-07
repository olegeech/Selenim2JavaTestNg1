package ua.oit.selenium2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.oit.selenium2.pages.LinguaLeoRegisterPage;

import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;

/**
 * Created by Oleg on 30.05.2015.
 * Change 2
 *
 */
public class LinguaLeoTest1 extends TestBase {
    private LinguaLeoRegisterPage registrationpage;

    @BeforeMethod
    public void initPageObjects() {
        registrationpage = PageFactory.initElements(driver, LinguaLeoRegisterPage.class);
    }

    @Test
    public void testLingvaleoRegister1() throws Exception {
        baseUrl = "https://lingualeo.com/register";
        String email = "vitalyachief+30@gmail.com";

        driver.get(baseUrl);
        registrationpage.typeEmail(email);

        //TODO refactor this code below
        WebElement passwordField = driver.findElement(By.id("r_password"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("6512381");
        //driver.findElement(By.xpath("//input[@value='Создать аккаунт']")).click();
        driver.findElement(By.xpath("//input[@class='btn-upper-orange btn-big au-form__btn']")).click();
/*        assertTrue(isElementPresent(By.cssSelector("div.dash-intro__greeting.clearfix"))); //TODO: to fix
        assertTrue(isElementPresent(By.cssSelector("div.dash-intro__title")));*/
    }

}
