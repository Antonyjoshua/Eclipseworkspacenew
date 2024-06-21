package framework.Testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import framework.pageobjects.Landingpage;

public class BaseTest {
	public WebDriver driver;
	public Landingpage lp;// landing page object

	public WebDriver initialize_Driver() throws IOException {

		Properties prop = new Properties();

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\main\\java\\framework\\resources\\Globaldata.properties");
		

		prop.load(fis);
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

	@BeforeMethod(alwaysRun = true)
	public void launching_App() throws IOException {

		driver = initialize_Driver();
		lp = new Landingpage(driver);
		lp.url("https://rahulshettyacademy.com/client");

	}

	@AfterMethod(alwaysRun = true)
	public void close() {
		driver.close();

	}

	public String getScreenShot(String testcasename, WebDriver driver) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(System.getProperty("user.dir") + "\\reports\\" + testcasename + ".png"));
		return System.getProperty("user.dir") + "\\reports\\" + testcasename + ".png";
	}

	public List<HashMap<String, String>> getJsonDatatoMap(String filepath) throws IOException {

		String readFileToString = FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);

		ObjectMapper mapper = new ObjectMapper();

		List<HashMap<String, String>> data = mapper.readValue(readFileToString,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;

	}

}
