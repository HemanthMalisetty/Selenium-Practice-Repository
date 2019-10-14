package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SwitchToWindows {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("start-maximized");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\parsi\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver1 =new ChromeDriver(options);
        driver1.get("http://hdfcbank.com");
        driver1.manage().window().maximize();
        driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver1.findElement(By.className("popupCloseButton")).click();
        Set<String> handles = driver1.getWindowHandles();
        String window1 = handles.iterator().next();
        System.out.println(window1 );
        driver1.findElement(By.id("loginsubmit")).click();
        driver1.manage().window().maximize();
        handles = driver1.getWindowHandles();
        System.out.println(handles);
        Iterator<String> iterator = handles.iterator();
        window1 = iterator.next();
        String window2 = iterator.next();
        System.out.println(window2);
        driver1.switchTo().window(window2);

        driver1.findElement(By.xpath("//div[@class = 'benefits']//a[contains (text(),'Know more')]")).click();

        handles = driver1.getWindowHandles();
        System.out.println("2 window handles");
        System.out.println(handles);
        driver1.findElement(By.xpath("//a[contains ( text(), 'Read More')]")).click();


    }
}
