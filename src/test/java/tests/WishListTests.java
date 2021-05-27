package tests;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductDetailsPage;
import pageObjects.SearchResultsPage;
import pageObjects.WishListPage;

public class WishListTests extends TestBase{

	HomePage homeObject;
	String searchKeyword = "android";
	SearchResultsPage searchResultsObject ;
	ProductDetailsPage productDetailsObject;
	WishListPage wishListObject ;
	String sku ;

	@Test(priority = 1)
	public void searchForProductAndSetSku() {
		homeObject = new HomePage(driver);
		homeObject.searchForProduct(searchKeyword);
		searchResultsObject = new SearchResultsPage(driver);
		searchResultsObject.visitDetailsPageOfProductAlternative();

		productDetailsObject = new ProductDetailsPage(driver);
		sku = productDetailsObject.getProductSku();
		System.out.println(sku);
		Assert.assertTrue(productDetailsObject.getCurrentItemName().toLowerCase().contains(searchKeyword));
	}

	@Test(priority = 2)
	public void addToWishListTest() {
		productDetailsObject.addProductToWishList();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		WebElement successMsg = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.bar-notification.success")));
		System.out.println(successMsg.getText());
		assertTrue(successMsg.getText().contains("The product has been added to your "));
		//close the msg
		successMsg.findElement(By.cssSelector("span.close")).click();
		try {
			Thread.sleep(2000);

		} catch (Exception sle) {

		}

	}

	@Test(priority = 3)
	public void productIsInWishListPage() {
		homeObject = new HomePage(driver);
		homeObject.openWishListPage();
		wishListObject = new WishListPage(driver);
		assertTrue(wishListObject.searchForProduct(sku));
	}

	@Test(priority = 4)
	public void deleteProductTest() {
		wishListObject.removeProductFromWishList();
		try {
			Thread.sleep(2000);

		} catch (Exception sle) {

		}
		assertTrue(wishListObject.getEmptyListString().contains("wishlist is empty"));
	}


}
