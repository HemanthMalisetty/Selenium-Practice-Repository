package test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import test.driverUtil.DriverFactory;

public class CRMPro extends DriverFactory {
    @Test
    public void crmProTest()  {
        driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys("miteshcrmpro");
        driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("P@55word");
        driver.findElement(By.xpath("//input[@value='Login']")).submit();
        driver.switchTo().frame(1);
        driver.findElement(By.xpath("//a[contains(text(), 'Logout')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
    }
}
