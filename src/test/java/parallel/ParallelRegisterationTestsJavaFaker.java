package parallel;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.UserRegisterationPage;

public class ParallelRegisterationTestsJavaFaker extends ParallelTestBase{

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
		 home = new HomePage(getDriver());		 
		home.openRegisterationPage();
		registeration = new UserRegisterationPage(getDriver());
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
		registeration = new UserRegisterationPage(getDriver());
		registeration.registeredUserLogout();
		Thread.sleep(2000);
		Assert.assertTrue(home.userLoggedOutSuccessfully());
		
		home.openLoginPage();
		Thread.sleep(2000);
		
	}
	
	@Test(dependsOnMethods = {"registeredUserCanLogoutSuccessfully"})
	public void testLogin() throws InterruptedException {
		login = new LoginPage(getDriver());
		login.login(email, password);
		Thread.sleep(2000);
		Assert.assertTrue(home.logoutBtnExists());
		home.userLogout();
	}
}
