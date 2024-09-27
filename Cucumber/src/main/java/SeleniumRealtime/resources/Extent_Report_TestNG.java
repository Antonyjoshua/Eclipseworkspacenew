package SeleniumRealtime.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

//Extent Reports is an open-source reporting library for Selenium WebDriver that provides detailed and visually appealing test reports. It integrates with various testing frameworks such as TestNG, JUnit, and others, and offers a range of features including logging, screenshots, and customization of the report output.
public class Extent_Report_TestNG {
	// making this method as static to avoid creating a object
	public static ExtentReports getReportObject() {

		String path = System.getProperty("user.dir") + "\\reports\\index.html";// path where the report will be saved.
		//Used to configure the report's output path, report name, and document title.
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);// A class provided by Extent Reports to generate
																		// reports in the Spark format (HTML).
		reporter.config().setReportName("Antony test Report");// Sets the name of the report, which will be displayed on
																// the report's main page.
		reporter.config().setDocumentTitle("Extent reports yopmail");// Sets the title of the HTML document that will be
																		// generated.
		//Main class used for creating and managing the test report.
		ExtentReports report = new ExtentReports(); // The main class used for generating the report. It handles adding
													// tests, logging, and generating the final report.
		report.attachReporter(reporter);// Attaches the ExtentSparkReporter to the ExtentReports instance. This allows
										// ExtentReports to use the configuration and output settings defined in the
										// ExtentSparkReporter.
		report.setSystemInfo("SDET", "Antony");// Adds system information to the report. This information will be
												// displayed in the report, providing additional context about the test
												// environment or the tester.
		return report;

	}

}
