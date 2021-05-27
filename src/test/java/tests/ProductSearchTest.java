package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductDetailsPage;
import pageObjects.SearchResultsPage;

public class ProductSearchTest extends TestBase{
	
	HomePage homeObject ;
	SearchResultsPage searchResultsObject ;
	ProductDetailsPage productDetailsObject;
	String searchKeyword = "shirt";
	
	@Test
	public void searchForProduct() {
		homeObject = new HomePage(driver);
		homeObject.searchForProduct(searchKeyword);
		searchResultsObject = new SearchResultsPage(driver);
		//searchResultsObject.visitDetailsPageOfProduct("Nike Tailwind Loose ");
		searchResultsObject.visitDetailsPageOfProductAlternative();

		productDetailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(productDetailsObject.getCurrentItemName().toLowerCase().contains(searchKeyword));
	}

}
