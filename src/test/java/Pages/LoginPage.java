package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wdwait;
    WebElement loginTitle;
    WebElement usernameField;
    WebElement passwordField;
    WebElement loginButton;
    WebElement errorMessage;


    public WebElement getErrorMessage() {
        return driver.findElement(By.id("flash"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.cssSelector(".fa.fa-2x.fa-sign-in"));
    }

    public WebElement getPasswordField() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getUsernameField() {
        return driver.findElement(By.id("username"));
    }

    public WebElement getLoginTitle() {
        return driver.findElement(By.xpath("/html/body/div[2]/div/div/h2"));
    }

    public LoginPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public void ClickOnLoginButton(){
        driver.findElement(By.cssSelector(".fa.fa-2x.fa-sign-in")).click();
    }

}
