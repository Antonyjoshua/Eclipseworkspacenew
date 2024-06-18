package com.pratice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_demo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://yopmail.com/en/wm");
		String title = driver.getTitle();
		System.out.println(title);
		

	}

}
