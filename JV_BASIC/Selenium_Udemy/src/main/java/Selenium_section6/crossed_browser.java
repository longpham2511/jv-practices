package Selenium_section6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;

public class crossed_browser {
    public static void main(String[] args) throws InterruptedException {
        //In order to use this on a different browser, we can just switch the platform driver in the back
        WebDriver section6_0 = new FirefoxDriver();
        String name = "Tao la Long";
        System.setProperty("chromedriver.exe", "L:/Study/chromedriver_win32"); //remember to switch properties to the appropriate driver
        String password = getPassword(section6_0);
        section6_0.get("https://rahulshettyacademy.com/locatorspractice/");
        section6_0.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        section6_0.findElement(By.id("inputUsername")).sendKeys(name);
        section6_0.findElement(By.xpath("//input[contains(@placeholder,'Pass')]")).sendKeys(password);
        section6_0.findElement(By.className("submit")).click();
        Thread.sleep(1000);
        Assert.assertEquals(section6_0.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello " + name + ",");
        Assert.assertEquals(section6_0.findElement(By.xpath("//div[@class='login-container']/h1")).getText(), "Welcome to Rahul Shetty Academy");
        Assert.assertEquals(section6_0.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
        section6_0.findElement(By.xpath("//button[text()='Log Out']")).click();
        section6_0.close();
    }
    public static String getPassword(WebDriver section6_0) throws InterruptedException {
        section6_0.get("https://rahulshettyacademy.com/locatorspractice/");
        section6_0.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        section6_0.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[2]")).click();
        String signinMessage = section6_0.findElement(By.cssSelector("p.infoMsg")).getText();
        String[] extractPassword =  signinMessage.split("'");
        String finalPassword = extractPassword[1].split("'")[0];
        return finalPassword;
    }
}
