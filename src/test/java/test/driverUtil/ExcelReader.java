package test.driverUtil;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelReader {
    public static final String EXCELFILELOCATION = "C:\\Users\\heman\\IdeaProjects\\mavenproject\\Data.xlsx";

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

    public static Map<String, Map<String, String >> getMapData() throws IOException {
        if (sheet == null){
            loadExcel();
        }
        Map<String, Map<String, String>> superMap = new HashMap<String, Map<String, String>>();
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
            superMap.put("master", myMap);
        }
        System.out.println(myMap);
        return superMap;
    }
    public static String getValue(String key) throws IOException {
        Map<String, String> myVal = getMapData().get("master");
        return myVal.get(key);
    }
    public static void main(String args[]) throws IOException {
        System.out.println(getValue("baseURL"));
    }
}
