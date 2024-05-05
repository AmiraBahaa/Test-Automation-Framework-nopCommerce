package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends PageBase{
    public EmailFriendPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id= "FriendEmail")
    WebElement friendEmailTextBox;

//    @FindBy(id= "YourEmailAddress")
//    WebElement userEmailTextBox;

    @FindBy(id = "PersonalMessage")
    WebElement personalMessageTextField;

    @FindBy(css= "div.result")
    public WebElement emailFriendSentMessage;

    @FindBy(xpath = "//button[@class=\"button-1 send-email-a-friend-button\"]")
    WebElement submitButton;


    public void fillEmailFriendForm(String friendEmail, String personalMessage){
        setTextElementText(friendEmailTextBox, friendEmail);
     //   setTextElementText(userEmailTextBox, userEmail);
        setTextElementText(personalMessageTextField, personalMessage);
        clickElement(submitButton);
    }

}
