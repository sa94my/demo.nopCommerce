package tests;

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
public class EmailToFriendTest extends TestBase{
	
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
		 homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		registeration = new UserRegisterationPage(driver);
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
		homeObject = new HomePage(driver);
		homeObject.searchForProduct(searchKeyword);
		searchResultsObject = new SearchResultsPage(driver);
		searchResultsObject.visitDetailsPageOfProductAlternative();

		productDetailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(productDetailsObject.getCurrentItemName().toLowerCase().contains(searchKeyword));
	}
	
	@Test(priority = 2)
	public void emailToFriendTest() {
		productDetailsObject = new ProductDetailsPage(driver);
		productDetailsObject.goToEmailFriendPage();
		
		emailToFriendObject = new EmailToFriendPage(driver);
		emailToFriendObject.emailProductToFriend(friendEmail, msg);
		
		Assert.assertEquals(emailToFriendObject.getSendingResult(), "Your message has been sent.");
		homeObject.userLogout();
	}
	
}
