package test;

import org.openqa.selenium.By;
import org.sikuli.script.*;
import org.testng.annotations.Test;
import test.driverUtil.DriverFactory;

import javax.lang.model.type.TypeKind;

import static jdk.nashorn.internal.objects.NativeJava.type;
import static org.sikuli.script.Commands.click;
import static org.sikuli.script.KeyModifier.KEY_CTRL;
import static org.sikuli.script.KeyModifier.KEY_SHIFT;


public class Alerts extends DriverFactory {
    @Test
    public void alerts() throws InterruptedException, FindFailed {
        driver.findElement(By.xpath("//*[@class = 'btn btn-danger']")).click();
        driver.switchTo().alert().accept();
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//*[@class = 'analystic'])[2]")).click();
        driver.findElement(By.xpath("//*[@class = 'btn btn-primary']")).click();
        driver.switchTo().alert().accept();
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//*[@class = 'analystic'])[2]")).click();
        driver.findElement(By.xpath("//*[@class = 'btn btn-primary']")).click();
        driver.switchTo().alert().dismiss();
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//*[@class = 'analystic'])[3]")).click();
        driver.findElement(By.xpath("//*[@class = 'btn btn-info']")).click();
        Thread.sleep(5000);
        System.out.println(driver.switchTo().alert().getText());
        Screen screen = new Screen();
        Pattern prompt = new Pattern("C:\\Users\\heman\\Downloads\\prompt.png");
        click(prompt);
        screen.type("a", KeyModifier.CTRL);
        screen.type(Key.BACKSPACE);
        screen.type("Selenium Tester");
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
        Thread.sleep(5000);
    }
}
