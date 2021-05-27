package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageBase {

	protected WebDriver driver;
	public JavascriptExecutor js ;

	public PageBase(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public  void scrollToBottom() {
		js.executeScript( "scrollBy(0,2500)");
	}
	
}
