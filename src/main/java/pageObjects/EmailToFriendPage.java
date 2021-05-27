package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailToFriendPage extends PageBase{

	public EmailToFriendPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "FriendEmail")
	WebElement friendEmailField ;
	
	@FindBy(id = "PersonalMessage")
	WebElement personalMsgField ;
	
	@FindBy(css = "button.button-1.send-email-a-friend-button")
	WebElement sendEmailBtn ;
	
	
	
	
	public void emailProductToFriend(String friendMail,String personalMsg) {
		friendEmailField.sendKeys(friendMail);
		personalMsgField.sendKeys(personalMsg);
		sendEmailBtn.click();
	}
	
	public String getSendingResult() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div.result")));
		return driver.findElement(By.cssSelector("div.result")).getText();
	}
}
