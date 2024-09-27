package SeleniumRealtime.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import SeleniumRealtime.abstractcomponents.AbstractComponents;

public class Cart_Page extends AbstractComponents {
	WebDriver driver;

	public Cart_Page(WebDriver driver) {
		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	

	@FindBy(css = ".cartSection h3")
	List<WebElement> cartproducts;

	public List<WebElement> getCartProducts() {
		return cartproducts;

	}

	public boolean getCartProductName(String productname) {
		boolean cartproductname = cartproducts.stream()
				.anyMatch(cartproduct -> cartproduct.getText().equalsIgnoreCase(productname));
		return cartproductname;
	}

	@FindBy(css = ".subtotal.cf.ng-star-inserted button")
	WebElement checkout;

	public Checkout_page checkout() {

		checkout.click();
		Checkout_page chp= new Checkout_page(driver);
		return chp;
	}

}
