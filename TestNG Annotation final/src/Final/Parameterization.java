package Final;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameterization {

	@BeforeClass
	public void checkclass() {
		System.out.println("checkingclass");
		

	}
	//need to run this class from testng xml file to pass the value to this method
	@Parameters({"Username","Username2"})
	@BeforeMethod
	public void check(String name1, String name2) {
		System.out.println(name1 + name2);
		

	}
	@Test(dataProvider = "getdata")
	public void multipletc(String name, String password) {
		System.out.println(name);
		System.out.println(password);

	}

	@DataProvider
	public Object[][] getdata() {
		// 3 combination- firstusername, password with good credit points
		// secondusername, password with no credit point
		// thirdusername, password with fradulent credit history
		// first array box says the total sets of datas which is row and second says
		// number of columns which is number of datas sending
		Object[][] mda = new Object[3][2];
		// columns in the rows are nothing but values for that particular combination
		mda[0][0] = "Antony";
		mda[0][1] = "welcome@123";

		mda[1][0] = "joshua";
		mda[1][1] = "welcome@123";

		mda[2][0] = "mercy";
		mda[2][1] = "welcome@123";
		return mda;// now the mda object contains all the value so the return type is array of
					// object

	}

}
