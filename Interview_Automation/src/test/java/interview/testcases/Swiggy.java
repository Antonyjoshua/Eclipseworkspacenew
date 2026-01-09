package interview.testcases;

import java.time.Duration;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Swiggy {

	@Test
	public void swiggy_search() throws InterruptedException
	{
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.amazon.com/");
		Thread.sleep(10000);
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("iPhone");
		WebElement searchclick = driver.findElement(By.id("nav-search-submit-button"));
		searchclick.click();
		WebElement product = driver.findElement(By.xpath("//a[@class='a-link-normal s-line-clamp-2 s-link-style a-text-normal'][1]"));
		List<WebElement> products = driver.findElements(By.xpath("//a[@class='a-link-normal s-line-clamp-2 s-link-style a-text-normal']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement until = wait.until(ExpectedConditions.visibilityOf(product));
		for (WebElement prod : products) {
			if(prod.getText().contains("iPhone"))
			{
				System.out.println("Product listed as per the search");
			}
			else
			{
				System.out.println("Incorrect product in the list"+prod.getText());
			}
			
		}
		
		
	}

}
