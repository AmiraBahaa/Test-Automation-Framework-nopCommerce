package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    @Test
    public void checkLoginMessage(){
        homePage = new HomePage(driver);
        loginPage= new LoginPage(driver);
        homePage.openLoginPage();
        loginPage.userLogin("amirabahaa7@gmail.com", "185cmcmc");
    //    System.out.println(loginPage.logoutButtonVisible().getText());
        Assert.assertTrue(loginPage.logoutButtonVisible().getText().contains("Log out"));
    }
    @Test
    public void userCanLogOut(){
        homePage= new HomePage(driver);
        loginPage= new LoginPage(driver);
        loginPage.clickOnlogoutButton();
        Assert.assertTrue(homePage.loginButtonVisible().getText().equals("Log in"));
    }

}
