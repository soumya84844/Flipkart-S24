package TestCase;

import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import org.testng.annotations.*;

public class TestCase_Edge {
	
	public WebDriver driver;
	
	public TestBase tb;
	
	public TestCase_Edge() throws Exception {
		
		tb = new TestBase();
		tb.testSetup();
		
	}
	
	@BeforeTest
	public void setup() throws Exception {
		
		if(TestBase.browsers[1].equalsIgnoreCase("None")) {
			
			throw new SkipException("Skipping Test - Browser not required");
			
		}
		
		driver = tb.driverSetup.getWebDriver(TestBase.browsers[1]);
		
		tb.testInit(driver);
		
	}
	
	@Test(priority = 0)
	public void test1() throws Exception {
		
		tb.test1_Search_By_Product_Name(driver);
		
	}
	
	@Test(priority = 1)
	public void test2() throws Exception {
		
		System.out.println("\n\nRunning in Edge........\n\n");
		tb.test2_Sort_Low_To_High_Price_And_Get_Product_With_Lowest_Price(driver);
		
	}
	
	@AfterTest
	public void endTest() {
		
		tb.closeBrowser(driver);
		
	}
	
}