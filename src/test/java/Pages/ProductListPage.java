package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Setup.ExcelUtils;

public class ProductListPage extends BasePage {
	
	ExcelUtils excelUtils;
	
	String data[];
	
	@FindBy(xpath="//div[@class='_5THWM1']/div[3]")
	public WebElement sortLowToHigh;
	
	@FindBy(xpath="//div[@class='_4rR01T']")
	public List<WebElement> productTitles;
	
	@FindBy(xpath="//div[@class='_30jeq3 _1_WHN1']")
	public List<WebElement> productPrices;
	
	public ProductListPage(WebDriver driver) {
		
		super(driver);
		
		excelUtils = new ExcelUtils();
		
		data = new String[2];

	}
	
	public void getProducts(String productName) throws Exception {
		
		productTitles = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		productPrices = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
		
		int n = productTitles.size();
		
		for(int i = 0; i < n; i++) {
			
			String name = productTitles.get(i).getText();
			String price = productPrices.get(i).getText();
			
			if(!name.toLowerCase().contains(productName.toLowerCase())) continue;
			
			data[0] = name;
			data[1] = price;
			
//			excelUtils.writeExcelData(data, "TestOutputData", i + 1, 0);
			
			System.out.println(name + " : " + price);
			
		}
		
	}
	
}
