package tests;


import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.RegistrationPage;
import BaseTest.BaseTest;

public class RegistrationTest extends BaseTest {

    @Test
    public void testValidRegistration() {
        driver.get("https://demo.nopcommerce.com/register");
        RegistrationPage register = new RegistrationPage(driver);

        register.selectGender();
        register.enterFirstName("automation");
        register.enterLastName("tester");
        register.enterEmail("test" + System.currentTimeMillis() + "@example.com");
        register.enterPassword("P@ssw0rd");
        register.clickRegister();

        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Page Title: " + driver.getTitle());

        Assert.assertEquals(register.getSuccessMessage(),
                "Your registration completed");

        String actualColor = register.getSuccessMessageColor();
        String hexColor = Color.fromString(actualColor).asHex();
        Assert.assertEquals(hexColor, "rgba(76, 177, 124, 1)");


    }


}
