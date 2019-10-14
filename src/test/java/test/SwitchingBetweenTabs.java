package test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import test.driverUtil.DriverFactory;

public class SwitchingBetweenTabs extends DriverFactory {
    @Test
    public void switchingBetweenWindows(){
        driver.findElement(By.xpath("//*[@class = 'mTxt' and text() = 'Login']")).click();

    }
}
