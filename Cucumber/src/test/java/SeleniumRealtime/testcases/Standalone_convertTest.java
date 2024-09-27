package SeleniumRealtime.testcases;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SeleniumRealtime.Testcomponents.BaseTest;
import SeleniumRealtime.pageobjects.Cart_Page;
import SeleniumRealtime.pageobjects.Checkout_page;
import SeleniumRealtime.pageobjects.Confirmation_Page;
import SeleniumRealtime.pageobjects.Landingpage;
import SeleniumRealtime.pageobjects.Order_Page;
import SeleniumRealtime.pageobjects.Product_catalogue;

public class Standalone_convertTest extends BaseTest {
//	public static void main(String[] args) throws AWTException, InterruptedException {
//	String productname = "IPHONE 13 PRO";
//	WebDriver driver = new EdgeDriver();
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	driver.manage().window().maximize();
//	// Login
//	Landingpage lp = new Landingpage(driver);
//	lp.url("https://rahulshettyacademy.com/client");
//	lp.login_Application("antony@yopmail.com", "Welcome@123");
	// product catalogue
//	Product_catalogue pc = new Product_catalogue(driver);
//	pc.getProductByName("IPHONE 13 PRO");
//	pc.addProductToCart(productname);
//pc.goToCart();
//cartpage	
//	 Cart_Page cp = new Cart_Page(driver);
//	boolean cartProductName = cp.getCartProductName(productname);
//	Assert.assertTrue(cartProductName); // All assertion goes to the test case, should not be in page object files
//	 cp.checkout();
//checkout page	
//	Checkout_page chp= new Checkout_page(driver);
//  chp.placeOrder("Ind");
//confirmationpage	
//Confirmation_Page cfp= new Confirmation_Page(driver);	
//	String message = cfp.orderConfirm();
//	Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
//	driver.close();

//}

//	public static void main(String[] args) throws AWTException, InterruptedException {
//		String productname = "IPHONE 13 PRO";
//		WebDriver driver = new EdgeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().window().maximize();
//		// Login
//		Landingpage lp = new Landingpage(driver);// passing driver to the landing page constructor
//		lp.url("https://rahulshettyacademy.com/client");
//		// Driver object creation within the page object classes ensapulating from the tests
//		//Product_catalogue pc = new Product_catalogue(driver);
//		Product_catalogue pc = lp.login_Application("antony@yopmail.com", "Welcome@123");// by this step we can reduce
//																							// the object creation for
//																							// every class
//		//List<WebElement> productList = pc.getProductList();
//		pc.getProductByName("IPHONE 13 PRO");
//		pc.addProductToCart(productname);
//		Cart_Page cp = pc.goToCart();
//		// Cart_Page cp = new Cart_Page(driver);
//		boolean cartProductName = cp.getCartProductName(productname);
//		Assert.assertTrue(cartProductName); // All assertion goes to the test case, should not be in page object files
//		Checkout_page chp = cp.checkout();
//		Confirmation_Page cfp = chp.placeOrder("Ind");
//		String message = cfp.orderConfirm();
//		Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
//		driver.close();

//	}
	/*
	 * @Test public void convertedcode1() throws IOException { String productname =
	 * "IPHONE 13 PRO"; Landingpage lp = launching_App(); Product_catalogue pc =
	 * lp.login_Application("antony@yopmail.com", "Welcome@123");
	 * pc.getProductByName("IPHONE 13 PRO"); pc.addProductToCart(productname);
	 * Cart_Page cp = pc.goToCart(); boolean cartProductName =
	 * cp.getCartProductName(productname); Assert.assertTrue(cartProductName);
	 * Checkout_page chp = cp.checkout(); Confirmation_Page cfp =
	 * chp.placeOrder("Ind"); String message = cfp.orderConfirm();
	 * Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	 * driver.close();
	 * 
	 * }
	 */
	String productname = "IPHONE 13 PRO";

	@Test(dataProvider = "getdata", groups = { "multipledata", "Errorvalidation" })
	// public void convertedcode(String email, String password, String productname)
	public void purchaseOrder(HashMap<String, String> input) {

		// Product_catalogue pc = lp.login_Application(email, password);
		Product_catalogue pc = lp.login_Application(input.get("email"), input.get("password"));
		// pc.getProductByName(input.get("productname"));
		pc.addProductToCart(input.get("productname"));
		Cart_Page cp = pc.goToCart();// We are using pc object for gotocart method eventhough it's not in the product
										// catalog class and it's in the abstractcompenent class. Reason is since
										// product catelogue class inherting abstract comp class It has all the methods
										// present in abs class. We can call that method using the pc object
		boolean cartProductName = cp.getCartProductName(input.get("productname"));
		Assert.assertTrue(cartProductName);
		Checkout_page chp = cp.checkout();
		Confirmation_Page cfp = chp.placeOrder("Ind");
		String message = cfp.orderConfirm();
		Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

	@Test(dependsOnMethods = { "purchaseOrder" }, groups = "Errorvalidation") // If we want to run this method while
																				// running a group, the name should be
																				// added to that method also to execute
																				// with the depended test method
	// first convertedcode method will gets executed. If that method fails, then
	// this method will get skipped
	// this method is about logging into the application and checking the order
	// placed product in the order page
	// for every test method we need to login into the application
	public void orderHistoryTest()

	{

		Product_catalogue pc = lp.login_Application("antony@yopmail.com", "Welcome@123");
		Order_Page op = pc.goToorder();
		boolean orderProductName = op.getOrderProductName(productname);
		Assert.assertTrue(orderProductName);

	}

//	@DataProvider//helps to drive the data and pass multiple data sets
//	public Object[][] getdata()
//	{
	// Way 1
	// multidimentional array
//		Object ob[][]= new Object[2][3];
//		ob[0][0]="antony@yopmail.com";
//		ob[0][1]="Welcome@123";
//		ob[0][2]="IPHONE 13 PRO";
//		ob[1][0]="josh@yopmail.com";
//		ob[1][1]="Welcome@123";
//		ob[1][2]="ADIDAS ORIGINAL";
//		return ob;
	// way2
//		return new Object[][] {{"antony@yopmail.com","Welcome@123","IPHONE 13 PRO"},{"josh@yopmail.com","Welcome@123","ADIDAS ORIGINAL"}};
//		
//	}

	@DataProvider // Integration of hash map to dataprovider to send the data as one hash object
	public Object[][] getdata() throws IOException {
		// way 3
		// when we use object we can use any data type
		// HashMap<Object,Object> map= new HashMap<Object,Object>();
		// HashMap<String,String> map= new HashMap<String,String>();
		// key, value pair
//		map.put("email", "antony@yopmail.com");
//		map.put("password", "Welcome@123");
//		map.put("productname","IPHONE 13 PRO");
//		HashMap<String,String> map1= new HashMap<String,String>();
//		map1.put("email", "josh@yopmail.com");
//		map1.put("password", "Welcome@123");
//		map1.put("productname","ADIDAS ORIGINAL");
		// return new Object[][] { {map},{map1} };
		// way 4
		// Reading data from the json and creat list of hashmap out of it
		// create a json file with data
		// create a method in basetest class which read the json data and convert into
		// string, then the string is converted into list of hashmap using object mapper
		// class
		List<HashMap<String, String>> jsonDatatoMap = getJsonDatatoMap(System.getProperty("user.dir")
				+ "\\src\\test\\java\\SeleniumRealtime\\Testcomponents\\PassingDataToPurchaseOrder.json");
		// return new Object[][] { {map},{map1} };
		// sending two data set, each time the test method will run
		return new Object[][] { { jsonDatatoMap.get(0) }, { jsonDatatoMap.get(1) } };

	}

}
