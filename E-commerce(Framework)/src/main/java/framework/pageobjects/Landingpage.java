package framework.pageobjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.abstractcomponents.AbstractComponents;

public class Landingpage extends AbstractComponents {

	WebDriver driver;

	public Landingpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement userPassword;

	@FindBy(id = "login")
	WebElement submit;

	public Product_catalogue login_Application(String email, String pass) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(pass);
		submit.click();
		Product_catalogue pc = new Product_catalogue(driver);
		return pc;

	}

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
