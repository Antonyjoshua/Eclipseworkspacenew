package interview.testcases;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Interview_Amazon {
  public static void main(String[] args)
  {
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://www.amazon.com/");
	String currentUrl = driver.getCurrentUrl();
	String ExpectedUrl= "https://www.amazon.com/";
	Assert.assertEquals(currentUrl, ExpectedUrl);
	if(ExpectedUrl.equals(currentUrl))
	{
		System.out.println("The URL is lanuched successfully");
	}else
	{
		System.out.println("The URL is not lanunched successfully");
	}
	//driver.findElement(By.cssSelector("a-button-text")).click();
    String actualTitle= driver.getTitle();
    System.out.println(actualTitle);
    String ExpectedTitle="Amazon.com. Spend less. Smile more.";
    Assert.assertEquals(actualTitle, ExpectedTitle);
    if(ExpectedTitle.equals(actualTitle))
	{
		System.out.println("The URL is lanuched successfully");
	}else
	{
		System.out.println("The URL is not lanunched successfully");
	}
    
    
  }
}
