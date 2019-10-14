package test;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartPaymentSelection {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        /*WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();*/
        /*WebDriverManager.iedriver().arch32().setup();
        WebDriver driver = new InternetExplorerDriver();*/
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        driver.get("https://www.flipkart.com/checkout/init");
        driver.manage().window().maximize();
        //driver.findElement(By.xpath("//*[contains(text(), 'Login')]")).click();
        WebElement element2 = driver.findElement(By.xpath("//*[contains(text(), 'Login')]"));
        ((ChromeDriver) driver).executeScript("arguments[0].click();", element2);
        driver.findElement(By.xpath("(//*[contains(text(), 'Enter Email')]/ancestor::form//input)[1]")).sendKeys("hemanth.vignanasudha@gmail.com");
        driver.findElement(By.xpath("(//*[contains(text(), 'Enter Email')]/ancestor::form//input)[2]")).sendKeys("Djocovic@7791");
        driver.findElement(By.xpath("//*[text() = 'Login']//ancestor::button")).submit();
        driver.findElement(By.xpath("//*[text() = 'Place Order']//ancestor::button")).click();
        driver.findElement(By.xpath("//*[text() = 'Deliver Here']")).click();
        driver.findElement(By.xpath("//*[text() = 'CONTINUE']")).click();
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.id("NET_OPTIONS"));
        ((ChromeDriver) driver).executeScript("arguments[0].click();", element);
        WebElement dropdownElemenet = driver.findElement(By.xpath("//*[contains(text(), 'Select Bank')]/ancestor::select"));
        Select dropdownSelect = new Select(dropdownElemenet);
        dropdownSelect.selectByIndex(2);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[contains(text(), 'PAY')]"))));
        driver.findElement(By.xpath("//*[contains(text(), 'PAY')]")).click();
    }
}