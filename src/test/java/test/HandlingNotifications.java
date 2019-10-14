package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class HandlingNotifications
{
    WebDriver driver;
    @BeforeTest
    public void initialize()
    {
        //WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();
        //WebDriverManager.firefoxdriver().setup();
        //System.setProperty("webdriver.gecko.driver", "C:\\Users\\heman\\Downloads\\Selenium Softwares\\Drivers\\geckodriver-v0.21.0-win64\\geckodriver.exe");
//        FirefoxProfile profile = new FirefoxProfile();
//        profile.setPreference("permissions.default.desktop-notification", 1);
//        DesiredCapabilities capabilities= DesiredCapabilities.firefox();
//        capabilities.setCapability(FirefoxDriver.PROFILE, profile);
//        driver = new FirefoxDriver(capabilities);
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\heman\\Downloads\\Selenium Softwares\\Drivers\\Latest Chrome\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--disable-notifications");
        driver = new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.get("https://www.axisbank.com/");
    }
    @Test
    public void mMT() throws InterruptedException {
        Thread.sleep(10000);
    }
    @AfterTest
    public void close()
    {
        driver.close();
    }
}
