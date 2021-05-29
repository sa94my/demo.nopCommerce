package parallel;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class ParallelTestBase {

	public static String basaeUrl = "https://demo.nopcommerce.com/" ;
	protected ThreadLocal<RemoteWebDriver> driver ;
	
	@Parameters(value = {"browser"})
	@BeforeClass
	public void setup(String browser) throws MalformedURLException {
		driver = new ThreadLocal<>();
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName(browser);
		driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps));
		getDriver().get(basaeUrl);
	}
	
	public WebDriver getDriver() {
		return driver.get();
	}
	
	
	@AfterClass
	public void tearDown() {
		getDriver().quit();
		driver.remove();
	}
}
