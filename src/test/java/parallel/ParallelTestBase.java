package parallel;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
	/*	Uncomment to make it work on docker
	 * 
	 * if(browser.equalsIgnoreCase("chrome")) {
			
			ChromeOptions options = new ChromeOptions();
			//https://stackoverflow.com/questions/50642308/webdriverexception-unknown-error-devtoolsactiveport-file-doesnt-exist-while-t
			options.addArguments("start-maximized");
			options.addArguments("--disable-dev-shm-usage");
			caps.setCapability(ChromeOptions.CAPABILITY, options);
		}*/
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
