package testng.com;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class ParallelBrowser {


	    ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	    @BeforeMethod
	    @Parameters("browser")
	    public void setUp(String browser) {
	        // Initialize the WebDriver based on the browser parameter
	        switch (browser) {
	            case "chrome":
	               
	                driver.set(new ChromeDriver());
	                break;
	            case "ie":
	                
	                driver.set(new EdgeDriver());
	                break;
	            default:
	                throw new IllegalArgumentException("Invalid browser specified: " + browser);
	        }
	    }

	    @Test
	    public void testExample() {
	        // Your test logic goes here using the driver.get() and other WebDriver methods
	        WebDriver currentDriver = driver.get();
	        currentDriver.get("https://google.com");
	        // Additional test steps...
	    }

	    @AfterMethod
	    public void tearDown() {
	        // Close the WebDriver instance
	        driver.get().quit();
	    }
	


	}


