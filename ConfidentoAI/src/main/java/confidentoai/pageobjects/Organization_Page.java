package confidentoai.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*The line

java
PageFactory.initElements(driver, this);
is calling a static method initElements from Selenium’s PageFactory class. It tells Selenium:

“Using this driver instance, go ahead and initialize all the @FindBy-annotated fields in this current page object instance.”

Breaking it down in simple terms:
driver: The WebDriver instance that controls the browser.

this: The current instance of the Page Object class (i.e., the object you are creating and want to initialize).

Why is the order driver, this and NOT (this, driver)?
Because the method signature of initElements is defined as:

java
public static void initElements(WebDriver driver, Object page);
The first parameter must be a WebDriver object.

The second parameter must be the page object instance (this).

If you switch the order to (this, driver), it doesn’t match the method’s expected parameters — Java will throw a compiler error because it expects a WebDriver first and an object second, not vice versa.

In short:
PageFactory.initElements(driver, this) means:
"Initialize elements of this page object (this), using the given browser driver (driver)."

You can’t do (this, driver) because the method expects the WebDriver first, then the page object.

Summary:

driver always comes first (it’s required to find elements).

this (the current page object) comes second (the object to initialize).

The order matters and must match the method’s signature exactly.*/

import confidentoai.abstractcomponents.AbstractComponents;

public class Organization_Page extends AbstractComponents {

	WebDriver driver;

	public Organization_Page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[text()=' Organization List']")
	WebElement verifyorg;
	
	@FindBy(className = "css-19bb58m") // for user select field
    WebElement selectUserInput;

    @FindBy(name = "groupname")
     WebElement groupNameInput;

    @FindBy(css = ".btn.btn-success.save-btn.btn.btn-primary")
    WebElement saveButton;

	
	public String getorg() {
		return verifyorg.getText();

	}

	public void create_org(String usersearch,String grpname) throws InterruptedException
	{
		Actions a = new Actions(driver);
		waitForWebElementToAppear(selectUserInput);
		a.moveToElement(selectUserInput).click().sendKeys(usersearch).perform();
		Thread.sleep(500);
		a.sendKeys(Keys.ENTER).perform();
        groupNameInput.sendKeys(grpname);
        saveButton.click();

	}
	
}
