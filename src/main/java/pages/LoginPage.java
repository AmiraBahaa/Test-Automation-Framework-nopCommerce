package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id= "Email")
    WebElement emailTextBox;

    @FindBy(id="Password")
    WebElement passwordTextBox;

    @FindBy(css= "button.button-1.login-button")
    WebElement loginButton ;

    @FindBy (linkText = "Log out")
    public WebElement logOutButton;

    public void userLogin(String email , String password){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement emailTextBoxReady= wait.until(ExpectedConditions.visibilityOf(emailTextBox));
        setTextElementText(emailTextBoxReady, email);
        setTextElementText(passwordTextBox, password);
        clickElement(wait.until(ExpectedConditions.elementToBeClickable(loginButton)));

    }

    public WebElement logoutButtonVisible(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOf(logOutButton));

    }

    public void clickOnlogoutButton(){
        clickElement(logoutButtonVisible());
    }


}
