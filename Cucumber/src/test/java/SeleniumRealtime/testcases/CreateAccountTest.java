package SeleniumRealtime.testcases;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import SeleniumRealtime.Testcomponents.BaseTest;

public class CreateAccountTest extends BaseTest {

	//public static void main(String[] args) 
	@Test
	public void createaccount()
	{
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.xpath("//a[@class='btn1']")).click();
		driver.findElement(By.id("firstName")).sendKeys("Antony");
		driver.findElement(By.id("lastName")).sendKeys("Joshua");
		driver.findElement(By.id("userEmail")).sendKeys("antony@yopmail.com");
		driver.findElement(By.id("userMobile")).sendKeys("1234567890");
		WebElement occupation = driver.findElement(By.cssSelector("select[formcontrolname='occupation']"));
		Select s = new Select(occupation);
		s.selectByIndex(3);
		WebElement male = driver.findElement(By.xpath("//span[text()='Male']"));
		driver.findElement(with(By.tagName("input")).above(male)).click();
		driver.findElement(By.id("userPassword")).sendKeys("Welcome@123");
		driver.findElement(By.id("confirmPassword")).sendKeys("Welcome@123");
		driver.findElement(By.cssSelector("input[formcontrolname='required']")).click();
//		WebElement submit = driver.findElement(By.xpath("//div[text()=' I am 18 year or Older ']"));
//		driver.findElement(with(By.tagName("input")).below(submit)).click();
		 WebElement element = driver.findElement(By.xpath("//input[@type='submit']"));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		// in Selenium occurs when an element is being clicked but another element (such
		// as an overlay or popup) is obstructing it, preventing the click action from
		// being performed. This can happen due to various reasons such as modals,
		// popups, or other elements appearing in front of the clickable element.

	}

}
