package Final;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Order_OF_Test {
	//test will gets executed in alphabetical order
	@Test(dependsOnMethods = "d")
	public void a()
	{
		System.out.println("a");
	}
	@Test
	public void b()
	{
		System.out.println("b");
	}
	@Test
	public void d()
	{
		System.out.println("d");
		//SoftAssert s= new SoftAssert();
		Assert.assertTrue(false);
		//s.assertAll();
	}
	@Test
	public void c()
	{
		System.out.println("c");
	}

}
