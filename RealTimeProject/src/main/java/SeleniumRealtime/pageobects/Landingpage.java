package SeleniumRealtime.pageobects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Landingpage {
	WebDriver driver;

	public Landingpage(WebDriver driver) {
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
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement userPassword;

	@FindBy(id = "login")
	WebElement submit;

	// Action method-These methods represent actions that a user can perform on the
	// web page, such as clicking buttons, entering text, selecting options, etc. By
	// encapsulating these interactions, action methods help keep your test scripts
	// clean, readable, and maintainable.
	// Page object should not hold any data, it should come from the test class. It
	// should only focus on elements and actions
	public void login_Application(String email, String pass) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(pass);
		submit.click();

	}
	
	public void url(String url) 
	{
		driver.get(url);

	}

}
