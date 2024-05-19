package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemDetailsPage extends PageBase{
    public ItemDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "strong.current-item")
   public WebElement itemDetails;

   // @FindBy(xpath = "//button[@class=\"button-2 email-a-friend-button\"]")

    @FindBy(xpath = "//button[contains(text(), \"Email a friend\")]")
    WebElement emailFriendButton;

    @FindBy(id = "price-value-4")
   public WebElement priceValue;

    @FindBy(linkText = "Add your review")
    WebElement addYourReviewLink;


    public void openSendEmailFriend(){
        waitUntilItemIsClickable(emailFriendButton);
        clickElement(emailFriendButton);
    }


    public  void openItemReviewPage(){
        clickElement(waitUntilItemIsClickable(addYourReviewLink));
    }

    public boolean getCurrencyValue(String currency){
        return waitItemTextChanged(priceValue, currency);

    }

}
