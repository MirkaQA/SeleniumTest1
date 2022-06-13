package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

    public class SecureArea {
    WebDriver driver;
    WebDriverWait wdwait;
    WebElement secureAreaTitle;
    WebElement logoutButton;
    WebElement welcomeMessage;


        public SecureArea(WebDriver driver, WebDriverWait wdwait) {
            this.driver = driver;
            this.wdwait = wdwait;
        }

        public WebElement getWelcomeMessage() {
            return driver.findElement(By.className("subheader"));
        }

        public WebElement getLogoutButton() {
            return driver.findElement(By.cssSelector(".icon-2x.icon-signout"));
        }

        public WebElement getSecureAreaTitle() {
            return driver.findElement(By.id("flash"));
        }


        public void ClickOnLogoutButton(){
            driver.findElement(By.cssSelector(".icon-2x.icon-signout")).click();
        }
    }
