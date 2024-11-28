package autoit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Authentication_popup {

	public static void main(String[] args) {
		// selenium automate only web browser. If suppose we want to upload a file from
		// our local. To automate that we need an external software

		WebDriver driver = new ChromeDriver();
		// Window pop-up ask username and password to signin which we cannot inspect
		// Handling window authentication popup we need to use the below syntax
		// http://username:password@website.com
		driver.get("http://admin:admin@the-internet.herokuapp.com/");
		// will opening the page itself it will send the password and username to signin
		driver.findElement(By.linkText("Basic Auth")).click();

	}

}
