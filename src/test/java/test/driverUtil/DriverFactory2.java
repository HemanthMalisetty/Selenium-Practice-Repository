package test.driverUtil;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class DriverFactory2 {
    public WebDriver driver;

    @BeforeTest
    @Parameters({"browser", "domain"})
    public void browserName(String browser, String domain) {

        switch (browser.toLowerCase()) {
            case "chrome":
                System.out.println("Browser name : " + browser);
                WebDriverManager.chromedriver().setup();
                ChromeOptions ops = new ChromeOptions();
                ops.addArguments("--disable-notifications");
                driver = new ChromeDriver(ops);
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                driver.get(domain);
                break;
            case "ff":
                System.out.println("Browser name : " + browser);
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                driver.get(domain);
                break;
            case "ie":
                System.out.println("Browser name : " + browser);
                WebDriverManager.iedriver().arch32().setup();
                driver = new InternetExplorerDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                driver.get(domain);
                break;
        }
    }

    @AfterTest
    public void closeApplication() {
        driver.quit();
    }
}
