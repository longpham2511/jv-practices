package Selenium_section6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Advanced_locators {
    public static void main(String[] args) throws InterruptedException {
        WebDriver section6 = new ChromeDriver();
        System.setProperty("chromedriver.exe","L:/Study/chromedriver_win32");
        section6.get("https://rahulshettyacademy.com/locatorspractice/");
        section6.findElement(By.id("inputUsername")).sendKeys("longpham2511@gmail.com");
        section6.findElement(By.name("inputPassword")).sendKeys("3Thl2511.");
        section6.findElement(By.className("submit")).click();
        section6.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //wait for something to show
        System.out.println(section6.findElement(By.cssSelector("p.error")).getText());
        section6.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000); //wait for something to get into a stable state -> UI already loaded - UI transition - (wait) - final UI ver

        section6.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Long Pham");
        section6.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("abc@gmail.com");
        section6.findElement(By.xpath("//input[@type='text'][3]")).sendKeys("911");
        section6.findElement(By.cssSelector("button.reset-pwd-btn")).click();
        System.out.println(section6.findElement(By.cssSelector("form p")).getText());
        section6.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
        Thread.sleep(1000);

        section6.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("longpham");
        section6.findElement(By.xpath("//input[contains(@placeholder,'Pass')]")).sendKeys("rahulshettyacademy");
        section6.findElement(By.id("chkboxOne")).click();
        section6.findElement(By.id("chkboxTwo")).click();
        section6.findElement(By.cssSelector("button.submit")).click();


        //if classname/attribute is change everytime a browser loads
        // <input type="password" placeholder="Password" name="inputPassword" value="">
        // then for cssSelector to pick password (knowingly notice that end 4 letters change every time <passxxxx>)
        // We use input[type*='pass']   -> the * helps to pinpou
        // On the console side -> writing this as   $('input[type*="pass"]')

        //when finding class name, find element by classname <button class ="submit signin"> -> can pick 1 classname when picking classname
        // for css and xpath -> have to pick all -> xpath: //button[@class='submit signin']
        //  //button[contains(@class,'submit')] -> keyword 'contains' in xpath uses as a * in css


    }
}
