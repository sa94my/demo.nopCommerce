package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.loadDataFromProperties;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.UserRegisterationPage;

public class RegisterationTestsDdtProperties extends TestBase{

	HomePage home;
	UserRegisterationPage registeration;
	LoginPage login;
	String firstName = loadDataFromProperties.properties.getProperty("firstName");
	String lastName = loadDataFromProperties.properties.getProperty("lastName");
	String email = loadDataFromProperties.properties.getProperty("email");
	String password = loadDataFromProperties.properties.getProperty("password");


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
		registeration.RegisterMale(firstName,lastName,email,password);
		Assert.assertTrue(registeration.successfulRegisterationMsgText().contains("our registration completed"));
	}

	@Test(dependsOnMethods = {"registeruser"})
	public void registeredUserCanLogoutSuccessfully() {
		
		home.userLogout();
		Assert.assertTrue(home.userLoggedOutSuccessfully());
	}
	
	@Test(dependsOnMethods = {"registeredUserCanLogoutSuccessfully"})
	public void testLogin() {
		
		home.openLoginPage();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		login = new LoginPage(driver);
		login.login(email, password);
		Assert.assertTrue(home.logoutBtnExists());
		home.userLogout();
	}
}
