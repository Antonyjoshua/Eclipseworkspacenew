package framework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.abstractcomponents.AbstractComponents;

public class Product_catalogue extends AbstractComponents {
	WebDriver driver;

	public Product_catalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div.mb-3")
	List<WebElement> products;

	By wait = By.cssSelector("div.mb-3");

	public List<WebElement> getProductList() {
		waitForElementToAppear(wait);
		return products;

	}

	public WebElement getProductByName(String productname) {
		WebElement prod = getProductList().stream()
				.filter(product -> product.findElement(By.tagName("b")).getText().equals(productname)).findFirst()
				.orElse(null);
		return prod;
	}

	@FindBy(css = ".ng-animating")
	WebElement loader;
	By addtocart = By.cssSelector(".card-body button:last-of-type");
	By successalert = By.id("toast-container");

	public void addProductToCart(String productname) {
		WebElement prod = getProductByName(productname);
		prod.findElement(addtocart).click();
		waitForElementToAppear(successalert);
		waitForElementTodisappear(loader);
		// cartclick.click();

	}

}
