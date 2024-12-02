package autoit;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class File_Upload {

	// Runtime.getRuntime()

//This retrieves the current Java runtime environment.
//The runtime environment provides methods to interact with the Java Virtual Machine (JVM), such as executing external processes, interacting with system properties, or managing memory.
//.exec(String command)
//
//The exec method is part of the Runtime class and is used to execute a system command or an external program.
//The command can be:
//The full path to an executable file (as in this case).
//A command-line instruction (e.g., cmd.exe /c dir).
//"C:\\Users\\ACW USER\\Documents\\Upload.exe"
//
//This is the full file path to the executable Upload.exe.
//The double backslashes (\\) are used because backslashes (\) are escape characters in Java strings.
//Purpose in Context
//
//This line runs the Upload.exe AutoIt script, which automates the process of interacting with a system file upload dialog.
//For example, it might:
//Click the "Browse" button.
//Select a file from a specific folder.
//Click "Open" to confirm the file upload.
//Why Use This?
//Selenium cannot directly handle OS-level dialogs like file upload windows, as they are outside the browser. By using an external tool (like AutoIt), you can automate these interactions.
//
//Execution Flow
//When this line runs:
//
//Java hands control to the operating system.
//The OS executes Upload.exe.
//The script in Upload.exe performs the predefined actions (e.g., interacting with the file upload dialog).
//Example Scenario
//Suppose your web page has an "Upload File" button, and clicking it opens a file chooser dialog. Selenium can't interact with this dialog directly, but Upload.exe can handle the dialog to:
//
//Select the file.
//Confirm the upload.
	public static void main(String[] args) throws InterruptedException, IOException, AWTException {
		WebDriver driver = new ChromeDriver();
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
		// Using this method run only is your system since the path is the dynamic so it
		// code won't run in jenkins or in different system
		File f = new File("C:\\Users\\ACW USER\\Downloads\\ilovepdf_pages-to-jpg.zip");
		if (f.exists())// Check whether the file exist in the path
		{
			System.out.println("File downloaded successfully");
		} else {
			System.out.println("Error");
		}

	}

}
