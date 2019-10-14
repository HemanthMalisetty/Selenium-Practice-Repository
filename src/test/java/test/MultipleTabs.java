package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleTabs {
    public static void main(String args[])
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        String window = driver.getWindowHandle();
        System.out.println(window);
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
        Keys.chord(Keys.CONTROL,"t");
    }
}
