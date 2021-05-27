package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="FullName")
	WebElement nameField ;
	
	@FindBy(id="Email")
	WebElement emailField ;
	
	@FindBy(id="Enquiry")
	WebElement enquiryField ;
	
	@FindBy(css="button.button-1.contact-us-button")
	WebElement submitEnquiryBtn ;
	
	@FindBy(css="div.result")
	WebElement enquiryResultMsg;
	
	public void contactUs(String name,String email,String enquiry) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		nameField.sendKeys(name);
		emailField.sendKeys(email);
		enquiryField.sendKeys(enquiry);
		submitEnquiryBtn.click();
	}
	public String getEnquiryMsg() {
		return enquiryResultMsg.getText();
	}
}
