package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;

public class LoginTest extends TestBase{


@Test
public void testLogin() {
	HomePage home = new HomePage(driver);
	home.openLoginPage();
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	LoginPage login = new LoginPage(driver);
	login.login("diang32@diang.com", "12345678");
	Assert.assertTrue(home.logoutBtnExists());
	home.userLogout();
}

}