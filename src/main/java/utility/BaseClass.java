package utility;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    WebDriver driver;

    public void openApplication() {
        driver = DriverFactory.browserName("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.zoopla.co.uk/");
    }

    public void closeApplication() {
        driver.close();
    }

}
