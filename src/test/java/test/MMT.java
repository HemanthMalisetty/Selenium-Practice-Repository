package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MMT {
    WebDriver driver;
    @BeforeTest
    public void initialize()
    {
        //WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();
        WebDriverManager.firefoxdriver().setup();
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("dom.webnotifications.enabled", false);
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.get("https://www.makemytrip.com/");
    }
    @Test
    public void mMT()
    {
        driver.findElement(By.xpath("//span[normalize-space() = 'DEPARTURE']")).click();
        String newDate = addDays(30);
        System.out.println(newDate);
        String newDateArr[] = newDate.split("/");
        driver.findElement(By.xpath("//div[contains(@aria-label, '" + newDateArr[1] +" "+ newDateArr[0]+ " "+newDateArr[2] +"') and @aria-disabled='false']")).click();
    }
    public String addDays(int noOfDays)
    {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy");
        String strDate= formatter.format(date);
        System.out.println("Date before Addition: "+strDate);
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, 28);
        return formatter.format(c.getTime());
    }
    @AfterTest
    public void close()
    {
        driver.close();
    }
}
