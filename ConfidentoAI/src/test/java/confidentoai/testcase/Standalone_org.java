package confidentoai.testcase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import confidentoai.pageobjects.Landingpage;
import confidentoai.pageobjects.Organization_Page;

public class Standalone_org {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Landingpage lp = new Landingpage(driver);
		lp.url("https://growadmin-test.confidentoai.com/");
		lp.login("info@intervievr.com", "pass123");
		String verifylogin = lp.getmessage();
		System.out.println(verifylogin);
		Assert.assertEquals(verifylogin, "IntervieVR");
		lp.gotoorganize();

		Organization_Page op = new Organization_Page(driver);
		String getorg = op.getorg();
		System.out.println(getorg);
		Assert.assertEquals(getorg, "Organization List");
		op.create_org("antony10", "grp3");
	}
}
