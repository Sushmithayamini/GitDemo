package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReoprtNG {
	
	public static ExtentSparkReporter reporter;
	public static ExtentReports extent;
	
	public static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir")+"\\Report\\index.html";
		reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("WebAutomation");
		reporter.config().setDocumentTitle("Test Report");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Sushmitha");
		return extent;
	}

}
