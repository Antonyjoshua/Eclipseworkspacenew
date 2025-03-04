package testng.com;

import org.testng.annotations.Test;

public class Day_2 {
	// By testng xml we can run multiple classes in single click.
	@Test(enabled = false)
	public void enabledmethod()// the enabled attribute is used to enable or disable the execution of a
							// specific test method. This attribute allows you to control whether a
							// particular test method should be executed during a test run.
	{
		System.out.println("This will not execute");
	}
	
	@Test
	public void weblogin()
	{
		System.out.println("Test case 3");
	}


	@Test
	public void mobilelogin() {
		System.out.println("Mobile login1");
	}

	@Test
	public void mobilelogin2() {
		System.out.println("Mobile login 2");
	}

}
