package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(css="strong.current-item")
	WebElement currentItem ;
	
	@FindBy(css="button.button-2.email-a-friend-button")
	WebElement emailProductToFriendBtn ;
	
	@FindBy(css="button.button-2.add-to-wishlist-button")
	WebElement addToWishListBtn ;
	
	@FindBy(css = "div.sku")
	WebElement productSku;
	
	public String getCurrentItemName() {
		return currentItem.getText();
	}
	
	public void goToEmailFriendPage() {
		emailProductToFriendBtn.click();
	}
	
	public void addProductToWishList() {
		addToWishListBtn.click();
	}
	
	public String getProductSku() {
		return productSku.findElement(By.cssSelector("span.value")).getText();
	}
}
