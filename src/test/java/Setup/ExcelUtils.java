package Setup;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	FileInputStream file;
	
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	
	String data;
	
	public String getExcelData(String sheetName, int r, int c) throws Exception {
		
		file = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\data.xlsx");
		
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(r);
		cell = row.getCell(c);
		
		data = cell.getStringCellValue();
		
		return data;
		
	}
	
}
