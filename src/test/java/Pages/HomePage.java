package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		
		super(driver);
		
	}
	
	@FindBy(xpath="//input[@class='Pke_EE']")
	public WebElement searchBox;
	
	@FindBy(xpath="//ul[@class='_1sFryS _2x2Mmc _3ofZy1']/li[2]")
	public WebElement searchItem;
	
	public void searchInput(String productName) {
		
		searchBox.sendKeys(productName);
		
	}
	
	public void clickSearch() {
		
		searchItem.click();
		
	}
	
}
