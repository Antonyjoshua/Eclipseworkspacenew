import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldriven {

	public static void main(String[] args) throws IOException {
		FileInputStream file = new FileInputStream("C:\\Users\\ACW USER\\Documents\\DTTDEMO.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		int numberOfSheets = workbook.getNumberOfSheets();
		System.out.println(numberOfSheets);
		for (int i = 0; i < numberOfSheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("ExcelDDT")) {
				XSSFSheet sheet = workbook.getSheetAt(i); // sheet is a collection of rows
				System.out.println(workbook.getSheetAt(i).getSheetName());
				Iterator<Row> rows = sheet.rowIterator();// row is a collection of cells
				Row firstrow = rows.next();
				Iterator<Cell> cells = firstrow.cellIterator();
                int k=0;
                int column=0;
				while (cells.hasNext()) {
					Cell value = cells.next();
					if (value.getStringCellValue().equalsIgnoreCase("Name")) {
						column=k;
					}
					k++;
				}
				System.out.println(column);
			}

		}

	}

}
