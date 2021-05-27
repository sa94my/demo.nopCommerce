package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ContactUsPage;
import pageObjects.HomePage;

public class ContactUsTest extends TestBase{

	HomePage homeObject ;
	ContactUsPage contactUsObject ;
	
	@Test
	public void contactUsTest() {
		homeObject = new HomePage(driver);
		homeObject.openContactUsPage();
		contactUsObject = new ContactUsPage(driver);
		contactUsObject.contactUs("ali", "ali@ali.com", "text");
		Assert.assertTrue(contactUsObject.getEnquiryMsg().contains("Your enquiry has been successfully sent"));
	}
}
