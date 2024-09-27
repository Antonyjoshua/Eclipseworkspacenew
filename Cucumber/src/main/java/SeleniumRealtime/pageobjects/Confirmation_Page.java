package SeleniumRealtime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumRealtime.abstractcomponents.AbstractComponents;

public class Confirmation_Page extends AbstractComponents {
	WebDriver driver;
	public Confirmation_Page(WebDriver driver) {
		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".hero-primary")
	WebElement ordermessage;

	@FindBy(xpath = "(//table/tbody/tr[3])[2]")
	WebElement orderid;

	public String orderConfirm() {
		String message = ordermessage.getText();
		System.out.println("Order ID:" + orderid.getText());
		System.out.println(message);
		return message;
		
	}

	}

