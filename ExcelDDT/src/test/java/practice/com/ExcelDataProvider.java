package practice.com;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {
	@Test(dataProvider = "getdata")
	public void testdata(String firstname, String lastname, int rollno) {
		System.out.println(firstname + lastname + rollno);

	}

	@DataProvider
	public Object[][] getdata() throws IOException {
		// object is superset of all datatypes. we use object because it support all
		// type of datatypes, if our data contains both integer and string we can use
		// this
		// Object[][] → A two-dimensional array that can store any type of data (String,
		// Integer, etc.).
//		new Object[3][3] → Creates an array with 3 rows and 3 columns.
//		It is useful in TestNG's @DataProvider, as it allows storing multiple types of data in a single array.
//		Visualization of the Array
//		Index	First Name (String)	Last Name (String)	Roll Number (int)
//		0	"Antony"	"Joshua"	1
//		1	"Antony"	"Joshua"	2
//		2	"Antony"	"Joshua"	3
//		Object[][] data = new Object[3][3];
//		data[0][0]="Antony";
//		data[0][1]="Joshua";
//		data[0][2]=1;
//		data[1][0]="Antony";
//		data[1][1]="Joshua";
//		data[1][2]=2;
//		data[2][0]="Antony";
//		data[2][1]="Joshua";
//		data[2][2]=3;
//		Object[][] data = { { "Antony", "Joshua", 1 }, { "Antony", "Joshua", 2 }, { "Antony", "Joshua", 3 } };
		// instead of hardcording the data in our script and drive it from excel
		// {"Antony","Joshua",1} store each row data as an array
//	return data;
		FileInputStream file = new FileInputStream("D:\\Document\\exceldatadriver.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		int numberOfSheets = workbook.getNumberOfSheets();
		System.out.println(numberOfSheets);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int NumberOfRows = sheet.getPhysicalNumberOfRows();// to find num of rows in a sheet
		System.out.println(NumberOfRows);
		int lastRowNum = sheet.getLastRowNum(); // if we find the lastrownumber in a row we can find the num of col
		System.out.println(lastRowNum);
		Object[][] data = new Object[NumberOfRows - 1][lastRowNum];// first row is the header so we don't need that so
																	// numberofrows-1 so the index start from the 2 row
																	// which is index 0
		return data;

	}

}
