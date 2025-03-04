package testng.com;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day3 {
	// prioritizing the testcases with testng
	// include and exclude mechanism to control testcases
	// I've used include method for deleteuser method which means in the output, it
	// will only print the included method
	// use .* to pick the common method to include or exclude from the
	// tescase/eliminate a group of method with common name
	@Test(dependsOnMethods = "deleteUser") // the method mentioned inside will gets executed first before the adduser
											// method.
	public void addUser() {
		System.out.println("adduser");

	}

	@Test(dependsOnMethods = "viewUser") // Since viewUser method is failed, edit user method is skipped //dependent
											// method
	public void edituser() {

		System.out.println("edituser");

	}

	@Test // Since the viewUser method intentionally fails (Assert.assertTrue(false);),
			// the edituser method, which depends on it, will be skipped during the test
			// execution. If you want the edituser method to be executed, you may need to
			// modify the viewUser method to pass successfully or handle the assertion
			// failure appropriately.
	public void viewUser() {
		Assert.assertTrue(false);
		System.out.println("viewuser");
		

	}

	@Test
	public void deleteUser() {
		System.out.println("deleteuser");

	}
	@AfterMethod
	public void aftermethod() {
		System.out.println("Executing after method to check the listener");

	}
//	@BeforeMethod //Before and after method execute for failed test methods also
//	public void Beforemethod() {
//		System.out.println("Executing Before method to check the listener");
//
//	}

}
