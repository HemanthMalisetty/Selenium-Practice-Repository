package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class FBUserAssignment_Vipul {
    private WebDriver driver;
    String State;
    String states = "//select[@id='ddlState']", Constituencies = "//select[@id='ddlAC']";


    @BeforeClass(alwaysRun = true)
    public void setup() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\heman\\Downloads\\Selenium Softwares\\Drivers\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://results.eci.gov.in/…/consti…/ConstituencywiseU011.htm");
    }

    @Test
    public void stateConsituencylist() throws IOException, InterruptedException {
        getDropDownlist(states, Constituencies);
    }


    public void getDropDownlist(String states, String Constituencies) throws IOException, InterruptedException {
        Select sl_state = new Select(driver.findElement(By.xpath(states)));
        List<WebElement> lst_state = sl_state.getOptions();

        Select sl_Const = new Select(driver.findElement(By.xpath(Constituencies)));
        List<WebElement> lst_Constituencies = sl_Const.getOptions();
        sl_state.selectByIndex(5);
        sl_Const.selectByIndex(5);
        System.out.println(lst_state.get(5).getText() + "==========>>" + lst_Constituencies.get(5).getText());
    }

    @AfterClass
    public void tearDown() {
//driver.quit();
    }

}
