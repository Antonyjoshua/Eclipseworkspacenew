package ExcelDataprovider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {
	// The DataFormatter class in Apache POI is used to retrieve cell values as
	// formatted strings, regardless of the cell type (numeric, string, date, etc.).
	// It helps ensure that numbers, dates, and formulas appear as they do in Excel
	// instead of their raw underlying values.
	DataFormatter format = new DataFormatter();

	@Test(dataProvider = "getdata")
	public void testdata(String firstname, String lastname, String rollno) {
		System.out.println(firstname + "  " + lastname + "  " + rollno);

	}

	@DataProvider()
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
		FileInputStream file = new FileInputStream("D:\\Document\\exceldatadriven.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		int numberOfSheets = workbook.getNumberOfSheets();
		System.out.println(numberOfSheets);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int NumberOfRows = sheet.getPhysicalNumberOfRows();// to find num of rows in a sheet
		System.out.println(NumberOfRows);
		XSSFRow row = sheet.getRow(0);
		int lastRowNum = row.getLastCellNum(); // if we find the lastrownumber in a row we can find the num of col
		System.out.println(lastRowNum);
		System.out.println(sheet.getLastRowNum());
		Object[][] data = new Object[NumberOfRows - 1][lastRowNum]; // numberofrows-1 because noofrows is 4, we don't
																	// need header so 3 is enough
		for (int i = 0; i < NumberOfRows-1; i++) {
			row = sheet.getRow(i+1);
			// The whole row will be captured and placed in the row reference variable.
			for (int j = 0; j < lastRowNum; j++) {

				XSSFCell cell = row.getCell(j);
				data[i][j] = format.formatCellValue(cell);
//				data[i][j] = row.getCell(j);
				// Issues with Your Current Code
//				TestNG expects Object[][], but XSSFCell is returned
//
//				row.getCell(j) returns an XSSFCell, not the actual value.
//				TestNG expects Object[][] to contain actual data values, not XSSFCell objects.
//				Cannot Directly Assign XSSFCell to data[i][j]
//
//				testdata(String firstname, String lastname, int rollno) requires a String, String, int format.
//				Excel stores numbers as numeric values, so direct assignment fails.

			}

		}
		workbook.close();
		file.close();
		return data;

	}
}
