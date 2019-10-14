package test.driverUtil;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelReaderTWO {
    public static final String EXCELFILELOCATION = "./Data.xlsx";

    private static FileInputStream fis;
    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;
    private static XSSFRow row;

    public static void loadExcel() throws IOException {
        System.out.println("Loading Excel Data...");
        File file = new File(EXCELFILELOCATION);
        fis = new FileInputStream(file);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet("TestData");
        fis.close();
    }

    public static Map<String, String > getMapData() throws IOException {
        if (sheet == null){
            loadExcel();
        }
        Map<String, String> myMap = new HashMap<String, String>();

        for (int i = 1 ; i < sheet.getLastRowNum()+1 ; i++)
        {
            row = sheet.getRow(i);
            String keyCell = row.getCell(0).getStringCellValue();
            int colNumber = row.getLastCellNum();
            for (int j = 1 ; j < colNumber ; j++){
                String value = row.getCell(j).getStringCellValue();
                myMap.put(keyCell, value);
            }
        }
        return myMap;
    }
    public static String getValue(String key) throws IOException {
        return getMapData().get(key);
    }
    public static void main(String args[]) throws IOException {
        System.out.println(getValue("baseURL"));
    }
}
