package Selenium_section9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.function.*;

import java.time.Duration;

public class Fluent_wait {
    public static void main(String[] args) {
        System.setProperty("chromedriver.exe", "L:/Study/chromedriver_win32");
        WebDriver Assignment3 = new ChromeDriver();
        Assignment3.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        Assignment3.findElement(By.xpath("//*[text()='Start']")).click();

        //fluent wait
        Wait<WebDriver> wait = new FluentWait<WebDriver>(Assignment3)
                .withTimeout(Duration.ofSeconds(21))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver Assignment3) {
                if(Assignment3.findElement(By.id("finish")).isDisplayed())
                {
                return Assignment3.findElement(By.id("finish"));
                }
                else return null;
            }
        });

        System.out.println(Assignment3.findElement(By.id("finish")).getText());
    }
}
