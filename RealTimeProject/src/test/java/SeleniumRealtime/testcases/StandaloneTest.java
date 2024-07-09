package SeleniumRealtime.testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class StandaloneTest {

	public static void main(String[] args) {
		String productname = "IPHONE 13 PRO";
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("antony@yopmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Welcome@123");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.mb-3")));
		List<WebElement> products = driver.findElements(By.cssSelector("div.mb-3"));
		/*
		 * for (int i = 0; i < products.size(); i++) {
		 * 
		 * if(products.get(i).getText().contains("ADIDAS ORIGINAL")) {
		 * //button[@class='btn w-10 rounded']
		 * driver.findElements(By.xpath("//button[@class='btn w-10 rounded']")).get(i).
		 * click(); }
		 * 
		 * }
		 */

		// Using Java streams
		// By.cssSelector(".card-body button:last-of-type")
		//// div[@class='card-body']/button[text()=' Add To Cart']
		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.tagName("b")).getText().equals(productname)).findFirst()
				.orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		// to improve performance, we use invisiblityof
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		// By.xpath("(//button[@class='btn btn-custom'])[3]")
		// By.cssSelector("[routerlink*='cart']")
		driver.findElement(By.xpath("(//button[@class='btn btn-custom'])[3]")).click();
		// .classname childtagname
		List<WebElement> cartproducts = driver.findElements(By.cssSelector(".cartSection h3"));
//		for (int i = 0; i < cartproducts.size(); i++) {
//			if(cartproducts.get(i).getText().contains(productname))
//			{
//				Assert.assertTrue(true);
//			}
//			else
//			{
//				Assert.assertTrue(false);
//			}
//			
//		}
		boolean cartproductname = cartproducts.stream()
				.anyMatch(cartproduct -> cartproduct.getText().equalsIgnoreCase(productname));
		Assert.assertTrue(cartproductname);
		driver.findElement(By.cssSelector(".subtotal.cf.ng-star-inserted button")).click();
		WebElement dd = driver.findElement(By.xpath("//input[@placeholder='Select Country']"));
//		Actions a = new Actions(driver);
//		a.moveToElement(dd).click().sendKeys("Ind").build().perform();

		dd.sendKeys("ind");
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector(".ta-results.list-group.ng-star-inserted")));
		dd.sendKeys(Keys.DOWN);
		dd.sendKeys(Keys.DOWN);
		dd.sendKeys(Keys.ENTER);
//		wait.until(ExpectedConditions
//				.invisibilityOfElementLocated(By.cssSelector(".ta-results.list-group.ng-star-inserted")));
		WebElement click = driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted"));
//		click.click();
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", click);
		//// table/tbody /tr/td/table/tbody/tr[4]/td/table/tbody/tr/td/table/tbody/tr[3]
		String ordermessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		System.out.println(ordermessage);
		Assert.assertTrue(ordermessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		System.out.println("Order ID:" + driver.findElement(By.xpath(("(//table/tbody/tr[3])[2]"))).getText());

	}

}
