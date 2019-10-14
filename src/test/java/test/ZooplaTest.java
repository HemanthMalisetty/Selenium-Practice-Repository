package test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import test.driverUtil.DriverFactory;

public class ZooplaTest extends DriverFactory {
    /*@BeforeClass
    public void openApplication() {
        driver = DriverFactory.browserName("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.zoopla.co.uk/");
    }*/

    @Test
    public void ZooplaTest1() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id = 'search-input-location']")).sendKeys("London");
        driver.findElement(By.xpath("//*[@class = 'search-bottom clearfix']//*[@type = 'submit']")).click();
        Thread.sleep(5000);
    }

    /*@AfterClass
    public void closeApplication() {
        driver.close();
    }*/
}
