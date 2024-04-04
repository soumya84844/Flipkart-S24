package TestCase;

import java.time.Duration;

import org.testng.SkipException;
import org.testng.annotations.*;

import Pages.*;
import Setup.*;

public class TestCase_001 extends TestBase {
	
	public String productName;
	
	public ScreenShot ss;
	
	public HomePage homePage;
	public ProductListPage productListPage;
	
	@BeforeTest
	@Parameters("index")
	public void setup(int index) throws Exception {
		
		super.testSetup();
		
		if(browsers[index].equalsIgnoreCase("None")) {
			
			throw new SkipException("Skipping Test - Browser not required");
			
		}
		
		driver = driverSetup.getWebDriver(browsers[index]);
		
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		ss = new ScreenShot(driver);
		
	}
	
	@Test(priority = 0)
	public void test1_Search_By_Product_Name() throws Exception {
		
		homePage = new HomePage(driver);
		
		productName = excelUtils.getExcelData("TestInputData", 1, 2);
		
		homePage.searchInput(productName);
		
		Thread.sleep(1000);
		
		ss.takeScreenShot("test1_Search_By_Product_Name");
		
		homePage.clickSearch();
		
	}
	
	@Test(priority = 1)
	public void test2_Sort_Low_To_High_Price_And_Get_Product_With_Lowest_Price() throws Exception {
		
		productListPage = new ProductListPage(driver);
		
		productListPage.getProducts(productName);
		
		ss.takeScreenShot("test2_Sort_Low_To_High_Price_And_Get_Product_With_Lowest_Price");
		
	}
	
	@AfterTest
	public void closeBrowser() {
		
		driver.quit();
		
	}

}
