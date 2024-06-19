package SeleniumRealtime.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extent_Report_TestNG {
	//making this method as static to avoid creating a object
	public static ExtentReports getReportObject() {
    
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Antony test Report");
		reporter.config().setDocumentTitle("Extent reports yopmail");
		ExtentReports report = new ExtentReports(); //main class- execution starts from here
		report.attachReporter(reporter);//reporter share all the meta data from ExtentSparkreporter
		report.setSystemInfo("SDET", "Antony");
		return report;

	}

}
