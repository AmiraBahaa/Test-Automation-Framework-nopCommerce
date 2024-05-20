package tests;

import data.ExcelReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UserRegisterationPage;

import java.io.IOException;
import java.time.Duration;

public class UserRegisterationTest extends TestBase{

    HomePage homePage ;
    UserRegisterationPage userRegisterationPageObject;


    @DataProvider(name = "ExcelData")
    public Object [][] userRegisterData() throws IOException {
        ExcelReader excelReader= new ExcelReader();
        return excelReader.getExcelData();

    }

    @Test(priority = 1, alwaysRun = true, dataProvider = "ExcelData")
    public void UserSuccessfullyRegistered(String firstName , String lastName , String email , String password){
       homePage = new HomePage(driver);
       homePage.openRegisterPage();
       userRegisterationPageObject = new UserRegisterationPage(driver);
       userRegisterationPageObject.registeration(firstName, lastName, email, password);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement registerationMessageReady = wait.until(ExpectedConditions.visibilityOf(userRegisterationPageObject.registerationMessage));
        Assert.assertTrue(registerationMessageReady.getText().contains("Your registration completed"));
    }


}

//   32652362