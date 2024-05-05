package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends PageBase {



    public HomePage(WebDriver driver) {

        super(driver);
        js = (JavascriptExecutor) driver;
    }

    @FindBy(linkText ="Register")
    WebElement registerButton;
    
    @FindBy(linkText = "Log in")
    WebElement loginButton;


    @FindBy(linkText = "My account")
    WebElement myAccountButton;

    @FindBy(xpath = "//a[contains(text(), \"Contact us\")]")
    WebElement contactUs;

    @FindBy(id = "customerCurrency")
    WebElement currencyDropDown;


    public void openRegisterPage() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30) );
        WebElement registerButtonReady=wait.until(ExpectedConditions.elementToBeClickable(registerButton));
        clickElement(registerButtonReady);
    }

    public void openLoginPage() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30) );
        WebElement loginButtonReady=wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        clickElement(loginButtonReady);
    }

    public WebElement loginButtonVisible() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30) );
        return wait.until(ExpectedConditions.elementToBeClickable(loginButton));

    }



    public void openMyAccountPage(){
        WebElement myAccountButtonClickable= waitUntilItemIsClickable(myAccountButton);
        clickElement(myAccountButtonClickable);
    }


    public void openContactUsPage(){
        scrollToBottom();
        waitUntilItemIsClickable(contactUs);
        clickElement(contactUs);
    }


public void changeCurrency(){
        waitUntilItemIsClickable(currencyDropDown);
        select = new Select(currencyDropDown);
        select.selectByVisibleText("Euro");

}


}
