package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import test.driverUtil.DriverFactory;

public class FileUploadGuru extends DriverFactory {
    @Test
    public void fileUploadTest() throws InterruptedException {
        //driver.findElement(By.xpath("//input[@id = 'uploadfile_0']")).sendKeys("C:\\Users\\heman\\Desktop\\delete.png");
        String flPath = "/Users/Manish/Desktop/unnamed.png";
        WebElement chooseFile = driver.findElement(By.cssSelector("#uploadfile_0"));
        chooseFile.sendKeys(flPath);
        Thread.sleep(3000);
    }
}
