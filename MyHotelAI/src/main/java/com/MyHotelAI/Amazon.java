package com.MyHotelAI;

import java.security.Key;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		//Create a dynamic xpath which can find all headlines on Amazon.com?
//		go to Amazon.com
//		Search for smart tv
//		create xpath to retrieve the name of all the products and store in list
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
		Actions a = new Actions(driver);
//		a.moveToElement(searchbox).click().sendKeys("Smart Tv").keyDown(Keys.ENTER).build().perform();
//		List<WebElement> alldata = driver.findElements(By.cssSelector(
//				"a[class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal'] span"));
//		for (WebElement printdata : alldata) {
//			System.out.println(printdata.getText());
//			
//		}
		
		searchbox.sendKeys("Smart");
		Thread.sleep(2000);
		a.sendKeys(Keys.ARROW_DOWN).build().perform();
//		List<WebElement> searchdata = driver.findElements(By.cssSelector("div[class='s-suggestion-container']"));
//		for (WebElement singledata : searchdata) {
//			a.moveToElement(searchbox).click().keyDown(Keys.ARROW_DOWN);
//			if(singledata.getText().equalsIgnoreCase(searchbox.getText()))
//			{
//				searchbox.click();
//			}
//			}

	}

}
