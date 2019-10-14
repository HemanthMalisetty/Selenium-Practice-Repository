package test;

import java.io.File;

public class JavaTest {
    public static void main(String args[])
    {
        getOsFileSeparator();
    }
    public static String getOsFileSeparator()
    {
        String ret = "";
        ret = File.separator;
        ret = System.getProperty("file.separator");
        ret = String.valueOf(File.separatorChar);

        System.out.println("Current OS file separator = " + ret);

        String filePath = "test" + ret + "dev2qa.txt";

        System.out.println("filePath = " + filePath);

        return ret;
    }
}
