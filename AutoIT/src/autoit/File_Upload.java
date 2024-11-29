package autoit;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class File_Upload {

	public static void main(String[] args) throws InterruptedException, IOException, AWTException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ilovepdf.com/pdf_to_jpg");
		driver.findElement(By.id("pickfiles")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\ACW USER\\Documents\\Upload.exe");
    


	}

}
