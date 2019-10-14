package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import test.driverUtil.DriverFactory;

public class Playgame extends DriverFactory {
    @Test
    public void playGameTest() throws InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(), 'Play')]")).click();
        driver.switchTo().frame(0);
        WebElement begin = driver.findElement(By.xpath("//a[text()='Begin']"));
        begin.click();
        Thread.sleep(5000);
    }
}
