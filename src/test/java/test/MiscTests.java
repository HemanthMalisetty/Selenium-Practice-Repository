package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import test.driverUtil.MyTestListener;

@Listeners({MyTestListener.class})
public class MiscTests {

    WebDriver driver;

    @BeforeTest
    public void setUp(ITestContext context) {
        System.out.println("Starting set up..");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\heman\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/cssref/pr_background-color.asp");
        context.setAttribute("webDriver", driver);
        System.out.println("Webdriver created and added to context");
    }

    @Test
    public void testScreenshotsOnFail(ITestContext context) {
        System.out.println("Starting test that hast to fail..");
        Assert.assertEquals(1, driver.findElements(By.xpath("//blah")).size());
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Driver was instantiated. Quitting..");
        } else {
            System.out.println("Driver was null so nothing to do");
        }
    }
}
