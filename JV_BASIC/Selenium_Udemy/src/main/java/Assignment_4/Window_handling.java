package Assignment_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Window_handling {
    public static void main(String[] args) {
        System.setProperty("chromedriver.exe", "L:/Study/chromedriver_win32");   //basic setup
        WebDriver Assignment4 = new ChromeDriver();
        Assignment4.get("https://the-internet.herokuapp.com/windows");
        Assignment4.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        Assignment4.findElement(By.xpath("//*[text()='Click Here']")).click(); //navigate to the child page

        Set<String> windowSwitcher = Assignment4.getWindowHandles();            //set up Iterator to move between parent and child pages
        Iterator<String> windowSwitchInitiator = windowSwitcher.iterator();
        String parentWindowID = windowSwitchInitiator.next();
        String childWindowID = windowSwitchInitiator.next();

        Assignment4.switchTo().window(childWindowID);           //Switch to child window
        String childPageText = Assignment4.findElement(By.cssSelector(".example")).getText();        //Get text as a String
        Assert.assertEquals(childPageText, "New Window");           //Assert string value
        System.out.println("Text from child page: " + childPageText);

        Assignment4.switchTo().window(parentWindowID);          //Switch back to parent window
        String parentPageText = Assignment4.findElement(By.xpath("//*[text()='Opening a new window']")).getText();   //Get text as a String
        Assert.assertEquals(parentPageText, "Opening a new window");    //Assert string value
        System.out.println("Text from parent page: " + parentPageText);

        Assignment4.quit();

    }
}
