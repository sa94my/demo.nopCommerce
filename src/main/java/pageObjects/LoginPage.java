package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "Email")
	WebElement emailField ;
	
	@FindBy(id = "Password")
	WebElement passwordField ;
	
	@FindBy(css = "button.button-1.login-button")
	WebElement loginBtn ;
	
	//@FindBy(linkText = "Log out")
	//WebElement logoutBtn ;
	
	public void login(String email,String password) {
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		loginBtn.click();
	}

	/*public boolean logoutBtnExists() {
		return logoutBtn.isDisplayed();
	}*/
}
