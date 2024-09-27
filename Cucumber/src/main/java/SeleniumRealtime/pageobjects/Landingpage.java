package SeleniumRealtime.pageobjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumRealtime.abstractcomponents.AbstractComponents;

//page object classes- will get all the locators and action method to our test class using the page object class
public class Landingpage extends AbstractComponents {// ctrl+click= to view the parent class
	// Page objects are classes that represent a page or a significant component of
	// a web application. These classes encapsulate the details of how to interact
	// with the elements on the page, including the locators used to find those
	// elements. Page objects provide methods that perform actions on the page,
	// abstracting the low-level interaction details from the test scripts.

	WebDriver driver;

	public Landingpage(WebDriver driver) {
		super(driver);//// super keyword invoke the parent class constructor and pass the value of
						//// driver
		// when we use super keyword in child class, it should be in the first line of
		// the constructor.
		this.driver = driver;
		// Automatic Initialization: Page elements are initialized automatically using
		// PageFactory.initElements().
		PageFactory.initElements(driver, this);
	}

	// The Page Factory Design Pattern is an extension of the Page Object Design
	// Pattern. It uses the PageFactory class in Selenium to instantiate page
	// objects and initialize web elements using annotations. This pattern
	// simplifies the process of locating elements and enhances readability.
	// Instead of WebElement UserEmail= driver.findElement(By.id("userEmail"));
	// we are using Annotations: Uses @FindBy annotations to locate elements.
	// PageFactory.initElements(driver, this);- this method will initialize and
	// trigger all the page elements even we didn't say the script the driver
	@FindBy(id = "userEmail")
	private WebElement userEmail;

	@FindBy(id = "userPassword")
	private WebElement userPassword;

	@FindBy(id = "login")
	// We are achieving the encapsulation by hiding the webelement by making it has
	// private and exposing the action methods by making it has public bcoz we
	// cannot call webelement directly into another class
	private WebElement submit;

	// Action method-These methods represent actions that a user can perform on the
	// web page, such as clicking buttons, entering text, selecting options, etc. By
	// encapsulating these interactions, action methods help keep your test scripts
	// clean, readable, and maintainable.
	// Page object should not hold any data, it should come from the test class. It
	// should only focus on elements and actions
	public Product_catalogue login_Application(String email, String pass) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(pass);
		submit.click();// if we know, after a action it will move to next page, we can create the
						// object in that method in page object class
		// Encapsulates the object creation inside the method- Driver object creation
		// within the page object classes ensapulating from the tests
		Product_catalogue pc = new Product_catalogue(driver);// whenever a object is created for a page object class,
																// the driver will be sent to the page object class
																// through constructor
		return pc;

	}

	// .ng-tns-c4-17.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error
	//// div[contains(@class,'toast-error')]
	@FindBy(xpath = "//div[contains(@class,'toast-error')]")
	WebElement errorMessage;

	public String getErrorMessage() {
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}

	public void url(String url) {
		driver.get(url);

	}

}
