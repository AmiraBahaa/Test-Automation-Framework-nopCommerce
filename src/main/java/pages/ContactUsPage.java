package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "FullName")
    WebElement fullNameTextBox;

    @FindBy(id="Email")
    WebElement emailTextBox;

    @FindBy(id= "Enquiry")
    WebElement enquiryTextBox;

    @FindBy(xpath = "//button[@class= \"button-1 contact-us-button\"]")
    WebElement submitButton;


    @FindBy(xpath ="//div[contains(text(), \"Your enquiry has been successfully sent to the store owner.\")]")
    public WebElement contactUsSubmittedMessage;

    public void fillContactUsInformation(String fullNAme , String email , String enquiry){
        setTextElementText(fullNameTextBox,fullNAme );
        setTextElementText(emailTextBox,email);
        setTextElementText(enquiryTextBox, enquiry);
        clickElement(submitButton);
    }


}
