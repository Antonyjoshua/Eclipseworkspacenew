package SeleniumRealtime.abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
    WebDriver driver;
	// this will be the parent class for all the page object classes. this class will
	// hold all the reusable stuffs
	// This class contains all the reusable methodsand it will common for all page
	// object class. Now any page object class can extend this class use the methods
	// present in this class
	
	
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.mb-3")));
	public AbstractComponents(WebDriver driver) {
		this.driver= driver;
	}

	//Webelement- driver.findElement(By.id("userEmail"))
		//by locator- By.id("userEmail")- return type is by
	public void waitForElementToAppe(By findby) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	

	}

}
