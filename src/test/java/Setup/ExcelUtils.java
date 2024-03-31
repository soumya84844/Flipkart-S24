package Setup;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	FileInputStream fileInput;
	FileOutputStream fileOutput;
	
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	
	String data;
	
	public String getExcelData(String sheetName, int r, int c) throws Exception {
		
		fileInput = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\data.xlsx");
		
		workbook = new XSSFWorkbook(fileInput);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(r);
		cell = row.getCell(c);
		
		data = cell.getStringCellValue();
		
		workbook.close();
		fileInput.close();
		
		return data;
		
	}
	
	public void writeExcelData(String data[], String sheetName, int r, int c) throws Exception {
		
		fileInput = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\data.xlsx");
		
		workbook = new XSSFWorkbook(fileInput);
		
		sheet = workbook.getSheet(sheetName);
		
		XSSFRow rowInit =  sheet.createRow(0);
		rowInit.createCell(0).setCellValue("Product Name");
		rowInit.createCell(1).setCellValue("Product Price");
		
		row = sheet.createRow(r);
		row.createCell(c).setCellValue(data[c]);
		row.createCell(c + 1).setCellValue(data[c + 1]);
		
		fileOutput = new FileOutputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\data.xlsx");
		workbook.write(fileOutput);
		
		workbook.close();
		fileInput.close();
		fileOutput.close();
		
	}
	
}
