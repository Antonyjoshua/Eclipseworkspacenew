package testng.com;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day4 {
	// I've used exclude on deletehotel method which means it will be removed from
	// the execution
	@Parameters({ "Username" }) // Parameterization in TestNG allows you to run the same test method with
								// different sets of data. This is useful when you want to test a functionality
								// with various input values or configurations. If the value is common for all
								// the test folders declare it after suite. If it is specific to a particular
								// test folder declare it inside the test floder which is after <test>
	@Test
	public void addHotel(String username) {
		System.out.println("addhotel");
		System.out.println(username);
	}

	@Test
	public void editHotel() {
		System.out.println("edithotel");

	}

	@Test
	public void viewHotel() {
		System.out.println("viewhotel");

	}

	@Test
	public void deletehotel() {
		System.out.println("deletehotel");

	}
	

}
