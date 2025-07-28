package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By emailFiled = By.id("Email");
    private By passwordFiled = By.id("Password");
    private By loginButton = By.cssSelector("button.login-button");
    private By errorMessage = By.cssSelector("div.message-error.validation-summary-errors");
    private By myAccountLink = By.className("ico-account");


    public void enterEmail(String email){
        driver.findElement(emailFiled).clear();
        driver.findElement(emailFiled).sendKeys(email);
    }
   public void enterPassword(String password){
        driver.findElement(passwordFiled).clear();
        driver.findElement(passwordFiled).sendKeys();
   }

   public void clickLogin(){
        driver.findElement(loginButton).click();
   }

   public boolean isMyAccountVisible(){
        return driver.findElement(myAccountLink).isDisplayed();
   }

   public String getCurrentURL(){
       return driver.getCurrentUrl();
   }

   public String geterrorMessage(){
        return driver.getCurrentUrl();
   }

    public String getErrorMessageText() {
        return driver.findElement(errorMessage).getText();
    }

    public String getErrorMessageColor() {
        WebElement error = driver.findElement(errorMessage);
        return error.getCssValue("color");
    }
}
