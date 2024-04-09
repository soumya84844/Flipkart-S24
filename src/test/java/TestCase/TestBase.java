package TestCase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import Pages.HomePage;
import Pages.ProductListPage;
import Setup.DriverSetup;
import Setup.ExcelUtils;
import Setup.ScreenShot;

public class TestBase {
	
	public DriverSetup driverSetup;
	public ExcelUtils excelUtils;
	
	public static String[] browsers;
	
	public String productName;
	
	public ScreenShot ss;
	
	public HomePage homePage;
	public ProductListPage productListPage;
	
	public TestBase() {
		
		excelUtils = new ExcelUtils();
		driverSetup = new DriverSetup();
		
		browsers = new String[2];
		
	}
	
	public void testSetup() throws Exception {
		
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
	
	public void testInit(WebDriver driver) {
		
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		ss = new ScreenShot(driver);
		
	}
	
	public void test1_Search_By_Product_Name(WebDriver driver) throws Exception {
		
		homePage = new HomePage(driver);
		
		productName = excelUtils.getExcelData("TestInputData", 1, 2);
		
		homePage.searchInput(productName);
		
		Thread.sleep(1000);
		
//		ss.takeScreenShot("test1_Search_By_Product_Name");
		
		homePage.clickSearch();
		
	}
	
	public void test2_Sort_Low_To_High_Price_And_Get_Product_With_Lowest_Price(WebDriver driver) throws Exception {
		
		productListPage = new ProductListPage(driver);
		
		productListPage.getProducts(productName);
		
//		ss.takeScreenShot("test2_Sort_Low_To_High_Price_And_Get_Product_With_Lowest_Price");
		
	}
	
	public void closeBrowser(WebDriver driver) {
		
		driver.quit();
		
	}

}
