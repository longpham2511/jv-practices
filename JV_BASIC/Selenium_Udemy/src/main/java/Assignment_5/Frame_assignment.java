package Assignment_5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Frame_assignment {
    public static void main(String[] args) {
        WebDriver assignment5 = new ChromeDriver();
        System.setProperty("chromedriver.exe", "L:/Study/chromedriver_win32");
        assignment5.get("https://the-internet.herokuapp.com/nested_frames");
        //System.out.println(assignment5.findElements(By.tagName("frameset")).size());
        assignment5.switchTo().frame(0);
        //System.out.println(assignment5.findElements(By.tagName("frame")).size());
        WebElement childframe = assignment5.findElements(By.tagName("frame")).get(1);
        assignment5.switchTo().frame(childframe);
        System.out.println(assignment5.findElement(By.id("content")).getText());

    }
}

/*
WebDriver driver=new ChromeDriver();
driver.get("http://the-internet.herokuapp.com/");
driver.findElement(By.linkText("Nested Frames")).click();
driver.switchTo().frame("frame-top");
driver.switchTo().frame("frame-middle");
System.out.println(driver.findElement(By.id("content")).getText());
 */


