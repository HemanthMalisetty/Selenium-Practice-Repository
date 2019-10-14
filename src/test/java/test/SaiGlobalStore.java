package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import test.driverUtil.DriverFactory;

public class SaiGlobalStore extends DriverFactory {

    @Test
    public void saiGlobalStore() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.findElement(By.xpath("//a[@id='CybotCookiebotDialogBodyButtonAccept']")).click();
        driver.navigate().refresh();
        WebElement login = driver.findElement(By.xpath("//div[@class = 'desktop-login']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(login).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class = 'desktop-login']//a[contains(text(), 'Infostore')]")));
        driver.findElement(By.xpath("//div[@class = 'desktop-login']//a[@href = 'https://infostore.saiglobal.com/']")).click();
        Thread.sleep(5000);
    }
    @Test
    public void saiGlobalStore2() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.findElement(By.xpath("//a[@id='CybotCookiebotDialogBodyButtonAccept']")).click();
        driver.navigate().refresh();
        WebElement login = driver.findElement(By.xpath("//div[@class = 'desktop-login']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(login).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class = 'desktop-login']//a[contains(text(), 'Infostore')]")));
        actions.moveToElement(driver.findElement(By.xpath("//div[@class = 'desktop-login']//a[contains(text(), 'Infostore')]"))).click().build().perform();
        Thread.sleep(5000);
    }
    @Test
    public void saiGlobalStore3() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.findElement(By.xpath("//a[@id='CybotCookiebotDialogBodyButtonAccept']")).click();
        driver.navigate().refresh();
        WebElement login = driver.findElement(By.xpath("//div[@class = 'desktop-login']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(login).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class = 'desktop-login']//a[contains(text(), 'Infostore')]")));
        WebElement element = driver.findElement(By.xpath("//div[@class = 'desktop-login']//a[contains(text(), 'Infostore')]"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("arguments[0].click();", element);
        Thread.sleep(5000);
    }
}
