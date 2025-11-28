package interview.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basic_Selenium {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// FileUtils.copyFile(source, new File(System.getProperty("user.dir") +
		// "\\reports\\" + "facebook.png"));
		FileUtils.copyFile(source,
				new File("C:\\Users\\ACW\\Eclipseworkspacenew\\Interview_Automation\\reports\\" + "facebook1.png"));
		//C:\Users\ACW\Eclipseworkspacenew\Interview_Automation\reportsfacebook1.png
		//👉 There is no \\ between reports and the file name, so actually the real path becomes wrong (it misses \).
		/*System.getProperty("user.dir")

Returns the current project directory path.

Example:
If your project is in:
C:\Users\Antony\ecommerceProject
Then System.getProperty("user.dir") will print exactly this path.

📁 + "\\reports\\"

This adds a folder named reports inside your project.

Final folder path will look like:
C:\Users\Antony\ecommerceProject\reports\

🖼️ "facebook.png"

This is the name of the screenshot file to be saved.*/
		String property = System.getProperty("user.dir");
		System.out.println(property);

	}

}
