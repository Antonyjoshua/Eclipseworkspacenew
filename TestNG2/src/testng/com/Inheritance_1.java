package testng.com;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Inheritance_1  {
	
	@BeforeMethod
	public void parentmethod1()
	{
		System.out.println("before method in parent class");
	}
	
	public void parentmethod()
	{
		System.out.println("Parent method");
	}
	
	@AfterMethod
	public void parentmethod2()
	{
		System.out.println("after method in parent class");
	}
}
