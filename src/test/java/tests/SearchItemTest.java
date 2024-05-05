package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ItemDetailsPage;
import pages.SearchPage;

public class SearchItemTest extends TestBase{

    SearchPage searchPage;
    ItemDetailsPage itemDetailsPage;
    String itemName= "Apple MacBook Pro 13-inch";


    @Test
    public void CheckSearchItem(){
        searchPage= new SearchPage(driver);
        itemDetailsPage = new ItemDetailsPage(driver);
        searchPage.searchItem(itemName);
        searchPage.openItemDetails();
        Assert.assertEquals(itemDetailsPage.itemDetails.getText(),itemName);

    }
}
