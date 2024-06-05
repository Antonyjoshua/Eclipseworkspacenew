package SeleniumRealtime.testcases;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import SeleniumRealtime.Testcomponents.BaseTest;
import SeleniumRealtime.pageobjects.Cart_Page;
import SeleniumRealtime.pageobjects.Checkout_page;
import SeleniumRealtime.pageobjects.Confirmation_Page;
import SeleniumRealtime.pageobjects.Landingpage;
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
	/*@Test
	public void convertedcode1() throws IOException {
		String productname = "IPHONE 13 PRO";
		Landingpage lp = launching_App();
		Product_catalogue pc = lp.login_Application("antony@yopmail.com", "Welcome@123");
		pc.getProductByName("IPHONE 13 PRO");
		pc.addProductToCart(productname);
		Cart_Page cp = pc.goToCart();
		boolean cartProductName = cp.getCartProductName(productname);
		Assert.assertTrue(cartProductName);
		Checkout_page chp = cp.checkout();
		Confirmation_Page cfp = chp.placeOrder("Ind");
		String message = cfp.orderConfirm();
		Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();

	}*/
	@Test
	public void convertedcode(){
		String productname = "IPHONE 13 PRO";
		Product_catalogue pc = lp.login_Application("antony@yopmail.com", "Welcome@123");
		pc.getProductByName("IPHONE 13 PRO");
		pc.addProductToCart(productname);
		Cart_Page cp = pc.goToCart();
		boolean cartProductName = cp.getCartProductName(productname);
		Assert.assertTrue(cartProductName);
		Checkout_page chp = cp.checkout();
		Confirmation_Page cfp = chp.placeOrder("Ind");
		String message = cfp.orderConfirm();
		Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

}
