package utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

    public static WebDriver browserName(String browserName) {
        switch (browserName) {
            case "chrome":
                /*WebDriverManager.chromedriver().setup();*/
                WebDriverManager.chromedriver().version("74.0.3729.6").setup();
                return new ChromeDriver();
            case "ff":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case "ie":
                WebDriverManager.iedriver().arch32().setup();
                return new InternetExplorerDriver();
            default:
                return null;
        }
    }

}
