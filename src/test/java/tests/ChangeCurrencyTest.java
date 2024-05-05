package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ItemDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase{

    HomePage homePage;
    ItemDetailsPage itemDetailsPage;
    SearchPage searchPage;
    String itemName= "Apple MacBook Pro 13-inch";

    @Test(priority = 1)
    public void userCanChangeCurrency(){
        homePage= new HomePage(driver);
        itemDetailsPage= new ItemDetailsPage(driver);
        homePage.changeCurrency();
    }




    @Test(priority = 2)
    public void CheckSearchItem(){
        searchPage= new SearchPage(driver);
        itemDetailsPage = new ItemDetailsPage(driver);
        searchPage.searchItem(itemName);
        searchPage.openItemDetails();
        Assert.assertEquals(itemDetailsPage.itemDetails.getText(),itemName);
        Assert.assertTrue(itemDetailsPage.priceValue.getText().contains("€"));


    }


}
