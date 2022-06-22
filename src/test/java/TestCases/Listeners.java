package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.Base;
import Resources.ExtentReoprtNG;

public class Listeners extends Base implements ITestListener {
	ExtentReports extent = ExtentReoprtNG.getReportObject();
	ExtentTest test;
	
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		 test = extent.createTest(result.getMethod().getMethodName());
		 extentTest.set(test);
		
	}

	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS,"Test passes");
		
	}

	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
		
		WebDriver driver= null;
		
		String TestMethodName=result.getMethod().getMethodName();
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		}catch(Exception e){
				
		}
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenshotFile(TestMethodName,driver), result.getMethod().getMethodName());
			
		}catch(Exception e) {
			
		}
		
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

}
