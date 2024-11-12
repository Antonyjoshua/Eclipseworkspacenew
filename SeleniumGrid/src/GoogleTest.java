import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GoogleTest {
    // This annotation indicates that this method is a test method to be executed by JUnit
    @Test
    public void HomePageCheck() throws MalformedURLException, URISyntaxException {
        
        // Create an instance of DesiredCapabilities to define browser settings
        DesiredCapabilities cap = new DesiredCapabilities();
        
        // Set the browser name to Chrome
        cap.setBrowserName("chrome");
        
        // The following lines are commented out; they are alternative ways to set browser capabilities
        // cap.setCapability(CapabilityType.BROWSER_NAME, "chrome");
        // cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        
        // Create a RemoteWebDriver instance that connects to a Selenium Grid at the specified IP address
        // and uses the capabilities defined above (in this case, Chrome browser)
        WebDriver driver = new RemoteWebDriver(new URI("http://192.168.0.106:4444").toURL(), cap);
        
        // Open the Google homepage using the WebDriver
        driver.get("https://www.google.com/");
        
        // Get the title of the page and store it in the 'title' variable
        String title = driver.getTitle();
        
        // Print the title of the page to the console
        System.out.println(title);
        
        // Find the search input field by its 'name' attribute and send the text "Antony" to it
        driver.findElement(By.name("q")).sendKeys("Antony");
        
        // Close the browser after performing the test actions
        driver.close();
    }
}
