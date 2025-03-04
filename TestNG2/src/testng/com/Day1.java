package testng.com;

import org.testng.annotations.Test;

public class Day1 {
	// @test annotation acts as a JAVA complier and we don't need to use main method
	// @Test annotation each method with @Test is considered as a test case, we can
	// have n number of test cases in a class
	@Test (timeOut = 3000)// timeout attribute is used to specify the maximum time allowed for the
			// execution of a test method. If the test method takes longer than the
			// specified timeout value, TestNG will consider the test as failed, and the
			// execution of that test method will be interrupted.
	public void print() {
		System.out.println("Testcase 1");

	}

	@Test
	public void print1() {
		System.out.println("Testcase 2");
	}

}
