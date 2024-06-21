package framework.Testcase;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import framework.Testcomponents.BaseTest;
import framework.pageobjects.Cart_Page;
import framework.pageobjects.Checkout_page;
import framework.pageobjects.Confirmation_Page;
import framework.pageobjects.Order_Page;
import framework.pageobjects.Product_catalogue;

public class PurchaseOrder extends BaseTest {

	String productname = "IPHONE 13 PRO";

	@Test(dataProvider = "getdata", groups = { "multipledata", "Errorvalidation" })
	public void purchaseOrder(HashMap<String, String> input) {

		Product_catalogue pc = lp.login_Application(input.get("email"), input.get("password"));
		pc.addProductToCart(input.get("productname"));
		Cart_Page cp = pc.goToCart();
		boolean cartProductName = cp.getCartProductName(input.get("productname"));
		Assert.assertTrue(cartProductName);
		Checkout_page chp = cp.checkout();
		Confirmation_Page cfp = chp.placeOrder("Ind");
		String message = cfp.orderConfirm();
		Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

	@Test(dependsOnMethods = { "purchaseOrder" })
	public void orderHistoryTest()

	{

		Product_catalogue pc = lp.login_Application("antony@yopmail.com", "Welcome@123");
		Order_Page op = pc.goToorder();
		boolean orderProductName = op.getOrderProductName(productname);
		Assert.assertTrue(orderProductName);

	}

	@DataProvider
	public Object[][] getdata() throws IOException {

		List<HashMap<String, String>> jsonDatatoMap = getJsonDatatoMap(System.getProperty("user.dir")
				+ "\\src\\test\\java\\framework\\Testcomponents\\PassingDataToPurchaseOrder.json");
		return new Object[][] { { jsonDatatoMap.get(0) }, { jsonDatatoMap.get(1) } };

	}

}
