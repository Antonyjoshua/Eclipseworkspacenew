package framework.Testcase;

import org.testng.Assert;

import org.testng.annotations.Test;

import framework.Testcomponents.BaseTest;
import framework.Testcomponents.Retry;
import framework.pageobjects.Cart_Page;
import framework.pageobjects.Product_catalogue;

public class Error_Validation_Test extends BaseTest {
	@Test(groups = "Errorvalidation", retryAnalyzer = Retry.class)
	public void logininvalid_Credencial() {
		lp.login_Application("josh@yopmail.com", "Welcome@12");
		System.out.println(lp.getErrorMessage());
		//(found, Expected)
		Assert.assertEquals(lp.getErrorMessage(), "Incorrect email password."); 
	}

	
	@Test(retryAnalyzer = Retry.class)
	public void productErrorValidation() {
		String productname = "IPHONE 13 PRO";
		Product_catalogue pc = lp.login_Application("josh@yopmail.com", "Welcome@123");
		pc.getProductByName("IPHONE 13 PRO");
		pc.addProductToCart(productname);
		Cart_Page cp = pc.goToCart();
		boolean cartProductName = cp.getCartProductName("IPHONE 14 PRO");
		System.out.println(cartProductName);
		Assert.assertTrue(cartProductName);

	}

}
