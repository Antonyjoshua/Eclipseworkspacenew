package SeleniumRealtime.RealTimeProject;

import java.awt.AWTException;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import SeleniumRealtime.pageobects.Cart_Page;
import SeleniumRealtime.pageobects.Checkout_page;
import SeleniumRealtime.pageobects.Confirmation_Page;
import SeleniumRealtime.pageobects.Landingpage;
import SeleniumRealtime.pageobects.Product_catalogue;

public class Standalone_convert {

	public static void main(String[] args) throws AWTException, InterruptedException {
		String productname = "IPHONE 13 PRO";
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		// Login
		Landingpage lp = new Landingpage(driver);// passing driver to the landing page constructor
		lp.url("https://rahulshettyacademy.com/client");
		// Driver object creation within the page object classes ensapulating from the tests
		//Product_catalogue pc = new Product_catalogue(driver);
		Product_catalogue pc = lp.login_Application("antony@yopmail.com", "Welcome@123");// by this step we can reduce
																							// the object creation for
																							// every class
		//List<WebElement> productList = pc.getProductList();
		pc.getProductByName("IPHONE 13 PRO");
		pc.addProductToCart(productname);
		Cart_Page cp = pc.goToCart();
		// Cart_Page cp = new Cart_Page(driver);
		boolean cartProductName = cp.getCartProductName(productname);
		Assert.assertTrue(cartProductName); // All assertion goes to the test case, should not be in page object files
		Checkout_page chp = cp.checkout();
		Confirmation_Page cfp = chp.placeOrder("Ind");
		String message = cfp.orderConfirm();
		Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();

	}

}
