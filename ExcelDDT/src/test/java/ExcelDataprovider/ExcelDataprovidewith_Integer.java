package ExcelDataprovider;

import java.io.FileInputStream;

import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class ExcelDataprovidewith_Integer {
    DataFormatter format = new DataFormatter(); // Formatter for Excel data

    @Test(dataProvider = "getdata")
    public void testdata(String firstname, String lastname, int rollno) {
        System.out.println(firstname + "  " + lastname + "  " + rollno);
    }

    @DataProvider
    public Object[][] getdata() throws IOException {
        FileInputStream file = new FileInputStream("D:\\Document\\exceldatadriven.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);

        int NumberOfRows = sheet.getPhysicalNumberOfRows();
        int NumberOfColumns = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[NumberOfRows - 1][NumberOfColumns];

        for (int i = 0; i < NumberOfRows - 1; i++) {
            XSSFRow row = sheet.getRow(i + 1);
            for (int j = 0; j < NumberOfColumns; j++) {
                XSSFCell cell = row.getCell(j);
                if (j == 2) { // Assuming rollno is the third column (index 2)
                    data[i][j] = Integer.parseInt(format.formatCellValue(cell)); // Convert String to int
                } else {
                    data[i][j] = format.formatCellValue(cell); // Keep as String for other columns
                }
            }
        }

        workbook.close();
        file.close();
        return data;
    }
}



