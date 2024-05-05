package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;


public class TestBase {

public static WebDriver driver;

@BeforeSuite
@Parameters({"browser "})
public void startDriver(@Optional("chrome")  String browserName){
    if (browserName.equalsIgnoreCase("chrome")){
        driver= new ChromeDriver();
    }

    else if (browserName.equalsIgnoreCase("firefox")){
        driver= new FirefoxDriver();

    }
    else if (browserName.equalsIgnoreCase("edge")){
        driver= new EdgeDriver();

    }

    // Navigate to the URL
    driver.get("https://demo.nopcommerce.com/");
}

    @AfterMethod
    public void screenshotOnFailure(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            System.out.println("failed");
            System.out.println("taking ss");
            Helper.captureScreenShot(driver, result.getName());


        }}

@AfterSuite
    public void stopDriver(){
    driver.quit();
}
}

