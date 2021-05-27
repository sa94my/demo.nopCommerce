package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor)driver;
	}

	@FindBy(linkText = "Register")
	WebElement registerBtn ;
	
	@FindBy(linkText = "Log in")
	WebElement loginBtn ;
	
	@FindBy(linkText = "Log out")
	WebElement logoutBtn ;
	
	@FindBy(id = "small-searchterms")
	WebElement searchTextBox;
	
	@FindBy(css = "button.button-1.search-box-button")
	WebElement searchBtn;
	
	@FindBy(linkText = "Contact us")
	WebElement contactUsBtn ;
	
	@FindBy(partialLinkText = "Wishlist")
	WebElement wishListBtn ;
	
	public void openRegisterationPage() {
		registerBtn.click();
	}
	
	public void openLoginPage() {
		loginBtn.click();
	}
	
	public boolean logoutBtnExists() {
		return logoutBtn.isDisplayed();
	}
	
	public void openWishListPage() {
		wishListBtn.click();
	}
	
	public void searchForProduct(String productName) {
		searchTextBox.sendKeys(productName);
		searchBtn.click();
		
	}
	public void openContactUsPage() {
		scrollToBottom();
		contactUsBtn.click();
	}
	public void userLogout() {
		logoutBtn.click();
	}
	public boolean userLoggedOutSuccessfully() {
		return loginBtn.isDisplayed();
	}
}
