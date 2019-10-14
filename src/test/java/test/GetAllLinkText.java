package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import test.driverUtil.DriverFactory;

import java.util.List;

public class GetAllLinkText extends DriverFactory {

    @Test
    public void getAllLinksText() {
        /**
         * type way2automation and click search
         */
        driver.findElement(By.xpath("//*[@name = 'q']")).sendKeys("way2automation");
        driver.findElement(By.xpath("(//*[@class = 'suggestions-inner-container']//*[text() = 'way2automation'])[1]")).click();

        /**
         * click on first link
         */
        driver.findElement(By.xpath("//*[text() = 'www.way2automation.com/']/ancestor::a//*[text() = 'Way2Automation']")).click();

        /**
         * print the links count and text from page
         */
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());
        Actions actions = new Actions(driver);
        for (WebElement link : links) {
            if (!link.getText().isEmpty()) {
                WebDriverWait wait = new WebDriverWait(driver, 30);
                wait.until(ExpectedConditions.elementToBeClickable(link));
                /*actions.moveToElement(link).build().perform();*/
                System.out.println(link.getText());
            }
        }
    }
}
