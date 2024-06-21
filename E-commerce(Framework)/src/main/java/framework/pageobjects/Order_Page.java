package framework.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.abstractcomponents.AbstractComponents;



public class Order_Page extends AbstractComponents {
	WebDriver driver;

	public Order_Page(WebDriver driver) {
		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//table/tbody/tr/td[2]")
	List<WebElement> orderProducts;
	public boolean getOrderProductName(String productname) {
		boolean orderproductname = orderProducts.stream()
				.anyMatch(orderproduct -> orderproduct.getText().equalsIgnoreCase(productname));
		return orderproductname;
	}
}
