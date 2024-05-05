package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage extends PageBase{

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id=\"small-searchterms\"]")
    WebElement searchItemTextBox;


    @FindBy(css = "button.button-1.search-box-button")
    WebElement searchItemButton;

    @FindBy(css = "#ui-id-1")
    List<WebElement> itemsSuggestionList;

    @FindBy(xpath = "//h2[@class=\"product-title\"]/a")
    WebElement itemResult;



    public void searchItem(String itemName){
        WebElement  searchBoxDisplayed= waitItemVisibility(searchItemTextBox);
        setTextElementText(searchBoxDisplayed, itemName);
        WebElement  searchItemButtonClickable= waitUntilItemIsClickable(searchItemButton);
        clickElement(searchItemButtonClickable);

    }

    public void openItemDetails(){
        WebElement  itemResultDisplayed= waitItemVisibility(itemResult);
        clickElement(itemResultDisplayed);
    }


    public void productSearchUsingAutoSuggest(String itemName) {
        WebElement searchBoxDisplayed = waitItemVisibility(searchItemTextBox);
        setTextElementText(searchBoxDisplayed, itemName);

        searchBoxDisplayed.sendKeys(" ");
        searchBoxDisplayed.sendKeys(Keys.UP);



        // Wait for the auto-suggest list to be visible
        WebDriverWait wait = new WebDriverWait(driver, timeout);

        wait.until(ExpectedConditions.visibilityOfAllElements(itemsSuggestionList));

    //    searchBoxDisplayed.sendKeys(Keys.UP);


        // Click on the first item in the auto-suggest list
        if (!itemsSuggestionList.isEmpty()) {
            WebElement firstSuggestion = itemsSuggestionList.get(0);
            clickElement(firstSuggestion);
        }

        else
            System.out.println("item list is empty");
    }

}
