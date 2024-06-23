package SeleniumRealtime.Testcomponents;

import java.io.IOException;
import java.lang.reflect.Field;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import SeleniumRealtime.resources.Extent_Report_TestNG;

public class Listensers extends BaseTest implements ITestListener {
	// classname.methodname to call the static method without creating object
	// calling getReportObject() here to access the extent reports
	ExtentReports report = Extent_Report_TestNG.getReportObject(); // Use the class name to call static methods in your
																	// test or page classes.
	ExtentTest test;
	
	ThreadLocal<ExtentTest> extenttest= new ThreadLocal<ExtentTest>();
	@Override
	// Writing create test here since it's object is mandatory to get the data from
	// the test method, so
	// before running any test this block will gets executed
	public void onTestStart(ITestResult result) {
		// onTestStart- Invoked each time before a test will be invoked
		// this will get the methodname of the testmethod before executing them
		// result holds all the data related to the test case
		// ExtentTest createTest = report.createTest("Extent report demo");
		// createTest: This is a method of the ExtentReports class used to create a new
		// test in the report.
	     test = report.createTest(result.getMethod().getMethodName());
	     extenttest.set(test);
		// the test variable holds a reference to the ExtentTest instance. This instance
		// can be used to log various details about the test, such as steps, status
		// updates, screenshots, and other relevant information.
	}

	// result variable contains all the data about the test method, by using this
	// object we can perform various actions
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//test.log(Status.PASS, "Test Passed");
		extenttest.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		// test.log(Status.FAIL, "Test Failed");
		// this will display the error message in the output
		//test.fail(result.getThrowable());
		extenttest.get().fail(result.getThrowable());

		try {
			// result will have the driver details since it contains data of the test case
			// using result we are calling gettestclass method, it will go the xml file, in
			// the test folder it will take the class
			// when we say getrealclass, we will go the real class, from there it will get
			// the field driver. We are going class level, since field(driver) is in class
			// level
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) // used exception class instead of using multiple catch since expection is the
								// pareant class for all the exception
		{
			e.printStackTrace();
		}

		String screenShot = null;
		try {
			// driver gets life from the above script that driver is passed to the get
			// screenshot method
			screenShot = getScreenShot(result.getMethod().getMethodName(), driver);// we extends basetest class to this
																					// method
			// to call this method
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extenttest.get().addScreenCaptureFromPath(screenShot, result.getMethod().getMethodName());
		//test.addScreenCaptureFromPath(screenShot, result.getMethod().getMethodName());
	}
	

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// this method gets executed after executing all the test cases
		report.flush();
	}

}
