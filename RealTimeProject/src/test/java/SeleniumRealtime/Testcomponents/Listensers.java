package SeleniumRealtime.Testcomponents;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import SeleniumRealtime.resources.Extent_Report_TestNG;

public class Listensers extends BaseTest implements ITestListener {
	// classname.methodname to call the static method without creating object
	//calling  getReportObject() here to access the extent reports
	ExtentReports report = Extent_Report_TestNG.getReportObject();
	ExtentTest test;

	@Override
	// Writing create test here since it's object is mandatory to get the data from
	// the test method, so
	// before running any test this block will gets executed
	public void onTestStart(ITestResult result) {
		//Invoked each time before a test will be invoked
		// this will get the methodname of the testmethod before executing them
		// ExtentTest createTest = report.createTest("Extent report demo");
		test = report.createTest(result.getMethod().getMethodName());
	}

	// result variable contains all the data about the test method, by using this
	// object we can perform various actions
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//test.log(Status.FAIL, "Test Failed");
		// this will display the error message in the output
		test.fail(result.getThrowable());
		String screenShot = null ;
		try {
			screenShot = getScreenShot(result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(screenShot, result.getMethod().getMethodName());
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
