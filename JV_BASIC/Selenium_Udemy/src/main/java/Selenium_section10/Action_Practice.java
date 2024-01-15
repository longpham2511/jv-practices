package Selenium_section10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Action_Practice {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("chromedriver.exe", "L:/Study/chromedriver_win32"); //invoke chrome
        WebDriver section10 = new ChromeDriver();
        section10.get("https://www.amazon.in/");
        section10.manage().window().maximize();
        Actions a = new Actions(section10);
        a.moveToElement(section10.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT).sendKeys("HELLO").doubleClick().build().perform();
        Thread.sleep(5000);
        WebElement move = section10.findElement(By.xpath("//a[@data-csa-c-slot-id='nav-link-accountList']"));
        a.moveToElement(move).contextClick().build().perform();

    }
}
