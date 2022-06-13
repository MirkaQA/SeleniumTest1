package Test;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeTesting extends BaseTest {

    public String homePageURL = "https://the-internet.herokuapp.com/login";

    @BeforeMethod
    public void PageSetup() throws InterruptedException {
        driver.manage().window().maximize();
        driver.navigate().to(homePageURL);
        //da je bilo sreće i da je proradio excel, ovde bi stajalo sledeće:
        //driver.navigate().to(String.valueOf(excelReader.getIntegerData("testData",1,4)));
        VisibilityWait(loginPage.getLoginButton());
    }


    @Test
    public void HappyPath(){
        Assert.assertTrue(loginPage.getLoginTitle().isDisplayed());
        Assert.assertEquals(homePageURL, driver.getCurrentUrl());
        loginPage.getUsernameField().sendKeys("tomsmith");
        loginPage.getPasswordField().sendKeys("SuperSecretPassword!");
        loginPage.getLoginButton().click();
        VisibilityWait(secureArea.getSecureAreaTitle());
    }

    @Test
    public void WrongUsername(){
        Assert.assertTrue(loginPage.getLoginTitle().isDisplayed());
        Assert.assertEquals(homePageURL, driver.getCurrentUrl());
        loginPage.getUsernameField().sendKeys("NijeValjda");
        loginPage.getPasswordField().sendKeys("SuperSecretPassword!");
        loginPage.getLoginButton().click();
        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
    }

    @Test
    public void WrongPassword(){
        Assert.assertTrue(loginPage.getLoginTitle().isDisplayed());
        Assert.assertEquals(homePageURL, driver.getCurrentUrl());
        loginPage.getUsernameField().sendKeys("tomsmith");
        loginPage.getPasswordField().sendKeys("PoslednjiTest");
        loginPage.getLoginButton().click();
        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
    }

    @Test
    public void BothWrong(){
        Assert.assertTrue(loginPage.getLoginTitle().isDisplayed());
        Assert.assertEquals(homePageURL, driver.getCurrentUrl());
        loginPage.getUsernameField().sendKeys("NijeValjda");
        loginPage.getPasswordField().sendKeys("PoslednjiTest");
        loginPage.getLoginButton().click();
        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
    }

    @Test
    public void EmptyCredentials(){
        Assert.assertTrue(loginPage.getLoginTitle().isDisplayed());
        Assert.assertEquals(homePageURL, driver.getCurrentUrl());
        loginPage.getLoginButton().click();
        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
    }
}
