package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewZealandDOCBooking {
    public static void main(String args[])
    {
        int numberofPeople = 3;
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        driver.get("https://nztraining.usedirect.com/SaturnPreProd/");
        driver.findElement(By.xpath("//*[text() = 'GREAT WALKS']")).click();
        WebElement greatwalkDropdownElement = driver.findElement(By.xpath("//*[@id = 'mainContent_homeContent_ddlPlaces']"));
        Select greatwalkDropdownSelect = new Select(greatwalkDropdownElement);
        greatwalkDropdownSelect.selectByIndex(1);
        WebElement numberOfNightsDropdownElement = driver.findElement(By.xpath("//*[@id = 'mainContent_homeContent_ddlNights']"));
        Select numberOfNightsDropdownSelect = new Select(numberOfNightsDropdownElement);
        numberOfNightsDropdownSelect.selectByIndex(0);
        WebElement numberOfPeopleDropdownElemenet = driver.findElement(By.xpath("//*[@id = 'ddlParty']"));
        Select numberOfPeopleDropdownSelect = new Select(numberOfPeopleDropdownElemenet);
        numberOfPeopleDropdownSelect.selectByIndex(numberofPeople-1);
        WebElement searchButton = driver.findElement(By.xpath("//*[@id = 'mainContent_homeContent_btnSearch']"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
        driver.findElement(By.xpath("(//*[text() = 'Tinline Campsite']/ancestor::tr//*[@class = 'green_bg_tab'])[1]")).click();
        driver.findElement(By.xpath("//*[text() = 'Reserve']")).click();

        for(int i = 1; i<=numberofPeople ; i++ )
        {
            webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id = 'txtFirstName" +i+ "']"))));
            driver.findElement(By.xpath("//*[@id = 'txtFirstName" +i+ "']")).sendKeys("FirstName" +i);
            driver.findElement(By.xpath("//*[@id = 'txtLastName" +i+ "']")).sendKeys("LastName" +i);
            WebElement countryOfCitizenshipDropdownElement = driver.findElement(By.xpath("//*[@id= 'ddlCountries" +i+ "']"));
            Select countryOfCitizenshipDropdownSelect = new Select(countryOfCitizenshipDropdownElement);
            countryOfCitizenshipDropdownSelect.selectByIndex(1);
            driver.findElement(By.xpath("//*[@id = 'txtAge" +i+ "']")).sendKeys("25");
            WebElement genderDropdownElement = driver.findElement(By.xpath("//*[@id = 'ddlgender" +i+ "']"));
            Select genderDropdownSelect = new Select(genderDropdownElement);
            genderDropdownSelect.selectByIndex(1);
        }
    }
}
