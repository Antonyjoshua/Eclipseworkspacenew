package SeleniumRealtime.RealTimeProject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import SeleniumRealtime.pageobects.Landingpage;
import SeleniumRealtime.pageobects.Product_catalogue;

public class Standalone_convert {

	public static void main(String[] args) throws AWTException, InterruptedException {
		String productname = "IPHONE 13 PRO";
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		//Login
		Landingpage lp = new Landingpage(driver);// passing driver to the landing page constructor
		lp.url("https://rahulshettyacademy.com/client");
		lp.login_Application("antony@yopmail.com", "Welcome@123");
		//productlist
		Product_catalogue pc = new Product_catalogue(driver);
		List<WebElement> products = pc.getProductList();
		pc.getProductByName("IPHONE 13 PRO");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));

		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

		driver.findElement(By.xpath("(//button[@class='btn btn-custom'])[3]")).click();

		List<WebElement> cartproducts = driver.findElements(By.cssSelector(".cartSection h3"));
		boolean cartproductname = cartproducts.stream()
				.anyMatch(cartproduct -> cartproduct.getText().equalsIgnoreCase(productname));
		Assert.assertTrue(cartproductname);
		driver.findElement(By.cssSelector(".subtotal.cf.ng-star-inserted button")).click();
		WebElement dd = driver.findElement(By.xpath("//input[@placeholder='Select Country']"));
		a.moveToElement(dd).click().sendKeys("Ind").build().perform();

		dd.sendKeys("ind");
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector(".ta-results.list-group.ng-star-inserted")));
		dd.sendKeys(Keys.DOWN);
		dd.sendKeys(Keys.DOWN);

		WebElement click = driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", click);

		String ordermessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		System.out.println(ordermessage);
		Assert.assertTrue(ordermessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		System.out.println("Order ID:" + driver.findElement(By.xpath(("(//table/tbody/tr[3])[2]"))).getText());

	}

}
