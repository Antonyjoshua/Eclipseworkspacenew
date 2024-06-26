package framework.Testcomponents;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import framework.resources.Extent_Report_TestNG;

public class Listensers extends BaseTest implements ITestListener {

	ExtentReports report = Extent_Report_TestNG.getReportObject();
	ExtentTest test;
	ThreadLocal<ExtentTest> extenttest= new ThreadLocal<ExtentTest>();

	@Override

	public void onTestStart(ITestResult result) {

		test = report.createTest(result.getMethod().getMethodName());
		extenttest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extenttest.get().log(Status.PASS, "Test Passed");
		extenttest.get().pass(result.getThrowable());
	}

	@Override
	public void onTestFailure(ITestResult result) {

		extenttest.get().fail(result.getThrowable());
		try {
			driver= (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		String screenShot = null;
		try {
			screenShot = getScreenShot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extenttest.get().addScreenCaptureFromPath(screenShot, result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		extenttest.get().log(Status.SKIP, "Method got skipped");
	
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
