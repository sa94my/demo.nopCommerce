package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegisterationPage extends PageBase {

	public UserRegisterationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "gender-male")
	WebElement maleRadioBtn ;
	
	
	@FindBy(id = "gender-female")
	WebElement femaleRadioBtn ;
	
	@FindBy(id = "FirstName")
	WebElement firstNameField ;
	
	@FindBy (id = "LastName")
	WebElement lastNameField ;
	
	@FindBy(id = "Email")
	WebElement emailField ;
	
	@FindBy (id = "Password" )
	WebElement passwordField ;
	
	@FindBy (id = "ConfirmPassword")
	WebElement confirmPasswordField ;
	
	@FindBy (id = "register-button")
	WebElement registerBtn ;
		
	@FindBy(css = "div.result")
	WebElement registerationResult ;
	
	@FindBy(linkText = "Log out")
	WebElement logoutBtn ;
	
	@FindBy(linkText = "Log in")
	WebElement loginBtn ;
	
	
	public void RegisterMale(String firstName,String lastName, String email,String password)  {
		maleRadioBtn.click();
		firstNameField.sendKeys(firstName);
		lastNameField.sendKeys(lastName);
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		confirmPasswordField.sendKeys(password);
		registerBtn.click();
	}
	
	public String successfulRegisterationMsgText() {
		return registerationResult.getText();
	}
	
	public void registeredUserLogout() {
		logoutBtn.click();
	}
	
	
	
	

	
}
