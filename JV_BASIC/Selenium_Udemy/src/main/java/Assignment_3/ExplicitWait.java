package Assignment_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ExplicitWait {
    public static void main(String[] args) {
        //1. Basic Setup
        System.setProperty("chromedriver.exe", "L:/Study/chromedriver_win32");
        WebDriver Assignment3 = new ChromeDriver();
        WebDriverWait ExplicitW = new WebDriverWait(Assignment3, Duration.ofSeconds(5));
        //Assignment3.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //2. Login Page
        Assignment3.get("https://rahulshettyacademy.com/loginpagePractise/");
        Assignment3.manage().window().maximize();
            //a. Send keys
        ExplicitW.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='username']")));
        Assignment3.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        Assignment3.findElement(By.id("password")).sendKeys("learning");
            //b. Dropdown and checkbox
        WebElement dropdownRole = Assignment3.findElement(By.xpath("//select[@data-style='btn-info']"));
        Select staticdropdownRole = new Select(dropdownRole);
        staticdropdownRole.selectByVisibleText("Consultant");
        Assignment3.findElement(By.xpath("//input[@id='terms']")).click();
            //c. Sign in
        Assignment3.findElement(By.id("signInBtn")).click();

        //3. Adding items into the cart
            //a. Add items into cart and click checkout
        ExplicitW.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-info']")));
        List<WebElement> productArray = Assignment3.findElements(By.xpath("//button[@class='btn btn-info']"));
        for(int i = 0;i<productArray.size();i++){
            productArray.get(i).click();
        }
        Assignment3.findElement(By.xpath("//li[@class='nav-item active']")).click();
            //b. check out
        ExplicitW.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-success']")));
        Assignment3.findElement(By.xpath("//button[@class='btn btn-success']")).click();
    }
}
