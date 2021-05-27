package data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class loadDataFromProperties {

	public static Properties properties = loadData(System.getProperty("user.dir")+"\\src\\main\\java\\properties\\registerData.properties");

	private static Properties loadData(String Path) {
		Properties pro = new Properties();

		try {
			FileInputStream input = new FileInputStream(Path);
			pro.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return pro;
	}
}
