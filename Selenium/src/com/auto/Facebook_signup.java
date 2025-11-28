package com.auto;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Facebook_signup {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		driver.findElement(By.name("firstname")).sendKeys("Antony");
		driver.findElement(By.name("lastname")).sendKeys("test");
		WebElement day = driver.findElement(By.name("birthday_day"));
        Select s= new Select(day);
        s.selectByValue("30");
        WebElement month = driver.findElement(By.name("birthday_month"));
        Select s1= new Select(month);
        s1.selectByValue("7");
        WebElement year = driver.findElement(By.name("birthday_year"));
        Select s2= new Select(year);
        s2.selectByVisibleText("2000");
        driver.findElement(By.xpath("//label[text()='Male']/input")).click();
        WebElement male = driver.findElement(By.xpath("//label[text()='Male']/input"));
        System.out.println(male.isSelected());
        driver.findElement(By.name("reg_email__")).sendKeys("antony@yopmail.com");
        driver.findElement(By.name("reg_passwd__")).sendKeys("Welcome@123");
        driver.findElement(By.name("websubmit")).click();
        /*| Method        | Checks for               | Typical Usage                            |
        | ------------- | ------------------------ | ---------------------------------------- |
        | isDisplayed() | Visibility on the page   | Before click/typing                      |
        | isEnabled()   | Usability (not disabled) | Before click/typing/submit               |
        | isSelected()  | Selected/checked state   | Before toggling checkbox/radio/drop-down |*/
        //These help prevent ElementNotInteractableException and write bulletproof tests for modern web UIs.
        
        

	}

}
