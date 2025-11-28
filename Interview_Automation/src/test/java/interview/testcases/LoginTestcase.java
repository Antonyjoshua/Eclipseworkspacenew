package interview.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import interview.TestCompenent.BaseTest;

public class LoginTestcase extends BaseTest {

	@Test
	public void login_withvalid()
	{
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		lp.validlogin(username, password);
		lp.validateHomepage();
		boolean validateHomepage = lp.validateHomepage();
		Assert.assertFalse(validateHomepage);
	}
}
