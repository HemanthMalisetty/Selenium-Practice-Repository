package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Wikipedia
{
    public static void main(String[] args) {
        //WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();

        WebDriverManager.iedriver().version("3.9").arch32().setup();
        WebDriverManager.iedriver().setup();
        WebDriverManager.iedriver().arch32().setup();
        WebDriver driver = new InternetExplorerDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get("https://www.wikipedia.org/");
        driver.findElement(By.xpath("//*[@class = ' styled-select js-enabled']")).click();
        WebElement dropdown = driver.findElement(By.xpath("//*[@id = 'searchLanguage']"));
        Select dropdownSelect = new Select(dropdown);
        List<WebElement>  dropdownValues = dropdownSelect.getOptions();
        for (int i = 0; i<dropdownValues.size() ; i++)
        {
            dropdownSelect.selectByIndex(i);
            String language = dropdownValues.get(i).getText();
            String selectedValue = dropdownSelect.getFirstSelectedOption().getText();
            System.out.println(language + ", " + selectedValue);
        }
        System.out.println("Number of dropdown values - " +dropdownValues.size());
    }
}
