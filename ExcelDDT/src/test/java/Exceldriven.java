import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldriven {

	public static void main(String[] args) throws IOException {
		FileInputStream file = new FileInputStream("C:\\Users\\ACW USER\\Documents\\DTTDEMO.xlsx"); // Open the Excel
																									// file for reading.
		XSSFWorkbook workbook = new XSSFWorkbook(file); // Load the workbook from the file.
		int numberOfSheets = workbook.getNumberOfSheets(); // Get the total number of sheets in the workbook.
		System.out.println(numberOfSheets); // Print the number of sheets.
		for (int i = 0; i < numberOfSheets; i++) { // Loop through all sheets in the workbook.
			if (workbook.getSheetName(i).equalsIgnoreCase("ExcelDDT")) { // Check if the sheet name matches "ExcelDDT".
				XSSFSheet sheet = workbook.getSheetAt(i); // Get the matching sheet.
				System.out.println(workbook.getSheetAt(i).getSheetName()); // Print the name of the matching sheet.
				Iterator<Row> rows = sheet.rowIterator(); // Get an iterator for the rows in the sheet.
				Row firstrow = rows.next(); // Get the first row (header row).
				Iterator<Cell> cells = firstrow.cellIterator(); // Get an iterator for the cells in the first row.
				int k = 0; // Initialize the column counter.
				int column = 0; // Initialize the column index for "Name".
				while (cells.hasNext()) { // Loop through all cells in the first row.
					Cell value = cells.next(); // Get the next cell.
					if (value.getStringCellValue().equalsIgnoreCase("Name")) { // Check if the cell value is "Name".
						column = k; // Store the index of the "Name" column.
					}
					k++; // Increment the column counter.
				}
				System.out.println(column); // Print the column index for "Name".
				while (rows.hasNext()) { // Loop through the remaining rows.
					Row desiredrow = rows.next(); // Get the next row.
					if (desiredrow.getCell(column).getStringCellValue().equalsIgnoreCase("Clair J.")) { // Check if the
																										// cell in the
																										// "Name" column
																										// matches
																										// "Clair J.".
						Iterator<Cell> desiredcell = desiredrow.cellIterator(); // Get an iterator for cells in the
																				// matching row.
						while (desiredcell.hasNext()) { // Loop through all cells in the matching row.
							System.out.println(desiredcell.next().getStringCellValue()); // Print the cell values of the
																							// matching row.
						}
					}
				}
			}
		}
	}
}