package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pageObjects.HomePage;
import pageObjects.UserRegisterationPage;

public class RegisterationTestsDdtFromExcel extends TestBase{

	HomePage home;
	UserRegisterationPage registeration;
	
	@DataProvider(name = "userData")
	public  Object[][] provideUserDataFromExcel() throws IOException {
		ExcelReader reader = new ExcelReader();
		return  reader.getData();
	}
	
	@Test(dataProvider = "userData")
	public void registeruser(String fname,String lname,String email, String password,String any)  {
		
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
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		home.userLogout();
		Assert.assertTrue(home.userLoggedOutSuccessfully());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
}
