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
import org.testng.annotations.Test;

public class Exceldriven_test {
   @Test
	public ArrayList<String> getdata(String name) throws IOException
	{
        ArrayList<String> a= new ArrayList<String>();
		FileInputStream fis=new FileInputStream("C:\\Users\\ACW\\Documents\\DTTDEMO.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);

		int sheets=workbook.getNumberOfSheets();
		for(int i=0;i<sheets;i++)
		{
		if(workbook.getSheetName(i).equalsIgnoreCase("ExcelDDT"))
		{
		XSSFSheet sheet=workbook.getSheetAt(i);
		System.out.println(workbook.getSheetAt(i).getSheetName());
		Iterator<Row> row = sheet.rowIterator();
		Row nextrow = row.next();
		Iterator<Cell> cell = nextrow.cellIterator();
		int k=0;
		int column=0;
		while(cell.hasNext())
		{
			Cell nextcell = cell.next();
			if(nextcell.getStringCellValue().equalsIgnoreCase("Name"))
			{
				column=k;
			}
			k++;
		}
		System.out.println("Column index for 'Name': "+column);
		while(row.hasNext())
		{
			Row desiredrow = row.next();
			Cell desiredcell = desiredrow.getCell(column);
			//System.out.println(desiredrow.getCell(column).getStringCellValue());
			//if(desiredrow.getCell(column).getStringCellValue().equals("Clair J."))
			 if (desiredcell != null && desiredcell.getCellType() == CellType.STRING 
                     && desiredcell.getStringCellValue().equalsIgnoreCase(name)) {
			{
				Iterator<Cell> getcellval = desiredrow.cellIterator();
				while(getcellval.hasNext())
				{
					Cell cellvalue = getcellval.next();
					if(cellvalue.getCellType()==CellType.STRING)
					{

					a.add(cellvalue.getStringCellValue());
					}
					else{

					a.add(NumberToTextConverter.toText(cellvalue.getNumericCellValue()));

					}
					}
					}


					}









					}
					}
					

					}
		return a;
	}
				}
