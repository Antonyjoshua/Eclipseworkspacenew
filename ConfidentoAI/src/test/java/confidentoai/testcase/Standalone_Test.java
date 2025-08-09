package confidentoai.testcase;

import java.awt.event.ActionEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import confidentoai.pageobjects.Landingpage;
import confidentoai.pageobjects.List_User_Page;
import confidentoai.pageobjects.Organization_Page;

public class Standalone_Test {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		String verifyloginactual = "IntervieVR";
		String verifyuseractual = "List User";
		String username="antony18@yopmail.com";
		driver.manage().window().maximize();
//		driver.get("https://growadmin-test.confidentoai.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.findElement(By.name("email")).sendKeys("info@intervievr.com");
//		driver.findElement(By.name("password")).sendKeys("pass123");
//		driver.findElement(By.cssSelector(".btn.btn-primary.btn-block")).click();
//		String verifylogin = driver.findElement(By.xpath("//h3[text()='IntervieVR']")).getText();
		Landingpage lp = new Landingpage(driver);
		lp.url("https://growadmin-test.confidentoai.com/");
		lp.login("info@intervievr.com", "pass123");
		String verifylogin = lp.getmessage();
		System.out.println(verifylogin);
		Assert.assertEquals(verifylogin, verifyloginactual);
		lp.gotolistuser();

		List_User_Page lu = new List_User_Page(driver);
		String verifylistuser = lu.getverifyuser();
		System.out.println(verifylistuser);
		Assert.assertEquals(verifylistuser, verifyuseractual);

		lu.create_user("Antony", "Joshua", username, "Welcome@123", "07-30-2000", "9514084221",
				"No:15B, test case road, scenario nager, document 123456",
				"I'm a software tester with 2 years experience", "Indian","C:\\Users\\ACW\\Downloads\\profile.jpg");
		lu.gotoorganize();
		
		Organization_Page op = new Organization_Page(driver);
		String getorg = op.getorg();
		System.out.println(getorg);
		Assert.assertEquals(getorg, "Organization List");
		Thread.sleep(3000);
		op.create_org("antony1", "grp3");
	}

}
