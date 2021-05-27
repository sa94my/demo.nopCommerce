package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.UserRegisterationPage;

public class RegisterationTests extends TestBase{

	HomePage home;
	UserRegisterationPage registeration;
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
		registeration.RegisterMale("ahmad", "samy", "diang38@diang.com", "12345678");
		Assert.assertTrue(registeration.successfulRegisterationMsgText().contains("our registration completed"));
	}

	@Test(dependsOnMethods = {"registeruser"})
	public void registeredUserCanLogoutSuccessfully() {
		registeration = new UserRegisterationPage(driver);
		registeration.registeredUserLogout();
		Assert.assertTrue(home.userLoggedOutSuccessfully());
	}
}
