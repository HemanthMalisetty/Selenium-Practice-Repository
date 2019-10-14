package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import test.driverUtil.DriverFactory;

import java.util.Iterator;
import java.util.Set;

public class LVCarInsurance extends DriverFactory {
    @Test
    public void lVCarInsurance() throws InterruptedException {
        String str = driver.getWindowHandle();
        driver.findElement(By.xpath("//div[@class = 'headerBanner__body']//a[string() = 'Get a car quote']")).click();
        Set<String> openedWindows = driver.getWindowHandles();
        Iterator<String> iterator = openedWindows.iterator();
        while (iterator.hasNext()){
            String childWindow = iterator.next();
            if(!childWindow.equals(str)) {
                driver.switchTo().window(childWindow);
                break;
            }
        }
        WebElement selectTitle = driver.findElement(By.xpath("//select[@id = 'title']"));
        Select select = new Select(selectTitle);
        select.selectByIndex(1);
        driver.findElement(By.xpath("//input[@id = 'firstName']")).sendKeys("Hemanth");
        driver.findElement(By.xpath("//input[@id = 'surname']")).sendKeys("Kumar");
        driver.findElement(By.xpath("//label[text()='Male']")).click();
        driver.findElement(By.xpath("//input[@id = 'dateOfBirthDay']")).sendKeys("29");
        driver.findElement(By.xpath("//input[@id = 'dateOfBirthMonth']")).sendKeys("04");
        driver.findElement(By.xpath("//input[@id = 'dateOfBirthYear']")).sendKeys("1994");
        driver.findElement(By.xpath("//input[@id = 'propertyPostcode']")).sendKeys("CA9 3HX");
        driver.findElement(By.xpath("//button[@id = 'propertyAddressBtn']")).click();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        for (int i = 1; i<=5; i++)
        {
            try {
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//select[@id = 'propertyAddressKey']"))));
                break;
            }catch(Exception e)
            {

            }
        }
        WebElement addressSelect = driver.findElement(By.xpath("//select[@id = 'propertyAddressKey']"));
        Select select1 = new Select(addressSelect);
        select1.selectByIndex(1);
        Thread.sleep(5000);
    }
}
