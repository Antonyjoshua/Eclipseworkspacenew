package framework.abstractcomponents;
//An abstract component class in a Selenium test framework is a common design pattern used to represent web components (such as forms, menus, or tables) that can be reused across different pages or tests. This class will encapsulate the common actions and interactions for these components, allowing you to write more modular and maintainable code.

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.pageobjects.Cart_Page;
import framework.pageobjects.Order_Page;

public class AbstractComponents {
	WebDriver driver;

	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForElementToAppear(By findby) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));

	}

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
