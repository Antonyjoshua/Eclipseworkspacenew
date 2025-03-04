//Identify Name coloum by scanning the entire 1st row
	//once coloumn is identified then scan entire Name coloum to identify clair row
	//after you grab clair row = pull all the data of that row and feed into test
package practice.com;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldriven {
	public ArrayList<String> getdata(String name) throws IOException {
		ArrayList<String> list = new ArrayList<String>();
		FileInputStream file = new FileInputStream("C:\\Users\\ACW USER\\Documents\\DTTDEMO.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		int numberOfSheets = workbook.getNumberOfSheets();
		System.out.println(numberOfSheets);
		for (int i = 0; i < numberOfSheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("ExcelDDT")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				System.out.println(workbook.getSheetAt(i).getSheetName());
				Iterator<Row> row = sheet.rowIterator();
				Row nextrow = row.next();
				Iterator<Cell> cell = nextrow.cellIterator();
				int k = 0;
				int column = 0;
				while (cell.hasNext()) {
					Cell nextcell = cell.next();
					if (nextcell.getStringCellValue().equalsIgnoreCase("Name")) {
						column = k;
					}
					k++;
				}
				System.out.println("Column index for 'Name': "+column);
				while (row.hasNext()) {
					Row desiredrow = row.next();
					if (desiredrow.getCell(column).getStringCellValue().equalsIgnoreCase(name)) {
						Iterator<Cell> cellIterator2 = desiredrow.cellIterator();
//						while (cellIterator2.hasNext()) {
//							list.add(cellIterator2.next().getStringCellValue());
//
//						}
						while (cellIterator2.hasNext()) {
							Cell c = cellIterator2.next();
							if (c.getCellType() == CellType.STRING) {
								list.add(c.getStringCellValue());
							} else {
								list.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}

						}
					}
				}
			}
			
		}
		return list;

	}
}