package test;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import test.driverUtil.DriverFactory;
import test.driverUtil.DriverHelper;


public class OpenNewTabUsingRightClick extends DriverFactory {
    @Test
    public void openNewTab() throws InterruptedException {
        WebElement men = driver.findElement(By.xpath("//a[@href = '/shop/men']"));
        DriverHelper.explicitWaitForTheElementToBeClickable(driver,By.xpath("//a[@href = '/shop/men']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(men).contextClick().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(3000);
    }
}

