package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    private By genderFemale = By.id("gender-female");
    private By firstName = By.id("FirstName");
    private By lastName = By.id("LastName");
    private By day = By.name("DateOfBirthDay");
    private By email = By.id("Email");
    private By password = By.id("Password");
    private By confirmPassword = By.id("ConfirmPassword");
    private By registerButton = By.id("register-button");
    private By successMessage = By.className("result");

     public void selectGender() {
         driver.findElement(genderFemale).click();
     }

    public void enterFirstName(String fname) {
        driver.findElement(firstName).sendKeys(fname);
    }

    public void enterLastName(String lname) {
        driver.findElement(lastName).sendKeys(lname);
    }

    public void selectDateOfBirth(String d, String m, String y) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(day));
        Select dayDropdown = new Select(driver.findElement(By.name("DateOfBirthDay")));
        Select monthDropdown = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        Select yearDropdown = new Select(driver.findElement(By.name("DateOfBirthYear")));

        dayDropdown.selectByVisibleText(d);
        monthDropdown.selectByVisibleText(m);
        yearDropdown.selectByVisibleText(y);
    }

    public void enterEmail(String mail) {
        driver.findElement(email).sendKeys(mail);
    }

    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
        driver.findElement(confirmPassword).sendKeys(pass);
    }

    public void clickRegister() {
        driver.findElement(registerButton).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }

    public String getSuccessMessageColor() {
        WebElement message = driver.findElement(successMessage);
        return message.getCssValue("color");
    }
}

