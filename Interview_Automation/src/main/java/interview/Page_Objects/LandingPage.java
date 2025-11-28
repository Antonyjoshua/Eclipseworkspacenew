package interview.Page_Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import interview.abstractcomponent.Utility;

public class LandingPage extends Utility {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	
	public void url(String url)
	{
		driver.get(url);
	}
	
	@FindBy(id="email")
	private WebElement username;
	
	@FindBy(id="pass")
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement login;
	
	@FindBy(xpath= "//label[contains(@class, 'x1a2a7pz')]")
	private WebElement search;
	
	By sh= By.xpath("//label[contains(@class, 'x1a2a7pz')]");
	
	public void validlogin(String userid, String pass)
	{
		username.sendKeys(userid);
		password.sendKeys(pass);
		login.click();
		
	}
	
	public boolean validateHomepage() {
		return search.isDisplayed();

	}
	
	
	
	public void waitForHomePage() {
		
       waitforelement(sh);
	}
	
	
	
	
	

}
