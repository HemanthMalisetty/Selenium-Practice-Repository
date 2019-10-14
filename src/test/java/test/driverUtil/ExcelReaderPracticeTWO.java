package test.driverUtil;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelReaderPracticeTWO {
    private static String flPath = "./Data.xlsx";
    private static Workbook workbook;
    private static FileInputStream fis;
    private static Sheet sheet;
    private static Row row;

    public static Map<String, String> readExcelsheet() throws IOException {
        Map<String, String> myMap = new HashMap<>();
        fis = new FileInputStream(flPath);
        if (flPath.endsWith(".xlsx")){
            workbook = new XSSFWorkbook(fis);
        }else if (flPath.endsWith(".xlx")){
            workbook = new HSSFWorkbook(fis);
        }
        sheet = workbook.getSheet("TestData");
        for (int i = 1 ; i < sheet.getLastRowNum() ; i++){
            row = sheet.getRow(i);
            String key = row.getCell(0).getStringCellValue();
            for (int j = 1 ; j < row.getLastCellNum(); j++){
                row = sheet.getRow(j);
                String value = row.getCell(1).getStringCellValue();
                myMap.put(key, value);
            }
        }
        return myMap;
    }
    public static void main(String args[]) throws IOException {
        System.out.println(readExcelsheet().get("baseURL"));
    }

}
