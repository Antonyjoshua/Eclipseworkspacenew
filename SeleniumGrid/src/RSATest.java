import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class RSATest {

	@Test
	public void HomePageCheck() throws Exception {
		EdgeOptions options = new EdgeOptions();
		WebDriver driver = new RemoteWebDriver(new URI("http://192.168.0.106:4444/wd/hub").toURL(), options);
		driver.get("https://rahulshettyacademy.com/");
		String title = driver.getTitle();
		System.out.println(title);
		driver.quit();
	}

}
