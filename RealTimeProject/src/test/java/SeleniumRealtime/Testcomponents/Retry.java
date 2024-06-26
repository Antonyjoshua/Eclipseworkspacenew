package SeleniumRealtime.Testcomponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

//To retry the failed test case one more time to confirm whether it is really failed
//IretryAnalyzer is an interface
//Listeners are activated inside the xml file. This is only applicable for itestlistener interface. 
//for iretryanalyser we have to give it to the failed method itself as a attribute. The failed testcase will run multiple times first one got skipped and next one as failed
//Based on the condition in this class, the test case will run multiple times.
//when a test fails, it will go the listeners as well as this method. After taking screenshot and logging the result in the report it comes to this block and execute it.
public class Retry implements IRetryAnalyzer {
	int count = 0;
	int maxTry = 1;

	@Override
	// Returns true if the test method has to be retried, false otherwise.
	// for iretryanalyser we have to give it to the failed method itself as a
	// attribute ex: retryAnalyzer = Retry.class
	public boolean retry(ITestResult result) {
		if (count < maxTry) {
			count++;
			// when this method return true it will rerun the test case
			return true;
		}
		return false;
		// if returns false it won't run again
		// when (1<1) becomes false it won't run again
	}

}
