package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import test.driverUtil.DriverFactory;
import test.driverUtil.DriverHelper;

import java.util.List;
import java.util.Set;

public class FlipcartClosePopup extends DriverFactory {
    @Test
    public void closePopup(){
        DriverHelper.explicitWaitForTheElementToBeClickable(driver, By.xpath("//button[@class = '_2AkmmA _29YdH8']"));
        driver.findElement(By.xpath("//button[@class = '_2AkmmA _29YdH8']")).click();
        driver.findElement(By.xpath("//input[@class = 'LM6RPg']")).sendKeys("iphone");
        driver.findElement(By.xpath("//button[@class = 'vh79eN']")).submit();
        DriverHelper.explicitWaitForTheElementToBeVisible(driver, By.xpath("//div[@class = '_3wU53n']"));
        List<WebElement> products = driver.findElements(By.xpath("//div[@class = '_3wU53n']"));
        for (WebElement element : products){
            System.out.println(element.getText());
        }
    }
    @Test
    public void login() throws InterruptedException {
        driver.findElement(By.xpath("//input[@class = '_2zrpKA _1dBPDZ']")).sendKeys("7204200664");
        driver.findElement(By.xpath("//input[@class = '_2zrpKA _3v41xv _1dBPDZ']")).sendKeys("Djocovic@7791");
        driver.findElement(By.xpath("//button[@class = '_2AkmmA _1LctnI _7UHT_c']")).submit();
        for (int i = 1 ; i <= 5 ; i++)
        {
            try{
                DriverHelper.explicitWaitForTheElementToBeVisible(driver, By.xpath("//input[@class = 'LM6RPg']"));
                break;
            }
            catch (Exception e){
            }
        }
        driver.findElement(By.xpath("//input[@class = 'LM6RPg']")).sendKeys("iphone");
        driver.findElement(By.xpath("//button[@class = 'vh79eN']")).submit();
        DriverHelper.explicitWaitForTheElementToBeVisible(driver, By.xpath("//div[@class = '_3wU53n']"));
        String currentWindow = driver.getWindowHandle();
        List<WebElement> products = driver.findElements(By.xpath("//div[@class = '_3wU53n']"));
        products.get(0).click();
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows){
            if (window.equals(currentWindow)){
                driver.switchTo().window(window);
                break;
            }
        }

        Thread.sleep(5000);
    }
}
