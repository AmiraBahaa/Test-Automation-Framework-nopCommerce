package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class EmailFriendTest extends TestBase{

    String userEmail = "amirabahaa52@gmail.com";
    String password= "185cmcmc";
    String friendEmail = "amirabahaa@yahoo.com";
    String message = "hello this is your favorite item ";

    HomePage homePage ;
    UserRegisterationPage userRegisterationPage;
    LoginPage loginPage;

    EmailFriendPage emailFriendPage;

    SearchPage searchPage;
    ItemDetailsPage itemDetailsPage;
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

    //email

    @Test(priority =4)
    public void userCanEmailFriend(){
        itemDetailsPage= new ItemDetailsPage(driver);
        emailFriendPage= new EmailFriendPage(driver);
        itemDetailsPage.openSendEmailFriend();
        emailFriendPage.fillEmailFriendForm(friendEmail, message);
        Assert.assertTrue(emailFriendPage.emailFriendSentMessage.isDisplayed());
    }

    //logout

    @Test(priority =5)
    public void userCanLogOut(){
        homePage= new HomePage(driver);
        loginPage= new LoginPage(driver);
        loginPage.clickOnlogoutButton();
        Assert.assertTrue(homePage.loginButtonVisible().getText().equals("Log in"));
    }
}
