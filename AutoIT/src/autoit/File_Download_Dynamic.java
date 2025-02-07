package autoit;

import java.awt.AWTException;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class File_Download_Dynamic {
	public static void main(String[] args) throws InterruptedException, IOException, AWTException {
		String downloadpath = System.getProperty("user.dir") + "\\Download";
		System.out.println(downloadpath);

		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadpath);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.ilovepdf.com/pdf_to_jpg");
		driver.findElement(By.id("pickfiles")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\ACW USER\\Documents\\Upload.exe");
		WebElement convert = driver.findElement(By.id("processTaskTextBtn"));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(convert));
		convert.click();
		WebElement download = driver.findElement(By.cssSelector("div[class='downloader']"));
		w.until(ExpectedConditions.visibilityOf(download));
		download.click();
		Thread.sleep(5000);
		// Using this method run only is your system since the path is the dynamic so it
		// code won't run in jenkins or in different system
		File f = new File(downloadpath + "\\ilovepdf_pages-to-jpg.zip");
//		int waitTime = 20; // seconds
//		boolean fileExists = false;
//
//		for (int i = 0; i < waitTime; i++) {
//			if (f.exists()) {
//				fileExists = true;
//				break;
//			}
//			Thread.sleep(1000); // Wait 1 second
//		}
		if (f.exists())// Check whether the file exist in the path
		{
			System.out.println("File downloaded successfully");
			f.delete();
		} else {
			System.out.println("Error");
		}

	}
}
