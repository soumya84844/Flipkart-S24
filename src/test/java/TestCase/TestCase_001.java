package TestCase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import Pages.*;
import Setup.*;

public class TestCase_001 {
	
	public WebDriver driver;
	public String browser;
	public String productName;
	
	public DriverSetup driverSetup;
	public ExcelUtils excelUtils;
	
	public HomePage homePage;
	public ProductListPage productListPage;
	
	@BeforeTest
	public void setup() throws Exception {
		
		excelUtils = new ExcelUtils();
		driverSetup = new DriverSetup();
		
		browser = excelUtils.getExcelData("TestInputData", 1, 0);
		
		driver = driverSetup.getWebDriver(browser);
		
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	
	@Test(priority = 0)
	public void test1() throws Exception {
		
		homePage = new HomePage(driver);
		
		productName = excelUtils.getExcelData("TestInputData", 1, 1);
		
		homePage.searchInput(productName);
		
		Thread.sleep(1000);
		
		homePage.clickSearch();
		
	}
	
	@Test(priority = 1)
	public void test2() throws Exception {
		
		productListPage = new ProductListPage(driver);
		
		productListPage.sortPrice();
		
		Thread.sleep(1000);
		
		productListPage.getLowestPrice(productName);
		
	}
	
	@AfterTest
	public void closeBrowser() {
		
		driver.quit();
		
	}

}
