package SeleniumRealtime.RealTimeProject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Standalonetest {

	public static void main(String[] args) {
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
		////div[@class='card-body']/button[text()=' Add To Cart']
		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.tagName("b")).getText().equals("IPHONE 13 PRO"))
				.findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		// to improve performance, we use invisiblityof
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		// By.xpath("(//button[@class='btn btn-custom'])[3]")
		// By.cssSelector("[routerlink*='cart']")
		driver.findElement(By.xpath("(//button[@class='btn btn-custom'])[3]")).click();
	}

}
