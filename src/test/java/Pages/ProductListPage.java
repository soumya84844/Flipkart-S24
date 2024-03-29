package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductListPage extends BasePage {

	public ProductListPage(WebDriver driver) {
		
		super(driver);

	}
	
	@FindBy(xpath="//div[@class='_5THWM1']/div[3]")
	public WebElement sortLowToHigh;
	
	@FindBy(xpath="//div[@class='_4rR01T']")
	public List<WebElement> productTitles;
	
	@FindBy(xpath="//div[@class='_30jeq3 _1_WHN1']")
	public List<WebElement> productPrices;
	
	public void sortPrice() {
		
		sortLowToHigh.click();
		
	}
	
	public void getLowestPrice(String productName) {
		
		productTitles = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		productPrices = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
		
		int pos = -1, n = productTitles.size();
		
		for(int i = 0; i < n; i++) {	
			
			if(productTitles.get(i).getText().toLowerCase().contains(productName.toLowerCase())) {
				
				pos = i;
				
				break;
				
			}
			
		}
		
		if(pos == -1) System.out.println("Required Product " + productName + " Not Found !!!");
		
		else {
			
			System.out.println("Lowest Price of " + productTitles.get(pos).getText() + " = " + productPrices.get(pos).getText());
			
		}
		
	}
	
}
