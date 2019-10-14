package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Asignment2 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        /*
         * WebDriverManager.firefoxdriver().setup(); WebDriver driver = new
         * FirefoxDriver();
         */

        driver.manage().window().maximize();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);

        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//*[@name = 'q']")).sendKeys("way2automation qa");
        driver.findElement(By.xpath("//*[@value = 'Google Search']")).submit();
        List<WebElement> link1 = driver.findElements(By.className("LC20lb"));
        System.out.println(link1.get(0).getText());
        link1.get(0).click();
        driver.findElement(By.name("name")).sendKeys("SP");
        driver.findElement(By.name("phone")).sendKeys("621-111-1111");
        driver.findElement(By.name("email")).sendKeys("sp@sp.com");
        driver.findElement(By.name("country")).sendKeys("India");
        driver.findElement(By.name("city")).sendKeys("Hyderabad");
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
        List<WebElement> link2 = driver.findElements(By.name("username"));
        System.out.println(link2.get(1).getText());
        link2.get(1).sendKeys("Sirisha Parsi");
        List<WebElement> link3 = driver.findElements(By.name("password"));
        System.out.println(link3.get(1).getText());
        link3.get(1).sendKeys("Password");
        List<WebElement> subbtn = driver.findElements(By.className("button"));
        System.out.println(subbtn.size());
        subbtn.get(1).click();

        driver.close();
    }
}
