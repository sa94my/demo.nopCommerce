package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.UserRegisterationPage;

public class RegisterationTestsDdtManual extends TestBase{

	HomePage home;
	UserRegisterationPage registeration;
	
	@DataProvider(name = "userData")
	public  Object[][] provideUserData() {
		return  new Object[][] {{"ahmad", "samy", "diang40@diang.com", "12345678"},{"ahmad", "samy", "diang410@diang.com", "12345678"}};
	}
	
	@Test(dataProvider = "userData")
	public void registeruser(String fname,String lname,String email, String password)  {
		 home = new HomePage(driver);
		home.openRegisterationPage();
		registeration = new UserRegisterationPage(driver);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		registeration.RegisterMale(fname,lname,email,password);
		Assert.assertTrue(registeration.successfulRegisterationMsgText().contains("our registration completed"));
		home.userLogout();
		Assert.assertTrue(home.userLoggedOutSuccessfully());
	}

	
}
