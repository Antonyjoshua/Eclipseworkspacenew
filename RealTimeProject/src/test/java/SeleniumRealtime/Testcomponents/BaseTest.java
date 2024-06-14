package SeleniumRealtime.Testcomponents;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.bouncycastle.util.encoders.UTF8;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import SeleniumRealtime.pageobjects.Landingpage;

public class BaseTest // this class will hold all the reusable content related to the test classes
{
	public WebDriver driver; // This driver is passing to all the classes. This instance can navigate through
								// different pages represented by different page objects within the test case.
	public Landingpage lp;// landing page object

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
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\main\\java\\SeleniumRealtime\\resources\\Globaldata.properties");
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

	// any class that inherits this class, the before and after method in this class
	// becomes their class methods
	// If we use groups concept in testng the before and aftermethod will gets
	// failed because it except to add the group name in these annotations as well.
	// If we add name, it will only run for the particular group since it is common
	// to all test methods, we need to run always run to the before and after
	// testmethods
	@BeforeMethod(alwaysRun = true)
	public void launching_App() throws IOException {
		driver = initialize_Driver();
		lp = new Landingpage(driver);// passing driver to the landing page constructor
		lp.url("https://rahulshettyacademy.com/client");
		// return lp- return the landingpage instance if you want to call this method in
		// the test class, when @beforemethod annotation not used
	}

	@AfterMethod(alwaysRun = true)
	public void close() {
		driver.close();

	}

	public List<HashMap<String, String>> getJsonDatatoMap(String filepath) throws IOException {
		// read json to string
		//fileutils- Utility that scans the json or any file and create hashmap out of it
		// filepath- path of the json file, we sending this as an argument to make this
		// method as generic, so that any json file can run this method
		String readFileToString = FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);
		// Convert the JSON string into a HashMap using Jackson's ObjectMapper.
		ObjectMapper mapper = new ObjectMapper();
		// this will store the json data to hash map as a list
		// {{dataset},{dataset1}}
		List<HashMap<String, String>> data = mapper.readValue(readFileToString,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;

	}

}
