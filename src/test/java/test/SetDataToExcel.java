package test;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class SetDataToExcel {
    @Test
    public void setDataToExcel() throws IOException {

        String filepath = "C:\\Users\\heman\\Desktop\\Demo.xlsx";
        File fl = new File(filepath);

        FileInputStream inputStream = new FileInputStream(fl);
        Workbook workbook = null;

        String fileExtentionName = filepath.substring(filepath.indexOf("."));
        if (fileExtentionName.equals(".xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (fileExtentionName.equals(".xls")) {
            workbook = new HSSFWorkbook(inputStream);
        }

        Sheet sheet = workbook.getSheetAt(0);

        Row newRow = sheet.createRow(0);

        Cell cell = newRow.createCell(0);

        cell.setCellValue("Hemanth");

        //Close input stream
        inputStream.close();

        //Create an object of FileOutputStream class to create write data in excel file
        FileOutputStream outputStream = new FileOutputStream(fl);

        //write data in the excel file
        workbook.write(outputStream);

        //close output stream
        outputStream.close();

    }
}
