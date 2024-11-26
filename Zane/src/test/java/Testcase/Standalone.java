package Testcase;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Standalone {

	// note: xpath don't work if you use class with empty space between btw
	// btn-class
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
		Actions a = new Actions(driver);
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
//		WebElement addtocart = driver.findElement(By.xpath("//a[@class='cart btntran']"));
//		wait.until(ExpectedConditions.visibilityOf(addtocart));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a/h5")));
		List<WebElement> productslist = driver.findElements(By.xpath("//a[1]/h5"));
		int size = productslist.size();
		System.out.println(size);
		for (int i = 0; i < productslist.size(); i++) {
			String productname = productslist.get(i).getText();
			if (productname.equalsIgnoreCase("Two Queen Headboard")) {
				try {
					System.out.println(productname);
					driver.findElements(By.xpath("//a[@class='cart btntran']")).get(i).click();
				} catch (Exception e) {
					System.out.println("Failed to click the addtocart button: " + e.getMessage());
				}

			}
		}
		//// a[@title='Cart']/span
		driver.findElement(By.xpath("//li[@class='nav-item mob cart-count']/a[1]")).click();
		Thread.sleep(5000);
		String cartproduct = driver.findElement(By.xpath("//tbody/tr/td[2]/a")).getText();
		Assert.assertEquals(cartproduct, "Two Queen Headboard");
//		Thread.sleep(5000);
//		js.executeScript("window.scrollTo(0, 600)");
		driver.findElement(By.xpath("//input[contains(@placeholder, 'Please Enter')]")).sendKeys("Antony");
		driver.findElement(By.xpath("//input[contains(@placeholder, 'Email ID')]")).sendKeys("antony@yopmail.com");
		driver.findElement(By.xpath("//input[contains(@placeholder, 'Contact Number')]")).sendKeys("9514084222");

		driver.findElement(By.xpath("//input[contains(@placeholder, 'The Property Name')]")).sendKeys("Hotel");
		driver.findElement(By.xpath("//textarea[contains(@placeholder, 'The Shipping To Address')]"))
				.sendKeys("No:117B, sri srinivasan nagar,poonamallee");
		WebElement same = driver.findElement(By.id("sameAsShipTo"));
		a.moveToElement(same).click().perform();
		
		driver.findElement(By.xpath("//textarea[contains(@placeholder, 'Drop Your Queries')]"))
				.sendKeys("Please reach us soon");
		// driver.findElement(By.xpath("//div/label[text()='Ship To
		// Address']")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loadingmsg")));

		driver.findElement(By.xpath("//div/label[text()='Ship To Address']")).click();
		// js.executeScript("window.scrollTo(0, 300)");
		WebElement submitInquiry = driver.findElement(By.xpath("//div[@class='send-inquiry']/button"));
		
		a.moveToElement(submitInquiry).click().perform();
		WebElement thankyoutext = driver.findElement(By.xpath("//h2[text()='Thanks For Submitting!']"));
		wait.until(ExpectedConditions.visibilityOf(thankyoutext));
		WebElement pdf = driver.findElement(By.xpath("//a/img[@class='img-thumbnail']"));
		wait.until(ExpectedConditions.visibilityOf(pdf));
		WebElement thankyoupage = driver.findElement(By.xpath("(//tr/td[2])[2]"));
		String nameproduct = thankyoupage.getText();
		Assert.assertEquals(nameproduct, "Two Queen Headboard");
		a.moveToElement(pdf).click().perform();
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> iterator = windowHandles.iterator();
		String pw = iterator.next();
		String cw = iterator.next();
		driver.switchTo().window(pw);
		// note: xpath don't work if you use class with empty space between btw
		// btn-class
		// WebElement home = driver.findElement(By.cssSelector("#thankyou > div >
		// div.text-center.mt-4 > a"));

		WebElement home = driver.findElement(By.linkText("Go Home"));
		System.out.println(home.getText());
	    Actions a1 = new Actions(driver);
//		home.click();
     	wait.until(ExpectedConditions.elementToBeClickable(home));
     	if (home.isDisplayed() && home.isEnabled()) {
     		 a1.moveToElement(home).click().perform();
     	}else {
			System.out.println("Element is not interactable.");
		}
 	   
//		//wait.until(ExpectedConditions.elementToBeClickable(home)).click();
//		try {
//			js.executeScript("arguments[0].scrollIntoView();", home);
//			home.click();
//		} catch (Exception e) {
//			System.out.println("Failed to click the gohome button: " + e.getMessage());
//		}

//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", home);
//		if (home.isDisplayed() && home.isEnabled()) {
//			wait.until(ExpectedConditions.elementToBeClickable(home)).click();
//		} else {
//			System.out.println("Element is not interactable.");
//		}

	}
}
