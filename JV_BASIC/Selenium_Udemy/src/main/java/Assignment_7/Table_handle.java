package Assignment_7;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Table_handle {
    /*
    1. count row number
    2. count column
    3. print 2nd row content
     */
    public static void main(String[] args) {
        WebDriver assignment7 = new ChromeDriver();
        System.setProperty("chromedriver.exe", "L:/Study/chromedriver-win64/chromedriver-win64");
        assignment7.get("https://rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) assignment7;
        jsExecutor.executeScript("window.scroll(0,600)");
        WebDriverWait waitTimer = new WebDriverWait(assignment7, Duration.ofSeconds(5));
        waitTimer.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table-display']/tbody/tr")));

        System.out.println("The number of rows are: "+assignment7.findElements(By.xpath("//table[@class='table-display']/tbody/tr")).size());
        System.out.println("The number of columns are: "+assignment7.findElements(By.xpath("//table[@class='table-display']/tbody/tr[2]/td")).size());
        System.out.println("The text from the 2nd row is: \""+assignment7.findElements(By.xpath("//table[@class='table-display']/tbody/tr")).get(3).getText()+"\".");
        assignment7.close();
    }
}
