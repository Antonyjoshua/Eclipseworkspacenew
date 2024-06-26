package SeleniumRealtime.testcases;



import org.testng.Assert;


import org.testng.annotations.Test;
import SeleniumRealtime.Testcomponents.BaseTest;
import SeleniumRealtime.Testcomponents.Retry;
import SeleniumRealtime.pageobjects.Cart_Page;
import SeleniumRealtime.pageobjects.Product_catalogue;

public class Error_Validation_Test extends BaseTest {
	@Test(groups = "Errorvalidation", retryAnalyzer = Retry.class) //
	public void logininvalid_Credencial() {
		 lp.login_Application("josh@yopmail.com", "Welcome@12");
		 System.out.println(lp.getErrorMessage());
		 Assert.assertEquals("Incorrect email password.",lp.getErrorMessage());

	}
	//Checking wrong product
	@Test 
	public void productErrorValidation() {
		String productname = "IPHONE 13 PRO";
		Product_catalogue pc = lp.login_Application("josh@yopmail.com", "Welcome@123");
		pc.getProductByName("IPHONE 13 PRO");
		pc.addProductToCart(productname);
		Cart_Page cp = pc.goToCart();
		boolean cartProductName = cp.getCartProductName("IPHONE 14 PRO");
		System.out.println(cartProductName);
		Assert.assertFalse(cartProductName);

	}


}
