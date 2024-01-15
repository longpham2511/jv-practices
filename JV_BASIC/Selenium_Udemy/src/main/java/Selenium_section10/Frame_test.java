package Selenium_section10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Frame_test {
    public static void main(String[] args) {
        WebDriver section10 = new ChromeDriver();
        System.setProperty("chromedriver.exe", "L:/Study/chromedriver_win32");
        section10.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        section10.get("https://jqueryui.com/droppable/");
        System.out.println(section10.findElements(By.tagName("iframe")).size()); //count how many iframe - if there is 1 iframe
        //section10.switchTo().frame(0) -> this will switch to the first iframe available
        section10.switchTo().frame(section10.findElement(By.cssSelector("iframe.demo-frame")));
        Actions a = new Actions(section10);
        a.dragAndDrop(section10.findElement(By.id("draggable")),section10.findElement(By.id("droppable"))).build().perform();
        section10.switchTo().defaultContent();
        section10.findElement(By.xpath("//*[text()='Accept']")).click();

    }
}
