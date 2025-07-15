import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Upload_download {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		String fruitname="Banana";
		String filename="C:\\Users\\ACW\\Downloads\\test.xlsx";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");
//		JavascriptExecutor js= (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement upload = wait.until(ExpectedConditions.elementToBeClickable(By.id("fileinput")));
//
//		Actions a = new Actions(driver);
//		a.scrollToElement(upload).click().perform();

//		WebElement download = driver.findElement(By.cssSelector("#downloadButton"));
//		Actions a = new Actions(driver);
//		wait.until(ExpectedConditions.elementToBeClickable(download));
//		a.scrollToElement(download).click().build().perform()
//		System.out.println("run");
//		driver.findElement(By.cssSelector("#downloadButton")).click();
		driver.findElement(By.id("downloadButton")).click();
		//Edit excel
		int col=getColumnNumber(filename,"price");
		int row=getRowNumber(filename,"Apple");
		updateCell(filename,row,col,"599");
		
		//upload
		WebElement upload = driver.findElement(By.id("fileinput"));
		wait.until(ExpectedConditions.elementToBeClickable(upload));
		//We can upload the file using sendkeys if the upload element has input type= file as a attribute
		upload.sendKeys("C:\\Users\\ACW\\Downloads\\test.xlsx");// while giving the file path don't forget to add
																	// the file extension
		WebElement toaster = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']/div[2]"));
		wait.until(ExpectedConditions.visibilityOf(toaster));
		
		String successmsg = toaster.getText();
		
		System.out.println(successmsg);
		
		//Assert.assertEquals(actual, expected, message) – This helps identify failures clearly.
		
		Assert.assertEquals("Updated Excel Data Successfully.",successmsg);
		
		wait.until(ExpectedConditions.invisibilityOf(toaster));
		
		String pricecolumn = driver.findElement(By.xpath("//div[text()='Price']")).getAttribute("data-column-id");//finding the price column and pass it to our xpath dynamically
		String actualvalue = driver.findElement(By.xpath("//div[text()='"+fruitname+"']/parent::div/parent::div/div["+pricecolumn+"]")).getText();
		System.out.println(actualvalue);
		Assert.assertEquals( "15", actualvalue);
	}

	public static void updateCell(String filename, int row, int col, String value) {
		// TODO Auto-generated method stub
		
	}

	public static int getRowNumber(String filename, String row) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static int getColumnNumber(String filename, String column) {
		// TODO Auto-generated method stub
		return 0;
	}

}
