package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemReviewPage extends PageBase{
    public ItemReviewPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "AddProductReview_Title")
    WebElement reviewTitleTextBox;

    @FindBy(id = "AddProductReview_ReviewText")
    WebElement reviewTextTextBox;

    //genericccccccccccccccccccccc
    @FindBy(id= "addproductrating_5")
    WebElement rating4;

    @FindBy(xpath = "//button[@class= \"button-1 write-product-review-button\"]")
    WebElement submitReviewButton;

    @FindBy(xpath = "//div[@id=\"bar-notification\" ]//p")
    WebElement reviewIsSent;


    public void submitReview(String reviewTitle, String reviewText ){
        waitItemVisibility(reviewTitleTextBox);
        setTextElementText(reviewTitleTextBox,reviewTitle);
        setTextElementText(reviewTextTextBox, reviewText);
        clickElement(rating4);
        clickElement(waitUntilItemIsClickable(submitReviewButton));
    }

    public WebElement riviewItemIsSent(){
      return   waitItemVisibility(reviewIsSent);
    }




}
