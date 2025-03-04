package ExcelDataprovider;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExDD {
	@Test
	public void getdata() throws IOException {
		FileInputStream file = new FileInputStream("D:\\Document\\exceldatadriven.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		int numberOfSheets = workbook.getNumberOfSheets();
		System.out.println(numberOfSheets);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int NumberOfRows = sheet.getPhysicalNumberOfRows();// to find num of rows in a sheet
		System.out.println("NumberOfRows=" + NumberOfRows);
		XSSFRow row = sheet.getRow(0);

		int lastRowNum = row.getLastCellNum(); // if we find the lastrownumber in a row we can find the num of col
		System.out.println(lastRowNum);
		System.out.println(sheet.getLastRowNum());
		Object[][] data = new Object[NumberOfRows][lastRowNum];// first row is the header so we don't need that so
																// numberofrows-1 so the index start from the 2nd row
																// which is index 1 
		for (int i = 1; i < NumberOfRows; i++) {
			row = sheet.getRow(i);
			for (int j = 0; j < lastRowNum; j++) {
				System.out.println(row.getCell(j));
			}
		}
//		return data;

	}

}
