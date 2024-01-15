package Selenium_section7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;

public class Demo_MainGame {
    public static void main(String[] args) throws InterruptedException {
        WebDriver demo1 = new ChromeDriver();
        System.setProperty("chromedriver.exe", "L:/Study/chromedriver_win32");
        demo1.get("https://app.eklipse.gg/login");
        //demo1.manage().window().maximize();
        demo1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        demo1.findElement(By.id("username")).sendKeys("longpham2511@gmail.com");
        demo1.findElement(By.id("password")).sendKeys("3Thl2511.");
        demo1.findElement(By.xpath("//div/button[@type='submit']")).click();

        //wait for promotion tab
        Thread.sleep(5000);
        demo1.findElement(By.xpath("//div/button[@class='btn btn-link--highlight']")).click();
        Assert.assertEquals(demo1.findElement(By.xpath("//div/button[@class='btn-connect-discord']")).getText(),"Join Eklipse community");
        System.out.println(demo1.findElement(By.xpath("//div/div[@class='remain-times']")).getText());
        Assert.assertEquals(demo1.findElement(By.xpath("//div/button[@class='btn btn-go-premium']")).getText(),"Go Premium");

        //dropdown list
        demo1.findElement(By.cssSelector("button[class='btn-lang-toggle btn btn-secondary']")).click();
        Thread.sleep(1000);
        Assert.assertEquals(demo1.findElement(By.xpath("//button[contains(text(),'English')]")).getText(),"English");
        Assert.assertEquals(demo1.findElement(By.xpath("//button[contains(text(),'Spanish')]")).getText(),"Spanish");
        Assert.assertEquals(demo1.findElement(By.xpath("//button[contains(text(),'German')]")).getText(),"German");
        demo1.findElement(By.cssSelector("button[class='btn-lang-toggle btn btn-secondary']")).click();

        //signout
        demo1.findElement(By.xpath("//i[@class='ic-user']")).click();
        demo1.findElement(By.cssSelector("div[class='user-logout'] button[role='menuitem']")).click();





    }
}
