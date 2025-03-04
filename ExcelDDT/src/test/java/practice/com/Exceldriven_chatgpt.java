package practice.com;


	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.Iterator;
	import org.apache.poi.ss.usermodel.*;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.apache.poi.ss.util.NumberToTextConverter;

	public class Exceldriven_chatgpt {

	    public ArrayList<String> getData(String name) throws IOException {
	        ArrayList<String> list = new ArrayList<>();
	        
	        // Load the Excel file
	        FileInputStream file = new FileInputStream("C:\\Users\\ACW USER\\Documents\\DTTDEMO.xlsx");
	        XSSFWorkbook workbook = new XSSFWorkbook(file);
	        
	        int numberOfSheets = workbook.getNumberOfSheets();
	        
	        for (int i = 0; i < numberOfSheets; i++) {
	            if (workbook.getSheetName(i).equalsIgnoreCase("ExcelDDT")) {
	                XSSFSheet sheet = workbook.getSheetAt(i);
	                
	                // Get the first row (header)
	                Iterator<Row> rows = sheet.rowIterator();
	                Row firstRow = rows.next();
	                
	                // Identify the "Name" column
	                Iterator<Cell> cells = firstRow.cellIterator();
	                int k = 0;
	                int column = 0;
	                
	                while (cells.hasNext()) {
	                    Cell cell = cells.next();
	                    if (cell.getStringCellValue().equalsIgnoreCase("Name")) {
	                        column = k;
	                        break;
	                    }
	                    k++;
	                }

	                if (column == -1) {
	                    System.out.println("Column 'Name' not found!");
	                    workbook.close();
	                    return list;
	                }

	                // Iterate through rows to find the matching name
	                while (rows.hasNext()) {
	                    Row currentRow = rows.next();
	                    Cell nameCell = currentRow.getCell(column);

	                    // Null check and ensure the cell contains a string
	                    if (nameCell != null && nameCell.getCellType() == CellType.STRING 
	                        && nameCell.getStringCellValue().equalsIgnoreCase(name)) {
	                        
	                        Iterator<Cell> rowCells = currentRow.cellIterator();
	                        while (rowCells.hasNext()) {
	                            Cell cell = rowCells.next();
	                            
	                            if (cell.getCellType() == CellType.STRING) {
	                                list.add(cell.getStringCellValue());
	                            } else if (cell.getCellType() == CellType.NUMERIC) {
	                                list.add(NumberToTextConverter.toText(cell.getNumericCellValue()));
	                            }
	                        }
	                    }
	                }
	            }
	        }
	        
	        workbook.close();
	        return list;
	    }
	}
	

	 