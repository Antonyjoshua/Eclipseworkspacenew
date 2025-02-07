package annotations;

import org.testng.annotations.AfterClass;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotation2 {

	@Test(groups= {"Name"}) // method marked as @test will be considered as a test case in testng
	public void firsttest2() {
		System.out.println("First test case from second class");
	}

	@AfterTest // method marked as @test will be considered as a test case in testng
	public void aftertest2() {
		System.out.println("aftertest2 from from second class");
	}

	@AfterSuite // This will run once after executing all the other testcases in the entire
	// suite. This is the first to execute
	public void aftersuite2() {
		System.out.println("aftersuite2 test case");
	}

	@BeforeClass // This will run once before executing all the other testcases in the class
	// level which means for this particular class
	public void beforeclass2() {
		System.out.println("beforeclass2 test case");
	}

	@BeforeTest
	public void beforetest2() {
		System.out.println("beforetest2 from class 2");
	}

	@AfterClass // This will run once after executing all the other testcases in the class
	// level which means for this particular class
	public void Afterclass2() {
		System.out.println("Afterclass2 test case");
	}
}
