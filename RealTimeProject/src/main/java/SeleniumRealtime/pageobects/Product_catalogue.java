package SeleniumRealtime.pageobects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product_catalogue {
	WebDriver driver;

	public Product_catalogue(WebDriver driver) {
		this.driver = driver;
		// Automatic Initialization: Page elements are initialized automatically using
		// PageFactory.initElements().
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(id = "userEmail")
	WebElement userEmail;


}
