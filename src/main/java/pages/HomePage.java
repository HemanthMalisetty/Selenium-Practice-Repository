package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.BaseClass;

public class HomePage extends BaseClass {
    WebDriver driver;
    String saleSearchBar = "//*[@id = 'search-input-location']";
    String searchButton = "//*[@class = 'search-bottom clearfix']//*[@type = 'submit']";

    public void enterTextInSearchBar(String location)
    {
        driver.findElement(By.xpath(saleSearchBar)).sendKeys(location);
    }
    public void clickOnSearchButton()
    {
        driver.findElement(By.xpath(searchButton)).click();
    }

}
