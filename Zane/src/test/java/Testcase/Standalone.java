package Testcase;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Standalone {

	public static void main(String[] args) throws InterruptedException {
		// to bybass the ssl certificate
		ChromeOptions option = new ChromeOptions();
		// accept the certificate
		option.setAcceptInsecureCerts(true);
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://3.16.143.173/");
		String title = driver.getTitle();
		System.out.println(title);
		// Instead of doing manualy we can use chromeoptions to handle the certificate
//		driver.findElement(By.id("details-button")).click();
//		driver.findElement(By.id("proceed-link")).click();
		WebElement products = driver.findElement(By.xpath("//button[text()='Products']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loadingmsg")));
		wait.until(ExpectedConditions.elementToBeClickable(products));
		try {
			products.click();
		} catch (Exception e) {
			System.out.println("Failed to click the Products button: " + e.getMessage());
		}
		driver.findElement(By.xpath("//a[@class='nav-link ']//p[text()='Headboards']")).click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 300)");
		WebElement addtocart = driver.findElement(By.xpath("//a[@class='cart btntran']"));
		wait.until(ExpectedConditions.visibilityOf(addtocart));
		List<WebElement> productslist = driver.findElements(By.xpath("//a/h5"));
		for (int i = 0; i < productslist.size(); i++) {
			String productname = productslist.get(i).getText();
			if (productname.contains("Namo Headboard - King")) {
				try {

					driver.findElements(By.xpath("//a[@class='cart btntran']")).get(i).click();
				} catch (Exception e) {
					System.out.println("Failed to click the addtocart button: " + e.getMessage());
				}

			}
		}
		driver.findElement(By.xpath("//a[@title='Cart']/span")).click();
		Thread.sleep(5000);
		String cartproduct = driver.findElement(By.xpath("//a[@class='cartPageLink']/p")).getText();
		Assert.assertEquals(cartproduct, "NAMO HEADBOARD - KING");
		Thread.sleep(5000);
		js.executeScript("window.scrollTo(0, 450)");
		driver.findElement(By.xpath("//input[contains(@placeholder, 'Please Enter')]")).sendKeys("Antony");
		driver.findElement(By.xpath("//input[contains(@placeholder, 'Email ID')]")).sendKeys("antony@yopmail.com");
		driver.findElement(By.xpath("//input[contains(@placeholder, 'Phone Number')]")).sendKeys("9514084222");
		driver.findElement(By.xpath("//textarea[contains(@placeholder, 'Drop Your Queries')]")).sendKeys("Please reach us soon");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loadingmsg")));
		WebElement submitInquiry = driver.findElement(By.xpath("//div[@class='send-inquiry']/button"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", submitInquiry);
        wait.until(ExpectedConditions.elementToBeClickable(submitInquiry)).click();


		
		
		
	
		
		}
}
