package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.UserRegisterationPage;

public class RegisterationTestsJavaFaker extends TestBase{

	HomePage home;
	UserRegisterationPage registeration;
	LoginPage login ;
	 Faker fake =new Faker();
		String firstName = fake.name().firstName();
		String lastName = fake.name().lastName();
		String email = fake.internet().emailAddress();
		String password = fake.number().digits(8);
	@Test
	public void registeruser()  {
		 home = new HomePage(driver);		 
		home.openRegisterationPage();
		registeration = new UserRegisterationPage(driver);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		registeration.RegisterMale(firstName, lastName, email, password);
		Assert.assertTrue(registeration.successfulRegisterationMsgText().contains("our registration completed"));
	}

	@Test(dependsOnMethods = {"registeruser"})
	public void registeredUserCanLogoutSuccessfully() throws InterruptedException {
		registeration = new UserRegisterationPage(driver);
		registeration.registeredUserLogout();
		Thread.sleep(2000);
		Assert.assertTrue(home.userLoggedOutSuccessfully());
		
		home.openLoginPage();
		Thread.sleep(2000);
		
	}
	
	@Test(dependsOnMethods = {"registeredUserCanLogoutSuccessfully"})
	public void testLogin() throws InterruptedException {
		login = new LoginPage(driver);
		login.login(email, password);
		Thread.sleep(2000);
		Assert.assertTrue(home.logoutBtnExists());
		home.userLogout();
	}
}
