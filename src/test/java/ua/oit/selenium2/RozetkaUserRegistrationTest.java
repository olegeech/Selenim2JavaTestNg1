package ua.oit.selenium2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.oit.selenium2.pages.RozetkaSignupPage;

/**
 * Created by Oleg on 02.06.2015.
 */
public class RozetkaUserRegistrationTest extends TestBase {
    private RozetkaSignupPage rozetka;

    @BeforeMethod
    public void initPageObjects() {
        rozetka = PageFactory.initElements(driver, RozetkaSignupPage.class);
    }

    @Test
    public void RozetkaUserRegistrationTest() throws Exception {
        baseUrl = "https://my.rozetka.com.ua/signup/";
        String name = "testName";
        String email = "testEmail";
        String pwd = "testPass";

        driver.get(baseUrl);

        rozetka.setElementText(name, rozetka.nameFieldLocator);

        //rozetka.setElementText(email, driver.findElement(By.name("email")));
        //rozetka.setElementText(pwd, driver.findElement(By.name("password")));


        //driver.findElement(By.xpath("//div[@class='signup-submit']//button[.='Зарегистрироваться']")).click();

    }


}
