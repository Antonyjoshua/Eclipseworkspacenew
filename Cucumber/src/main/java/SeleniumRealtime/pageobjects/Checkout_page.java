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

public class Checkout_page extends AbstractComponents {
	WebDriver driver;

	public Checkout_page(WebDriver driver) {
		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement dd;

	By dropdown = By.cssSelector(".ta-results.list-group.ng-star-inserted");

	@FindBy(css = ".btnn.action__submit.ng-star-inserted")
	WebElement placeorder;

	public Confirmation_Page placeOrder(String country) {
		dd.sendKeys(country);
		waitForElementToAppear(dropdown);
		dd.sendKeys(Keys.DOWN);
		dd.sendKeys(Keys.DOWN);
		dd.sendKeys(Keys.ENTER);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", placeorder);
		//Confirmation_Page cfp= new Confirmation_Page(driver);
		return  new Confirmation_Page(driver);

	}

	
}
