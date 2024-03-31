package Setup;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsSetup implements ITestListener {
	
	public ExtentReports extent;
	public ExtentSparkReporter spark;
	public ExtentTest test;
	public ExcelUtils excelUtils;
	
	public String browser;
	public String imgPath;
	
	public void onStart(ITestContext context) {
		
		extent = new ExtentReports();
		spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/ExtentReports.html");
		excelUtils = new ExcelUtils();
		
		spark.config().setDocumentTitle("Automation Report");
		spark.config().setReportName("Automation Testing");
		spark.config().setTheme(Theme.DARK);
		
		extent.attachReporter(spark);
		
		try {
			
			browser = excelUtils.getExcelData("TestInputData", 1, 0);
			
		} 
		
		catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		extent.setSystemInfo("Computer Name", "Cognizant");
		extent.setSystemInfo("Environment", "Flipkart");
		extent.setSystemInfo("Tester Name", "Soumyadeep");
		extent.setSystemInfo("OS", "Windows 11");
		extent.setSystemInfo("Browser Name", browser);
		
		imgPath = System.getProperty("user.dir") + "/ScreenShots/";
		
	}
	
	public void onTestSuccess(ITestResult result) {
		
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test Case PASSED is : " + result.getName());
		
		try {
			
			test.addScreenCaptureFromPath(imgPath + result.getName() + ".png");
			
		}
		
		catch(Exception e) {}
		
	}
	
	public void onTestFailure(ITestResult result) {
		
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test Case FAILED is : " + result.getName());
		test.log(Status.FAIL, "Test Case FAILED because : " + result.getThrowable());
		
		try {
			
			test.addScreenCaptureFromPath(imgPath + result.getName() + ".png");
			
		}
		
		catch(Exception e) {}
		
	}
	
	public void onFinish(ITestContext context) {
		
		extent.flush();
		
	}
	
}
