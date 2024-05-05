package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase{

    HomePage homePage;
    ContactUsPage contactUsPage;
    String fullName = "Amira Bahaa Maher";
    String email = "mira32@yahoo.com";

    String enquery= "my automatic search isn't working";
    String message = "Your enquiry has been successfully sent to the store owner.";

    @Test
    public void userCanUseContacttUs(){
        homePage= new HomePage(driver);
        homePage.openContactUsPage();
        contactUsPage= new ContactUsPage(driver);
        contactUsPage.fillContactUsInformation(fullName, email, enquery);
        Assert.assertEquals(contactUsPage.contactUsSubmittedMessage.getText(),message);
    }
}
