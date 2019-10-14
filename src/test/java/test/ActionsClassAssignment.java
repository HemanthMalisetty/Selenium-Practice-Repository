package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class ActionsClassAssignment {
    public static void main(String args[]) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://gmail.com");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.id("identifierId")).sendKeys("sirishajakka");


        //action.sendKeys(Keys.ENTER).perform();

        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]")).click();

        Actions action = new Actions(driver);

        action.sendKeys(Keys.chord(Keys.CONTROL + "a")).perform();

        action.sendKeys(Keys.chord(Keys.CONTROL + "c")).perform();

        driver.findElement(By.id("identifierId")).click();

        action.sendKeys(Keys.chord(Keys.CONTROL + "v")).perform();


    }

}