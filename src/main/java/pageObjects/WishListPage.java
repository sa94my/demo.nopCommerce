package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends PageBase{

	public WishListPage(WebDriver driver) {
		super(driver);
	}
	
	
	
	// a list of all products' SKU
	@FindBy(css = "td.sku")
	List<WebElement> productList;
	
	
	//same for all products
	//be careful when you have more than one item
	@FindBy(css = "button.remove-btn")
	WebElement removeProduct ;
	
	public void removeProductFromWishList() {
		removeProduct.click();
	}
	
	public boolean searchForProduct(String sku) {
		for(WebElement w : productList) {
			if(w.getText().equals(sku)) {
				System.out.println(w.getText());
				return true;
			}
		}
		return false;
	}
	
	
	public String getEmptyListString() {
		
		WebElement emptyListMsg =driver.findElement(By.cssSelector("div.no-data"));
		return emptyListMsg.getText();
	}
	
}
