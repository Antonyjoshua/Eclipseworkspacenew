package com.auto;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Youtube {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.youtube.com/");
		System.out.println(driver.getCurrentUrl());
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.equals("https://www.youtube.com/")) {
			System.out.println("YouTube URL loaded successfully.");
		} else {
			System.out.println("Unexpected URL: " + currentUrl);
		}
		/*
		 * WebElement element =
		 * driver.findElement(By.className("ytSearchboxComponentInputBox"));
		 * 
		 * element is a WebElement object. It represents the actual element found on the
		 * page, so you can interact with it (click, type, read text, etc.).​
		 * 
		 * By.className("ytSearchboxComponentInputBox")
		 * 
		 * This is a locator, specifically a By locator. It is used by Selenium to find
		 * an element (or elements) with the specified class name on the page. On its
		 * own, it's just a way to describe where and how to find the element, not the
		 * element itself.
		 */
		WebElement element = driver.findElement(By.className("ytSearchboxComponentInputBox"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement searchBar = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.className("ytSearchboxComponentInputBox")));

		if (searchBar.isDisplayed()) {
			System.out.println("Search bar present: definitely landed on YouTube homepage.");
		} else {
			System.out.println("Search bar not found: may not be on the correct page.");
		}

	}

}
