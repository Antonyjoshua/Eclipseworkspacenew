package confidentoai.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import confidentoai.abstractcomponents.AbstractComponents;

public class List_User_Page extends AbstractComponents {

	WebDriver driver;

	public List_User_Page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//h1[text()=' List User']")
	WebElement verifyuser;

	public String getverifyuser() {
		waitForWebElementToAppear(verifyuser);
		return verifyuser.getText();

	}

	@FindBy(name = "firstName")
	WebElement firstName;
	
	
	
	@FindBy(xpath = "//label[text()='First Name']")
	WebElement label;

	@FindBy(name = "lastName")
	WebElement lastName;

	@FindBy(name = "email")
	WebElement email;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//div/input[@class='rmdp-input']")
	WebElement dob;

	@FindBy(xpath = "//label[text()='Date of Birth']")
	WebElement close;

	@FindBy(css = "input[value='Male']")
	WebElement gender;

	@FindBy(className = "PhoneInputInput")
	WebElement phoneno;

	@FindBy(name = "address")
	WebElement address;

	@FindBy(name = "context")
	WebElement context;

	@FindBy(name = "nationality")
	WebElement nationality;

	@FindBy(css = "input[type='file']")
	WebElement profile;
	
	
	@FindBy(xpath = "//button[text()='Save']")
	WebElement save;
	
	public void create_user(String firstn, String lastn, String el, String pass, String date, String pno,
			String addr, String ctx, String nation, String pic) throws InterruptedException {
		firstName.sendKeys(firstn);
		lastName.sendKeys(lastn);
		email.sendKeys(el);
		password.sendKeys(pass);
		dob.sendKeys(date);
		label.click();
		Thread.sleep(5000);
		scrollByPixels(500);
		waitForWebElementToAppear(gender);
		gender.click();
		//scrollByPixels(500);
		waitForWebElementToAppear(phoneno);
		phoneno.sendKeys(pno);
		scrollByPixels(300);
		//waitForWebElementToAppear(address);
		address.sendKeys(addr);
		scrollByPixels(500);
		waitForWebElementToAppear(context);
		context.sendKeys(ctx);
		scrollByPixels(200);
		waitForWebElementToAppear(nationality);
		nationality.sendKeys(nation);
		scrollByPixels(200);
		//waitForWebElementToAppear(profile);
		profile.sendKeys(pic);
		scrollToElement(save);
		//scrollByPixels(700);
		save.click();
		

	}

}
