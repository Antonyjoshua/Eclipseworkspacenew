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

public class Product_catalogue extends AbstractComponents {
	WebDriver driver;

	public Product_catalogue(WebDriver driver) {
		super(driver);// All the page object class constructor should have this step to pass the
						// driver to the abstractcomponent
		this.driver = driver;
		// Automatic Initialization: Page elements are initialized automatically using
		// PageFactory.initElements().
		PageFactory.initElements(driver, this);
	}
	// List<WebElement> products = driver.findElements(By.cssSelector("div.mb-3"));

	@FindBy(css = "div.mb-3")
	List<WebElement> products; // getproductlist method
	// waitForElementToAppe(By.cssSelector("div.mb-3"))-for this step, we cannot use
	// page factory, page factory is exclusive for driver.findelement and
	// findelements- for this
	// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.mb-3")))
	//  we are using by locator
	// Webelement- driver.findElement(By.id("userEmail"))
	// by locator- By.id("userEmail")- return type is by
	// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.mb-3")));
	// List<WebElement> products = driver.findElements(By.cssSelector("div.mb-3"));
	By wait = By.cssSelector("div.mb-3");
	

//getting product list
	public List<WebElement> getProductList() {
		waitForElementToAppear(wait);
		// waitForElementToAppe(By.cssSelector("div.mb-3"));
		return products;

	}

//	public void getProductByName(String productname) {
//		// we can also use getProductList() instead of products.stream()
//		// WebElement prod = getProductList().stream()
//		WebElement prod = products.stream()
//				.filter(product -> product.findElement(By.tagName("b")).getText().equals(productname)).findFirst()
//				.orElse(null);
//	}
	// Way 2 of writing the above method
	// filtering the data by name
	// WebElement prod = products.stream()
	// .filter(product ->
	// product.findElement(By.tagName("b")).getText().equals(productname)).findFirst()
	// .orElse(null);
	public WebElement getProductByName(String productname) {
		WebElement prod = getProductList().stream()
				.filter(product -> product.findElement(By.tagName("b")).getText().equals(productname)).findFirst()
				.orElse(null);
		return prod;
	}

	// clicking that element by name
	// prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	// we cannot apply page factory for within webelement.findelement. It's only for driver.findelement
	//driver.findElement(By.xpath("(//button[@class='btn btn-custom'])[3]")).click();
	@FindBy (xpath= "(//button[@class='btn btn-custom'])[3]")
	WebElement cartclick;
	
	@FindBy (css= ".ng-animating")
	WebElement loader;
	By addtocart = By.cssSelector(".card-body button:last-of-type");
	By successalert= By.id("toast-container");
	
	public void addProductToCart(String productname) {
		WebElement prod = getProductByName(productname);
		prod.findElement(addtocart).click();
		waitForElementToAppear(successalert);
		waitForElementTodisappear(loader);
		//cartclick.click();
		

	}
	public Cart_Page goToCart() {
		cartclick.click();
		Cart_Page cp = new Cart_Page(driver);
		return cp; //after this action, it moves to cart page

	}

}