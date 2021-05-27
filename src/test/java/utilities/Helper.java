package utilities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class Helper {

	public static void takeScreenshot(WebDriver driver , String screenshotName) {
		Path dest = Paths.get(".\\screenshots",screenshotName+".png");
		try {
			FileOutputStream out = new FileOutputStream(dest.toString());
			out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
