package CornovusCapital.CornovusCapital;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Standalone {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.get("https://dursqsc766osy.cloudfront.net/");
		driver.findElement(By.name("email")).sendKeys("info@cornovuscapital.com");
		driver.findElement(By.name("password")).sendKeys("pass123");
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block']")).click();
		WebElement dashboard = driver.findElement(By.xpath("//div[@class='col-sm-6']/h1"));
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30000));
		wait.until(ExpectedConditions.visibilityOf(dashboard));
		String dashboards = driver.findElement(By.xpath("//div[@class='col-sm-6']/h1")).getText();
		System.out.println(dashboards);
		Assert.assertEquals(dashboards, "Dashboard");
		
	}

}
