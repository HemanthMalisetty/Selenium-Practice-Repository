package test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import test.driverUtil.DriverFactory;

public class NaukriTest extends DriverFactory {
    @Test
    public void naukriTest() {
        driver.findElement(By.xpath("//button[@title = 'I am a Professional']")).click();
        driver.findElement(By.xpath("//input[@name = 'expYear']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data='ddYears']//ul[@class='droopeCont listing']//span[text()='5']")));
        driver.findElement(By.xpath("//div[@data='ddYears']//ul[@class='droopeCont listing']//span[text()='5']")).click();
        driver.findElement(By.xpath("//input[@name = 'expMonth']")).click();
        driver.findElement(By.xpath("//div[@data='ddMonths']//ul[@class='droopeCont listing']//span[text()='5']")).click();
    }
}
