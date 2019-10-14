package test;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import test.driverUtil.DriverFactory;

import java.security.Key;
import java.util.Arrays;
import java.util.List;

public class WindowHandles extends DriverFactory {
    @Test
    public void windowHandle(){
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(By.xpath("(//button[@class = 'btn btn-info'])[1]"))).build().perform();
        actions.sendKeys();
        List windows = Arrays.asList(driver.getWindowHandles());

    }
}
