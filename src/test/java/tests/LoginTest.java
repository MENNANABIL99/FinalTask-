package tests;

import BaseTest.BaseTest;
import Pages.LoginPage;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class LoginTest extends BaseTest {


    public void testValidLogin() {
        driver.get("https://demo.nopcommerce.com/login");

        LoginPage login = new LoginPage(driver);

        login.enterEmail("test@example.com");
        login.enterPassword("P@ssw0rd");
        login.clickLogin();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(
                login.getCurrentURL(), "https://demo.nopcommerce.com/");
        softAssert.assertTrue(login.isMyAccountVisible());
        softAssert.assertAll();
    }

    public void testInValidLogin() {
        driver.get("https://demo.nopcommerce.com/login");

        LoginPage login = new LoginPage(driver);
        login.enterEmail("wrong@example.com");
        login.enterPassword("P@ssw0rd");
        login.clickLogin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        SoftAssert softAssert = new SoftAssert();

        String errorMsg = login.getErrorMessageText();
        softAssert.assertTrue(errorMsg.contains("Login was unsuccessful."));

        String rgbaColor = login.getErrorMessageColor();
        String hexColor = Color.fromString(rgbaColor).asHex();
        System.out.println("MessageColor" + hexColor);
        softAssert.assertEquals(hexColor, "#e4434b");


        softAssert.assertAll();

    }
}
