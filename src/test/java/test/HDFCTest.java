package test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import test.driverUtil.DriverFactory;
import test.driverUtil.DriverHelper;

import java.util.Set;


@Listeners({test.driverUtil.NewTestListener.class})
public class HDFCTest extends DriverFactory {
    @Test
    public void hdfcTest(){
        DriverHelper.explicitWaitForTheElementToBeClickable(driver, By.xpath("//img[@class = 'popupCloseButton']"));
        driver.findElement(By.xpath("//img[@class = 'popupCloseButton']")).click();
        String currentWindow = driver.getWindowHandle();
        driver.findElement(By.xpath("//a[@id = 'loginsubmit1']")).click();
        Set<String> windows = driver.getWindowHandles();
        for(String window : windows){
            if (!currentWindow.equals(window)){
                driver.switchTo().window(window);
                break;
            }
        }
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//div[@class = 'benefits']//a[contains(text(), 'Know more')]")).click();
    }
}