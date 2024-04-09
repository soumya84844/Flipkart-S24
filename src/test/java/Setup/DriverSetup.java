package Setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverSetup {
	
	WebDriver driver;
	
	public WebDriver getWebDriver(String browser) {
		
		ChromeOptions op1 = new ChromeOptions();
		EdgeOptions op2 = new EdgeOptions();
		
		op1.addArguments("--headless");
		op2.addArguments("--headless");
		
		if(browser.equalsIgnoreCase("chrome")) driver = new ChromeDriver(op1);
		else if(browser.equalsIgnoreCase("edge")) driver = new EdgeDriver(op2);
		
		return driver;
		
	}
	
}
