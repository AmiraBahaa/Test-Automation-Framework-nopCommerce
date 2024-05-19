package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase  {

    protected WebDriver driver;
    JavascriptExecutor js;
    protected Select select;


    public PageBase (WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    Duration timeout= Duration.ofSeconds(20);
    protected static void setTextElementText(WebElement element, String value){

        element.sendKeys(value);
    }
    protected static void clickElement(WebElement element){

//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        WebElement emailTextBoxReady= wait.until(ExpectedConditions.visibilityOf(emailTextBox));
//
        element.click();
    }
    protected WebElement waitItemVisibility(WebElement element){
        WebDriverWait wait= new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOf(element));

    }

    protected WebElement waitUntilItemIsClickable(WebElement element){
        WebDriverWait wait= new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    protected Boolean waitItemTextChanged(WebElement element, String partialText){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.textToBePresentInElement(element, partialText));
    }


    protected void scrollToBottom(){
        js.executeScript("scrollBy(0,2500)");
    }

}
