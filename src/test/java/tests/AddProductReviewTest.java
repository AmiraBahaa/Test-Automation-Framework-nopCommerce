package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class AddProductReviewTest extends TestBase{

ItemDetailsPage itemDetailsPage;
ItemReviewPage itemReviewPage;

    String userEmail = "amirabahaa5552@gmail.com";
    String password= "185cmcmc";

    HomePage homePage ;
    UserRegisterationPage userRegisterationPage;
    LoginPage loginPage;

    EmailFriendPage emailFriendPage;

    SearchPage searchPage;
    String itemName= "Apple MacBook Pro 13-inch";




    //user registeration


    @Test(priority = 1)
    public void UserSuccessfullyRegistered(){
        homePage = new HomePage(driver);
        homePage.openRegisterPage();
        userRegisterationPage = new UserRegisterationPage(driver);
        userRegisterationPage.registeration("Amira", "Bahaa", userEmail, password);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement registerationMessageReady = wait.until(ExpectedConditions.visibilityOf(userRegisterationPage.registerationMessage));
        Assert.assertTrue(registerationMessageReady.getText().contains("Your registration completed"));
    }

    @Test(priority = 2)

    public void checkLoginMessage(){
        homePage = new HomePage(driver);
        loginPage= new LoginPage(driver);
        homePage.openLoginPage();
        loginPage.userLogin(userEmail, password);
        //    System.out.println(loginPage.logoutButtonVisible().getText());
        Assert.assertTrue(loginPage.logoutButtonVisible().getText().contains("Log out"));
    }


    //search element
    @Test(priority = 3)
    public void CheckSearchItem(){
        searchPage= new SearchPage(driver);
        itemDetailsPage = new ItemDetailsPage(driver);
        searchPage.searchItem(itemName);
        searchPage.openItemDetails();
        Assert.assertEquals(itemDetailsPage.itemDetails.getText(),itemName);

    }

    @Test(priority = 4)
    public void userCanAddReview(){
        itemDetailsPage= new ItemDetailsPage(driver);
        itemReviewPage = new ItemReviewPage(driver);
        itemDetailsPage.openItemReviewPage();
        itemReviewPage.submitReview("Laptop Riview", "That's an amazing laptop");
        Assert.assertTrue(itemReviewPage.riviewItemIsSent().isDisplayed());



    }


}
