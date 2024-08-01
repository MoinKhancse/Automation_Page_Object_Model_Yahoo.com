package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentFactory extends CommonMethods {
	public static final ExtentReports extentReports = new ExtentReports();
	
	public synchronized static ExtentReports getInstance() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("./Reports/report.html");
		reporter.config().setReportName("Automation Yahoo Page");
		extentReports.attachReporter(reporter);
		return extentReports;		
	}
}
