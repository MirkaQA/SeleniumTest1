package Base;

import Pages.LoginPage;
import Pages.SecureArea;
import Test.PracticeTesting;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wdwait;
    public LoginPage loginPage;
    public SecureArea secureArea;
    public PracticeTesting practiceTesting;


    @BeforeClass
    public void Setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage(driver, wdwait);
        secureArea = new SecureArea(driver, wdwait);
        practiceTesting = new PracticeTesting();
    }

    public void VisibilityWait(WebElement element){
        wdwait.until(ExpectedConditions.visibilityOf(element));
    }

    @AfterClass
    public void TearDown(){
        driver.close();
        driver.quit();
    }

}
