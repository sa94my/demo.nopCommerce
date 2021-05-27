package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	FileInputStream excelStream=null;
	
	private FileInputStream getFileInputStream() {
		File excelFile = new File(System.getProperty("user.dir")+"\\src\\test\\java\\data\\Book.xlsx");
		
		try {
			excelStream = new FileInputStream(excelFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return excelStream ;
	}
	
	public Object[][] getData() throws IOException{
		excelStream = getFileInputStream();
		
			XSSFWorkbook workBook = new XSSFWorkbook(excelStream);
			XSSFSheet sheet = workBook.getSheetAt(1);
			int rowCount = sheet.getLastRowNum()+1;
			int columnCount = 5;
			String [][] data = new String[rowCount][columnCount];
			
			for(int rowNum = 0;rowNum<rowCount;rowNum++) {
				for (int columnNum = 0; columnNum < columnCount; columnNum++) {
					XSSFRow row = sheet.getRow(rowNum);
					data[rowNum][columnNum]=row.getCell(columnNum).toString();
					System.out.println(data[rowNum][columnNum]);
				}
			}
			excelStream.close();
			
		return data;
	}
}
