package Cucumber.stepdefinitions;

import java.io.IOException;

import org.testng.Assert;

import SeleniumRealtime.Testcomponents.BaseTest;
import SeleniumRealtime.pageobjects.Cart_Page;
import SeleniumRealtime.pageobjects.Checkout_page;
import SeleniumRealtime.pageobjects.Confirmation_Page;
import SeleniumRealtime.pageobjects.Landingpage;
import SeleniumRealtime.pageobjects.Product_catalogue;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step_Definition_Impl extends BaseTest {
	public Landingpage lp;
	public Product_catalogue pc;
	
	
	public Confirmation_Page cfp;

	@Given("I landed on ecommerce page") // inside the given we should give the exact line what we used in feature file
											// so cucumber will identity for which line we are writing code
	public void I_landed_on_ecommerce_page() throws IOException {
		lp = launching_App();

	}

	@Given("^I want to login in with username (.+) and password (.+)$") // since we are using regular expression ^,$
																		// should be added in the front and end of the
																		// statement
	public void I_want_to_login_in_with_username_and_password(String username, String pass) {
		pc = lp.login_Application(username, pass);//initialize the object
	}

	@When("^I add the product (.+) to the cart$")
	public void add_the_product(String productname) {
		pc.addProductToCart(productname);
	}

	@And("^I checkout the product (.+) and submit order$") // we can use when also here since this is conjucted with
															// previous step
	public void I_checkout_the_product(String productname) {
		Cart_Page cp= pc.goToCart();
		boolean cartProductName = cp.getCartProductName(productname);
		Assert.assertTrue(cartProductName);
		Checkout_page chp=cp.checkout();
		cfp= chp.placeOrder("Ind");
	}

	@Then("{string} message is displayed on confirmation page") //static parameter
	public void verify_the_message(String string) {
		String message = cfp.orderConfirm();
		Assert.assertTrue(message.equalsIgnoreCase(string));
		driver.close();
	}
	
	//static parameter will come from feature file
	@Then("{string} message is displayed on login page") //static parameter
	public void verify_the_login_message(String string) {
		 Assert.assertEquals(string,lp.getErrorMessage());
		driver.close();
	}

}
