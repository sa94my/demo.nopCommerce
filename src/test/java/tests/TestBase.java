package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utilities.Helper;

public class TestBase {

	static WebDriver driver;
	
	@BeforeSuite
	@Parameters({"browser"})
	public void setUp(@Optional("chrome") String browserName) {
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("chrome,headless")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless", "--disable-gpu",
					"--window-size=1920,1200","--ignore-certificate-errors");
			 driver = new ChromeDriver(options);
			
		}
		
		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		else if(browserName.equalsIgnoreCase("firefox,headless")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			options.setHeadless(true);
			 driver = new FirefoxDriver(options);
			
		}
		
		else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
	
		else if(browserName.equalsIgnoreCase("edge,headless")) {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\Drivers\\msedgedriver.exe");
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--headless", "--disable-gpu",
					"--window-size=1920,1200","--ignore-certificate-errors");
			 driver = new EdgeDriver(options);
			
		}
		
		driver.manage().window().maximize();
		driver.navigate().to("https://demo.nopcommerce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
	}
	
	
	@AfterMethod
	public void captureScreenOnFailure(ITestResult result) {
		if(result.getStatus()== ITestResult.FAILURE) {
			Helper.takeScreenshot(driver, result.getName());
		}
	}
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}
