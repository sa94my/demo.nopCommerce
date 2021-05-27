package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends PageBase{

	public SearchResultsPage(WebDriver driver) {
		super(driver);
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FindBy(css = "div.product-item")
	WebElement productWindow ;
	
	//product specific method
	public void visitDetailsPageOfProduct(String keyword) {
		 WebElement productDetailsLink = productWindow.findElement(By.partialLinkText(keyword));
		productDetailsLink.click();
	}
	
	//an attempt to make the method more generic
	public void visitDetailsPageOfProductAlternative() {
		
		 WebElement productDetailsLink = productWindow.findElement(By.tagName("img"));
		productDetailsLink.click();
	}
}
