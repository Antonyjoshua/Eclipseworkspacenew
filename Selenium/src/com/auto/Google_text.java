package com.auto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_text {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.google.com/");
		String gt = driver.findElement(By.cssSelector("svg[class='lnXdpd']")).getAttribute("aria-label");
		System.out.println(gt);

	}

}
