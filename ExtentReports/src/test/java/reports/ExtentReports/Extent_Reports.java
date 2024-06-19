package reports.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

//Extentreports is a popular reporting library for Selenium WebDriver tests in Java. It provides beautiful, interactive, and detailed test reports. The ExtentSparkReporter is part of the Extentreports library and is used to configure and generate reports in the Spark format, which is one of the output formats Extentreports supports.
public class Extent_Reports {
	// ExtentReports are used to create a report which contains the information of
	// the executed test case
	// extentreport dependency is needed to take extent report
	// Extentreports and Extentsparkreporter classes are needed to generate extent
	// report
	public ExtentReports report; // making this as an instant variable so that it can be accessed in any method

	@BeforeTest
	public void config_ER() {
		// helper class
		// System.getProperty("user.dir")-project path dynamically
		// "\\reports\\index.html"- create a new folder called reports in our project
		// and it stores the report
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		// this class expect a path where the generated report should be stored
		// Extentsparkreporter class responsible to create a HTML file and do
		// configuration in that
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		// to set the report name
		reporter.config().setReportName("Antony test Report");
		// to set the document title which is page title
		reporter.config().setDocumentTitle("Extent reports yopmail");
		// main class- Extent reports responsible to drive all our reporting execution.
		// This will watch the test method execution
		report = new ExtentReports();
		// Attach the report to this class
		report.attachReporter(reporter);
		// to set tester name
		report.setSystemInfo("SDET", "Antony");
	}
	// mark a test as failed using assertions or by manually logging the failure
	// condition in your test script.

	@Test
	public void reportsDemo() {
		// we have to use the extentreport object "report" in our test method to create
		// extent report for the test method
		// createtest will create a test in report with this name and have this test
		// method result
		// When we use createTest, object is automatically created for the complete test
		// method which is unique for that test method alone. We need to take return
		// type and use that object to explicitly fail a method
		// createTest object is responsible to listen and report all the happening back
		// to
		// the extent report
		ExtentTest createTest = report.createTest("Extent report demo");
		WebDriver driver = new ChromeDriver();
		driver.get("https://yopmail.com/en/wm");
		String title = driver.getTitle();
		System.out.println(title);
		// use that object to explicitly fail a method, add screenshot and lot of
		// other methods
		// mark a test as failed using assertions or by manually logging the failure
		// condition in your test script.
		createTest.fail("Intentionaly failing this test case");
		// flush method is mandatory at the end of the test. This will stop watching
		// this method which means the method gets executed completely. If we have 5
		// test method, we have to write it at the end of 5 test case and the report
		// contains 5 test method data
		report.flush();

	}

}
