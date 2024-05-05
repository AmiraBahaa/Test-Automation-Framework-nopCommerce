package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyAccountPage extends PageBase{
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="OldPassword")
    WebElement oldPasswordTextBox;

    @FindBy(id="NewPassword")
    WebElement newPasswordTextBox;

    @FindBy(id="ConfirmNewPassword")
    WebElement confirmPasswordTextBox;

    @FindBy(xpath = "//button[@class=\"button-1 change-password-button\"]")
    WebElement changePasswordSubmitButton;

    @FindBy(xpath = "//a[@href=\"/customer/changepassword\"]")
    WebElement changePasswordLink;

    @FindBy(xpath = "//div[@id=\"bar-notification\"]//p[contains(text(), \"Password was changed\")]")
   public  WebElement notificationNewPasswordChanged;

    public void clickChangePasswordLink(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement changePasswordLinkVisible = wait.until(ExpectedConditions.visibilityOf(changePasswordLink));
        clickElement(changePasswordLinkVisible);

    }

    public void setNewPassword(String oldPassword, String newPassword){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement oldPasswordTextBoxVisible = wait.until(ExpectedConditions.visibilityOf(oldPasswordTextBox));
        oldPasswordTextBoxVisible.sendKeys(oldPassword);
        newPasswordTextBox.sendKeys(newPassword);
        confirmPasswordTextBox.sendKeys(newPassword);
        WebElement changePasswordButtonVisible = wait.until(ExpectedConditions.elementToBeClickable(changePasswordSubmitButton));
        clickElement(changePasswordButtonVisible);

    }

    public WebElement NewPasswordChangednotificationVisibile(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return  wait.until(ExpectedConditions.visibilityOf(notificationNewPasswordChanged));


    }




}
