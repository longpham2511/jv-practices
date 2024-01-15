package Selenium_section10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Window_handle {
    public static void main(String[] args) {
        System.setProperty("chromedriver.exe", "L:/Study/chromedriver_win32");
        WebDriver section10 = new ChromeDriver();
        section10.get("https://rahulshettyacademy.com/loginpagePractise/");
        section10.manage().window().maximize();
        section10.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        section10.findElement(By.cssSelector(".blinkingText")).click();
        Set<String> windows = section10.getWindowHandles(); // for window => [parentID,childID]
        Iterator<String> movewindow = windows.iterator(); //movewindow can move between windows
        String parentID = movewindow.next(); // move to the 1st window
        String childID = movewindow.next(); // move to the 2nd window
        section10.switchTo().window(childID);

        String message1 = section10.findElement(By.cssSelector(".im-para.red"))
                .getText() //Please email us at mentor@rahulshettyacademy.com with below template to receive response
                .split("at")[1] // [0] "Please email us " ; we pick [1] " mentor@rahulshettyacademy.com with below template to receive response"
                .trim() //"mentor@rahulshettyacademy.com with below template to receive response"
                .split(" ")[0]; // we get [0] "mentor@rahulshettyacademy.com"

        String[] message1array = message1.split(" ");
        String extractedMessage = message1array[4];
        System.out.println(extractedMessage);
        section10.switchTo().window(parentID);
        section10.findElement(By.id("username")).sendKeys(extractedMessage);


    }
}
