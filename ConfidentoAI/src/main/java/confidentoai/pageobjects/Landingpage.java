package confidentoai.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import confidentoai.abstractcomponents.AbstractComponents;
/*Test Class Creates the Driver
In your test class, you create a single WebDriver instance (e.g., driver = new ChromeDriver();).

Passing Driver to Page Object
You pass this driver to the page object class constructor when you create a new instance (e.g., new List_User_Page(driver)).

super(driver) in the Constructor
Inside the page object class (which extends AbstractComponents), the constructor calls super(driver);.

This passes the driver reference up to the AbstractComponents parent class, allowing shared utility methods to use the same driver instance.

this.driver = driver;
The line this.driver = driver; in your page object class assigns the driver reference to the local driver variable of that particular page object.

Both your page object and any inherited functionality in AbstractComponents now have access to the SAME driver originally created in the test.

PageFactory.initElements(driver, this);
This initializes all elements annotated with @FindBy in your page object class, creating the mapping between your driver (browser session) and your defined page elements.

This is part of the PageFactory design pattern and makes your POM (Page Object Model) setup clean and maintainable.

Summary Table

Step	                 What happens
Test creates driver	    driver = new ChromeDriver();
Page object gets it	     new SomePageObject(driver)
super(driver)	         Passes driver up the inheritance chain
this.driver=driver	     Page object stores driver for its own use
PageFactory	Initializes   element mappings for the page object
Everything in the framework (test classes, page objects, utilities) will reference and work in the SAME browser session. This is the intended flow in well-designed Selenium frameworks using POM and PageFactory.*/
public class Landingpage extends AbstractComponents {

	WebDriver driver;
	public Landingpage(WebDriver driver) {
		super(driver);
	   this.driver=driver;
	   
	   PageFactory.initElements(driver, this);
		
	}

	@FindBy(name = "email")
	private WebElement email;
	
	@FindBy(name="password")
	private WebElement pass;
	
	@FindBy(css=".btn.btn-primary.btn-block")
	private WebElement submit;
	
	public void login(String email1, String pass1) {
		email.sendKeys(email1);
		pass.sendKeys(pass1);
		submit.click();

	}
	
	@FindBy(xpath = "//h3[text()='IntervieVR']")
	WebElement verifylogin;

	public String getmessage() {
		waitForWebElementToAppear(verifylogin);
		return verifylogin.getText();
	}

	public void url(String url) {
		driver.get(url);

	}

}
