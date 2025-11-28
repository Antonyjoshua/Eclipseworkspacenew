package interview.TestCompenent;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import interview.Page_Objects.LandingPage;

public class BaseTest {

	public WebDriver driver;
	public LandingPage lp;
	public Properties prop;

	@BeforeMethod
	public void launching_app() throws IOException
	{
		prop= new Properties();
		String path= System.getProperty("user.dir")+"\\src\\main\\java\\interview\\resourses\\GlobalData.properties";
		FileInputStream fil= new FileInputStream(path);
		prop.load(fil);
		String url = prop.getProperty("url");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		lp = new LandingPage(driver);
		lp.url(url);
		
	}

	@AfterMethod
	public void close() {
		driver.quit();
	}

}
