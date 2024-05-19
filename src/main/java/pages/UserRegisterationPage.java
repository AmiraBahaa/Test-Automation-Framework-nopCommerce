package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserRegisterationPage extends PageBase{
    public UserRegisterationPage(WebDriver driver) {
        super(driver);
    }

    //radiobtn
    @FindBy(id="gender-female")
    WebElement genderFemale;

    @FindBy(id = "FirstName")
    WebElement firstNameTextBox;

    @FindBy(id="LastName")
    WebElement lastNameTextBox;

    @FindBy(id="Email")
    WebElement emailTextBox;

    @FindBy(id = "Password" )
    WebElement passwordTextBox;

    @FindBy(id="ConfirmPassword")
    WebElement confirmPasswordTextBox;

    @FindBy(id = "register-button")
    WebElement registerButton;

    @FindBy(css ="div.result")
    public WebElement registerationMessage;

    @FindBy(linkText = "Log out")

    public  WebElement logoutButton;



    public void  registeration(String firstname, String lastname, String email, String password ){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement genderButtonReady = wait.until(ExpectedConditions.elementToBeClickable(genderFemale));
        clickElement(genderButtonReady);
        setTextElementText(firstNameTextBox, lastname);
        setTextElementText(lastNameTextBox, lastname);
        setTextElementText(emailTextBox, email);
        setTextElementText(passwordTextBox, password);
        setTextElementText(confirmPasswordTextBox, password);
        WebElement registerButtonReady =  wait.until(ExpectedConditions.elementToBeClickable(registerButton));
        clickElement(registerButtonReady);
    }


    public void logOut(){
        WebElement logoutButtonReady = waitUntilItemIsClickable(logoutButton);
        clickElement(logoutButtonReady);
    }


}
