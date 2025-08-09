package confidentoai.abstractcomponents;
//An abstract component class in a Selenium test framework is a common design pattern used to represent web components (such as forms, menus, or tables) that can be reused across different pages or tests. This class will encapsulate the common actions and interactions for these components, allowing you to write more modular and maintainable code.

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	public void waitForElementToAppear(By find) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(find));

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

	public void elementToBeClickable(WebElement load) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(load));

	}

	public void scrollToElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void scrollByPixels(int pixels) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, arguments[0]);", pixels);
	}
	
	public void scrollToTop() {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollTo(0, 0);");
	}


	@FindBy(css = "a[href='/list-user']")
	private WebElement listuser;

	public void gotolistuser() {
		listuser.click();
	}

	@FindBy(css = "a[href='/organization']")
	private WebElement organization;

	public void gotoorganize() {
		organization.click();
		scrollToTop();
		

	}

}
