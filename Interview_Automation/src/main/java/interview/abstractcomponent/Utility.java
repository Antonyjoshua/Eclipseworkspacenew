package interview.abstractcomponent;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {
	
	WebDriver driver;
	
	public Utility(WebDriver driver)
	{
		this.driver= driver;
	}
	
	public void waitforelement(By FindBy) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));

	}
	public String screenshot(String testcase, WebDriver driver) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(System.getProperty("user.dir")+ "\\reports\\" + testcase+ ".png"));
		return (System.getProperty("user.dir")+"\\reports\\"+ testcase+ ".png");
	}
	//We return the screenshot file path to attach it to reports, logs, or reuse it later.

}
