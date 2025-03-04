package CodeExplain;

import java.io.FileInputStream; // Imports for handling files
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.*; // Apache POI for Excel handling
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.util.NumberToTextConverter;

public class DDTexplain {
	// Method to retrieve data from an Excel sheet based on a given name
	public ArrayList<String> getdata(String name) throws IOException {
		ArrayList<String> list = new ArrayList<String>(); // Stores extracted data

		// Opens the Excel file for reading
		FileInputStream file = new FileInputStream("C:\\Users\\ACW USER\\Documents\\DTTDEMO.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file); // Loads the workbook

		int numberOfSheets = workbook.getNumberOfSheets(); // Gets total sheets in the workbook
		System.out.println(numberOfSheets); // Prints the sheet count

		// Loops through all sheets to find the desired sheet "ExcelDDT"
		for (int i = 0; i < numberOfSheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("ExcelDDT")) {
				XSSFSheet sheet = workbook.getSheetAt(i); // Gets the target sheet
				System.out.println(workbook.getSheetAt(i).getSheetName()); // Prints the sheet name

				Iterator<Row> rowIterator = sheet.rowIterator(); // Iterates through rows= Creates an iterator to go
																	// through all the rows of the sheet.

				Row nextrow = rowIterator.next(); // Retrieves the first row (header row)
				Iterator<Cell> cellIterator = nextrow.cellIterator(); // Iterates through header cells

				int k = 0;
				int column = 0; // Variable to store column index of "Name"

				// Identifies the column index where "Name" is located
				while (cellIterator.hasNext()) {
					Cell nextcell = cellIterator.next();
					if (nextcell.getStringCellValue().equalsIgnoreCase("Name")) {
						column = k; // Stores the index of the "Name" column
					}
					k++;
				}
				System.out.println(column); // Prints the column index

				// Iterates through the remaining rows to find the matching name
				while (rowIterator.hasNext()) {
					Row desiredrow = rowIterator.next();

					// If the cell in the "Name" column matches the given name
					if (desiredrow.getCell(column).getStringCellValue().equalsIgnoreCase(name)) {
						Iterator<Cell> cellIterator2 = desiredrow.cellIterator(); // Iterates through the cells in that
																					// row

						// Extracts and adds cell values to the list (handles both text and numbers)
						while (cellIterator2.hasNext()) {
							Cell c = cellIterator2.next();
							if (c.getCellType() == CellType.STRING) {
								list.add(c.getStringCellValue()); // Adds string values
							} else {
								list.add(NumberToTextConverter.toText(c.getNumericCellValue())); // Converts numbers to
																									// text and adds
							}
						}
					}
				}
			}
		}
		return list; // Returns the extracted data
	}
}
