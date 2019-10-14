package test.driverUtil;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.reporters.jq.Main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelReaderThree {
    private static final String flpath = "./Data.xlsx";
    private static Workbook workbook;
    private static FileInputStream fis;

    public static Map<String, String> loadExcel() throws IOException {
        fis = new FileInputStream(flpath);
        if (flpath.endsWith(".xlsx")){
            workbook = new XSSFWorkbook(fis);
        }
        else if (flpath.endsWith(".xls"))
        {
            workbook = new HSSFWorkbook(fis);
        }
        Sheet sheet = workbook.getSheet("TestData");
        Map<String, String> myMap = new HashMap<>();
        for (int i = 1 ; i < sheet.getLastRowNum() ; i++){
            Row row = sheet.getRow(i);
            String key = row.getCell(0).getStringCellValue();

            for (int  j = 1 ; j < row.getLastCellNum() ; j++){
                row = sheet.getRow(j);
                String value = row.getCell(1).getStringCellValue();
                myMap.put(key, value);
            }
        }
        return myMap;
    }
    public static void main(String args[]) throws IOException {
        Map<String, String> excelData = loadExcel();
        System.out.println(excelData.get("baseURL"));
    }

}
