package SeleniumRealtime.Testcomponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import SeleniumRealtime.pageobjects.Landingpage;

public class BaseTest // this class will hold all the reusable content related to the test classes
{
	public WebDriver driver; //This driver is passing to all the classes

	public WebDriver initialize_Driver() throws IOException {
		// Globalproperty file where we can store which browser we want to execute
		// create a file with .properties extension. If we write any file with
		// .properties extension then using properties class in java, we will be able to
		// parse the file and extract all global parameter values
		// key= value in global properties file
		// properties class
		Properties prop = new Properties();
		// converting the properties file into inputstream object
		// System.getProperty("user.dir")- dynamically getting the path instead of using
		// our local path
		 FileInputStream fis = new FileInputStream(
		 System.getProperty("user.dir")+"\\src\\main\\java\\SeleniumRealtime\\resources\\Globaldata.properties");
//		FileInputStream fis = new FileInputStream(
//				"C:\\Users\\ACW USER\\eclipse-workspace\\RealTimeProject\\src\\main\\java\\SeleniumRealtime\\resources\\Globaldata.properties");

		prop.load(fis);
		// getting the value in the global property
		String browsername = prop.getProperty("browser");
		if (browsername.equals("Edge")) {
			driver = new EdgeDriver();
		} else if (browsername.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browsername.equals("firefox")) {
			// firefox
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;

	}

	public Landingpage launching_App() throws IOException {
		driver = initialize_Driver();
		Landingpage lp = new Landingpage(driver);// passing driver to the landing page constructor
		lp.url("https://rahulshettyacademy.com/client");
		return lp;

	}

}
