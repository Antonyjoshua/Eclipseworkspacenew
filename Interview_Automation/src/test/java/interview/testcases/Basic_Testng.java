package interview.testcases;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import interview.abstractcomponent.Utility;

public class Basic_Testng {
	
	@Test
	public void createAccount() throws IOException
	{
		System.out.println("test");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.facebook.com/");
//		TakesScreenshot ts= (TakesScreenshot) driver;
//		File source = ts.getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(source, new File(System.getProperty("user.dir")+ "//testngreport//" +"facebook.png"));
		Utility ss= new Utility(driver);
		String screenshot = ss.screenshot("createaccount", driver);
		System.out.println(screenshot);
		
		
	}
	

}
