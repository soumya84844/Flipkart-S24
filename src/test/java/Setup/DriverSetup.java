package Setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverSetup {
	
	WebDriver driver;
	
	public WebDriver getWebDriver(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) driver = new ChromeDriver();
		else if(browser.equalsIgnoreCase("edge")) driver = new EdgeDriver();
		
		return driver;
		
	}
	
}
