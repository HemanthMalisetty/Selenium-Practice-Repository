package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleTest {
    public static void main(String args[])
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        /*WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();*/
        driver.manage().window().maximize();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);

        driver.get("https://www.google.com/");
        //driver.findElement(By.xpath("//*[@name = 'q']")).sendKeys("way2automation");
        WebElement search = driver.findElement(By.xpath("//*[@name = 'q']"));
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].value = 'way2automation';", search);


        WebElement searchbutton =  driver.findElement(By.xpath("(//*[@name = 'btnK'])[2]"));
        JavascriptExecutor js2 =(JavascriptExecutor) driver;
        js2.executeScript("arguments[0].click();", searchbutton);
        /*webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@name = 'btnK'])[2]")));
        driver.findElement(By.xpath("(//*[@name = 'btnK'])[2]")).submit();*/
    }
}
