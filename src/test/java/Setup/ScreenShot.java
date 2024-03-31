package Setup;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	
	WebDriver driver;
	
	TakesScreenshot ts;
	
	File src, trg;
	
	String path;
	
	public ScreenShot(WebDriver driver) {
		
		this.driver = driver;
		
		ts = (TakesScreenshot) driver;
		path = System.getProperty("user.dir") + "/ScreenShots/";
		
	}
	
	public String takeScreenShot(String fileName) throws Exception {
		
		path += fileName + ".png";
		
		src = ts.getScreenshotAs(OutputType.FILE);
		trg = new File(path);
		
		FileUtils.copyFile(src, trg);
		
		return path;
		
	}

}
