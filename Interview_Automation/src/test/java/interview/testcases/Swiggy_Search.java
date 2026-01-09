package interview.testcases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Swiggy_Search {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
//		driver.get("https://demo.automationtesting.in/Windows.html");
//		driver.findElement(By.xpath("//button[text()='    click   ']")).click();
//		Set<String> windowHandles = driver.getWindowHandles();
//		Iterator<String> iterator = windowHandles.iterator();
//		String parentwindow = iterator.next();
//		String childwindow = iterator.next();
//		driver.switchTo().window(parentwindow);
//		driver.quit();
//		WebDriver driver1 = new ChromeDriver();
//		driver1.get("https://demo.automationtesting.in/Alerts.html");
//		driver1.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
//		Alert alert = driver1.switchTo().alert();
//		alert.accept();
//		driver.get("https://demo.automationtesting.in/Frames.html");
//
//		WebElement frame = driver.findElement(By.id("singleframe"));
//
//		// Scroll the frame into view
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView(true);", frame);
//
//		// Switch to the frame
//		driver.switchTo().frame(frame);
//
//		// Now locate the text box inside the frame
//		WebElement input = driver.findElement(By.xpath("//input[@type='text']"));
//		input.sendKeys("Success");
//		driver.get("https://demo.automationtesting.in/Frames.html");

//		JavascriptExecutor js = (JavascriptExecutor) driver;
//
//		// Click the tab "Iframe with in an Iframe"
//		driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")).click();
//
//		// Locate outer iframe
//		WebElement outerFrame = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
//
//		// Scroll into view
//		js.executeScript("arguments[0].scrollIntoView(true);", outerFrame);
//
//		// Switch to outer frame
//		driver.switchTo().frame(outerFrame);
//
//		// Locate inner iframe
//		WebElement innerFrame = driver.findElement(By.tagName("iframe"));
//
//		// Switch to inner frame
//		driver.switchTo().frame(innerFrame);
//
//		// Enter text
//		driver.findElement(By.tagName("input")).sendKeys("Success");
//		WebElement multipleframe = driver.findElement(By.xpath("//a[@href='#Multiple']"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView(true);", multipleframe);
//		multipleframe.click();
//		WebElement outerframe = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
//		driver.switchTo().frame(outerframe);
//		WebElement innerframe = driver.findElement(By.tagName("iframe"));
//		driver.switchTo().frame(innerframe);
//		WebElement input = driver.findElement(By.xpath("//input[@type='text']"));
//		input.sendKeys("Success");
//		driver.switchTo().defaultContent();
        driver.get("https://www.swiggy.com/");
        
	}

}
