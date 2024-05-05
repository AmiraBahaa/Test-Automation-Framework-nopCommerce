package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

import java.time.Duration;

public class UserRegisterationTest extends TestBase{

    HomePage homePage ;
    UserRegisterationPage userRegisterationPageObject;



    @Test
    public void UserSuccessfullyRegistered(){
       homePage = new HomePage(driver);
       homePage.openRegisterPage();
       userRegisterationPageObject = new UserRegisterationPage(driver);
       userRegisterationPageObject.registeration("Amira", "Bahaa", "amirabahaa7@gmail.com", "185cmcmc");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement registerationMessageReady = wait.until(ExpectedConditions.visibilityOf(userRegisterationPageObject.registerationMessage));
        Assert.assertTrue(registerationMessageReady.getText().contains("Your registration completed"));
    }


}

//   32652362