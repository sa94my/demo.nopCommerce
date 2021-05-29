package parallel;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ContactUsPage;
import pageObjects.HomePage;

public class ParallelContactUsTest extends ParallelTestBase{

	HomePage homeObject ;
	ContactUsPage contactUsObject ;
	
	@Test
	public void contactUsTest() {
		homeObject = new HomePage(getDriver());
		homeObject.openContactUsPage();
		contactUsObject = new ContactUsPage(getDriver());
		contactUsObject.contactUs("ali", "ali@ali.com", "text");
		Assert.assertTrue(contactUsObject.getEnquiryMsg().contains("Your enquiry has been successfully sent"));
	}
}
