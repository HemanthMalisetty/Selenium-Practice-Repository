package test;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {

    public static void main(String[] args) throws InterruptedException {

        //WebDriverManager.firefoxdriver().setup();

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\parsi\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://www.wikipedia.org/");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@class= ' styled-select js-enbled']")).click();
        WebElement dropdown = driver.findElement(By.xpath("//*[@id = 'searchLanguage']"));
        Select dropdownSelect = new Select(dropdown);
        List<WebElement> dropdownValues = dropdownSelect.getOptions();
        for (int i = 0; i < dropdownValues.size(); i++)
        {
            dropdownSelect.selectByIndex(i);
            String language = dropdownValues.get(i).getText();
            String selectedValue = dropdownSelect.getFirstSelectedOption().getText();
            System.out.println(language + ", " + selectedValue);

        }
        driver.navigate().refresh();

        System.out.println("No. of Dropdown vaues"  +dropdownValues.size());

    }

}