package Selenium_section6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class locators2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver section6 = new ChromeDriver();
        String name = "Tao la Long";
        System.setProperty("chromedriver.exe","L:/Study/chromedriver_win32");
        section6.get("https://rahulshettyacademy.com/locatorspractice/");
        section6.findElement(By.id("inputUsername")).sendKeys(name);
        section6.findElement(By.xpath("//input[contains(@placeholder,'Pass')]")).sendKeys("rahulshettyacademy");
        section6.findElement(By.className("submit")).click();

        //grabbing tagname is nice, but there may be a lot of tagnames within a page
        //section6.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));   //do not need this one, URL is already done loading

        Thread.sleep(2000);
        System.out.println(section6.findElement(By.tagName("p")).getText());
        Assert.assertEquals(section6.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello " + name+"," );
        Assert.assertEquals(section6.findElement(By.xpath("//div[@class='login-container']/h1")).getText(),"Welcome to Rahul Shetty Academy");
        Assert.assertEquals(section6.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
        section6.findElement(By.xpath("//button[text()='Log Out']")).click();
        //catching "text" web element using xpath //tagname[text()='<text>'] or //*[text()='<text>']
        section6.close();
    }
}
