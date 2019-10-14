package test.driverUtil;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    public WebDriver driver;

    @BeforeTest
    @Parameters({"browser", "domain"})
    public void browserName(String browser, String domain, ITestContext context) {

        switch (browser.toLowerCase()) {
            case "chrome":
                /**
                 * chrome mobile emulator
                 */
                Map<String, String> mobileEmulation = new HashMap<>();

                mobileEmulation.put("deviceName", "Nexus 5");

                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

                driver = new ChromeDriver(chromeOptions);

                /*System.out.println("Browser name : " + browser);
                WebDriverManager.chromedriver().setup();
                ChromeOptions ops = new ChromeOptions();
                ops.addArguments("--disable-notifications");
                driver = new ChromeDriver(ops);*/
                context.setAttribute("webDriver", driver);
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
        LocalDriverManager.setWebDriver(driver);
    }

    @AfterTest
    public void closeApplication() {
        driver.quit();
    }
}
