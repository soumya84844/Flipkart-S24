package TestCase;

import org.openqa.selenium.WebDriver;

import Setup.DriverSetup;
import Setup.ExcelUtils;

public class TestBase {
	
	public WebDriver driver;
	
	public DriverSetup driverSetup;
	public ExcelUtils excelUtils;
	
	public String[] browsers;
	
	public void testSetup() throws Exception {
		
		excelUtils = new ExcelUtils();
		driverSetup = new DriverSetup();
		
		browsers = new String[2];
		
		for(int i = 0; i < 2; i++) {
			
			String choice = excelUtils.getExcelData("TestInputData", 1, i);
			
			if(choice.equalsIgnoreCase("Y")) {
				
				browsers[i] = excelUtils.getExcelData("TestInputData", 0, i);
				
			}
			
			else {
				
				browsers[i] = "None";
				
			}
			
		}
		
	}

}
