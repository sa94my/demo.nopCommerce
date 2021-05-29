package parallel;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pageObjects.EmailToFriendPage;
import pageObjects.HomePage;
import pageObjects.ProductDetailsPage;
import pageObjects.SearchResultsPage;
import pageObjects.UserRegisterationPage;

/**
 * @author ahmad
 *
 */
public class ParallelEmailToFriendTest extends ParallelTestBase{
	
	HomePage homeObject;
	UserRegisterationPage registeration;
	String searchKeyword = "shirt";
	String friendEmail = "ali@ali.com";
	String msg = "check out this product";
	SearchResultsPage searchResultsObject ;
	ProductDetailsPage productDetailsObject;
	EmailToFriendPage emailToFriendObject ;
	Faker faker = new Faker();
	String firstName = faker.name().firstName();
	String lastName = faker.name().lastName();
	String email = faker.internet().emailAddress();
	String password = faker.number().digits(8);
	@Test(priority = 0)
	public void registeruser()  {
		 homeObject = new HomePage(getDriver());
		homeObject.openRegisterationPage();
		registeration = new UserRegisterationPage(getDriver());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		registeration.RegisterMale(firstName, lastName, email, password);
		Assert.assertTrue(registeration.successfulRegisterationMsgText().contains("our registration completed"));
	}

	@Test(priority = 1)
	public void searchForProduct() {
		homeObject = new HomePage(getDriver());
		homeObject.searchForProduct(searchKeyword);
		searchResultsObject = new SearchResultsPage(getDriver());
		searchResultsObject.visitDetailsPageOfProductAlternative();

		productDetailsObject = new ProductDetailsPage(getDriver());
		Assert.assertTrue(productDetailsObject.getCurrentItemName().toLowerCase().contains(searchKeyword));
	}
	
	@Test(priority = 2)
	public void emailToFriendTest() {
		productDetailsObject = new ProductDetailsPage(getDriver());
		productDetailsObject.goToEmailFriendPage();
		
		emailToFriendObject = new EmailToFriendPage(getDriver());
		emailToFriendObject.emailProductToFriend(friendEmail, msg);
		
		Assert.assertEquals(emailToFriendObject.getSendingResult(), "Your message has been sent.");
		homeObject.userLogout();
	}
	
}
