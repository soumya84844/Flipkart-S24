package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductListPage extends BasePage {

	public ProductListPage(WebDriver driver) {
		
		super(driver);

	}
	
	@FindBy(xpath="//div[@class='_5THWM1']/div[3]")
	WebElement sortLowToHigh;
	
	@FindBy(xpath="//div[@class='_4rR01T']")
	List<WebElement> productTitles;
	
}
