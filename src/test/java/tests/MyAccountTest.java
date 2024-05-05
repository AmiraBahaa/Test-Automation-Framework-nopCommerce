package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;

public class MyAccountTest extends TestBase{

    HomePage homePage;
    MyAccountPage myAccountPage;
    LoginPage loginPage;
    String oldPassword= "185cmcmc";
    String newPassword= "185cwmmwmw";

    @Test
    public void checkLoginMessage(){
        homePage = new HomePage(driver);
        loginPage= new LoginPage(driver);
        homePage.openLoginPage();
        loginPage.userLogin("amirabahaa7@gmail.com", oldPassword);
        Assert.assertTrue(loginPage.logoutButtonVisible().getText().contains("Log out"));
    }

    @Test
    public void userCanChangePassword(){
    homePage = new HomePage(driver);
    myAccountPage= new MyAccountPage(driver);
    homePage.openMyAccountPage();
    myAccountPage.clickChangePasswordLink();
    myAccountPage.setNewPassword(oldPassword,newPassword);
    Assert.assertTrue(myAccountPage.NewPasswordChangednotificationVisibile().getText().contains("Password was changed"));
    }



}
