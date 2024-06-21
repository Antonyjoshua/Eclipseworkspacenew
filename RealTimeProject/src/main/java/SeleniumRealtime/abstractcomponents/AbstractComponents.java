package SeleniumRealtime.abstractcomponents;
//An abstract component class in a Selenium test framework is a common design pattern used to represent web components (such as forms, menus, or tables) that can be reused across different pages or tests. This class will encapsulate the common actions and interactions for these components, allowing you to write more modular and maintainable code.

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SeleniumRealtime.pageobjects.Cart_Page;
import SeleniumRealtime.pageobjects.Order_Page;

public class AbstractComponents // base parent class for the page object files- it stores all reusable content
{
	WebDriver driver;
	// this will be the parent class for all the page object classes. this class
	// will
	// hold all the reusable stuffs
	// This class contains all the reusable methodsand it will common for all page
	// object class. Now any page object class can extend this class use the methods
	// present in this class

	// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.mb-3")));
	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
	}

	// Webelement- driver.findElement(By.id("userEmail"))
	// by locator- By.id("userEmail")- return type is by
	// by by locator
	public void waitForElementToAppear(By findby) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));

	}

	// by webelement
	public void waitForWebElementToAppear(WebElement find) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(find));

	}

	public void waitForElementTodisappear(WebElement load) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(load));

	}

	@FindBy(xpath = "(//button[@class='btn btn-custom'])[3]")
	WebElement cartclick;

	public Cart_Page goToCart() {
		cartclick.click();
		Cart_Page cp = new Cart_Page(driver);
		return cp; // after this action, it moves to cart page

	}

	// button[@routerlink= '/dashboard/myorders']
	@FindBy(xpath = "//button[@routerlink= '/dashboard/myorders']")
	WebElement orderpage;

	public Order_Page goToorder() {
		orderpage.click();
		Order_Page op = new Order_Page(driver);
		return op; // after this action, it moves to cart page

	}

}
