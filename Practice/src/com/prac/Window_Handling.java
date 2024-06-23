package com.prac;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Window_Handling {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.partialLinkText("Free Access")).click();
		Set<String> windowHandles = driver.getWindowHandles();// returns all the windows
		Iterator<String> iterator = windowHandles.iterator();// iterating each module
		String pw = iterator.next();// parent window
		String cw = iterator.next();// child window
		driver.switchTo().window(cw);
		// String name =
		// driver.findElement(By.partialLinkText("mentor@rahulshettyacademy.com")).getText();
		// System.out.println(name);
		// When it finds "at", it splits the string at that point, removing "at" from
		// the resulting parts.
		// trim() method removes the spaces at the beginning and end of the string but
		// leaves the spaces between words intact.
		String name = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		System.out.println(name);
		driver.switchTo().window(pw);
		driver.findElement(By.id("username")).sendKeys(name);
	}

}
