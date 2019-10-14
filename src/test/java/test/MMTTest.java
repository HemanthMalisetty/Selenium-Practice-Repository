package test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import test.driverUtil.DriverFactory;

public class MMTTest extends DriverFactory {
    @Test
    public void makeMyTrip(){

        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.findElement(By.xpath("//input[@id = 'fromCity']")).click();
        driver.findElement(By.xpath("//input[contains(@class, 'react-autosuggest')]")).sendKeys("");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(), 'Hyderabad')]")));

        driver.findElement(By.xpath("//p[contains(text(), 'Hyderabad')]")).click();
        driver.findElement(By.xpath("//input[contains(@class, 'react-autosuggest')]")).sendKeys("Bangalore");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(), 'Bangalore')]")));

        driver.findElement(By.xpath("//p[contains(text(), 'Bangalore')]")).click();
    }
}
