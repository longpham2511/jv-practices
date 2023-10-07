package Selenium_section6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class parsing_string {
    public static void main(String[] args) throws InterruptedException {
        WebDriver section6 = new ChromeDriver();
        String name = "Tao la Long";
        System.setProperty("chromedriver.exe", "L:/Study/chromedriver_win32");
        String password = getPassword(section6);
        section6.get("https://rahulshettyacademy.com/locatorspractice/");
        section6.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        section6.findElement(By.id("inputUsername")).sendKeys(name);
        section6.findElement(By.xpath("//input[contains(@placeholder,'Pass')]")).sendKeys(password);
        section6.findElement(By.className("submit")).click();
        Thread.sleep(1000);
        Assert.assertEquals(section6.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello " + name + ",");
        Assert.assertEquals(section6.findElement(By.xpath("//div[@class='login-container']/h1")).getText(), "Welcome to Rahul Shetty Academy");
        Assert.assertEquals(section6.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
        section6.findElement(By.xpath("//button[text()='Log Out']")).click();
        section6.close();
    }

    public static String getPassword(WebDriver section6) throws InterruptedException {
        section6.get("https://rahulshettyacademy.com/locatorspractice/");
        section6.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        section6.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[2]")).click();
        String signinMessage = section6.findElement(By.cssSelector("p.infoMsg")).getText();
        //Please use temporary password 'rahulshettyacademy' to Login.
        String[] extractPassword =  signinMessage.split("'");
        //signinmessage - 0th regex = "Please use temporary password "
        //signinmessage - 1st regex = "rahulshettyacademy' to Login."

        //String[] finalPassword = extractPassword[1].split("'");
        String finalPassword = extractPassword[1].split("'")[0];
        //finalPassword - 0th regex = "rahulshettyacademy"
        //finalPassword - 1th regex = " to Login."
        //can use this splitting method for the final pass
        return finalPassword;
    }
}
