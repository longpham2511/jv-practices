package Assignment_8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Autocomplete_dropdown {
    public static void main(String[] args) {
        WebDriver assignment8 = new ChromeDriver();
        System.setProperty("chromedriver.exe", "L:/Study/chromedriver-win64/chromedriver-win64");
        assignment8.get("https://rahulshettyacademy.com/AutomationPractice/");
        assignment8.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait waitTimer = new WebDriverWait(assignment8, Duration.ofSeconds(5));

        Actions mouseAct = new Actions(assignment8);
        WebElement suggestDrop = assignment8.findElement(By.id("autocomplete"));
        suggestDrop.click();
        mouseAct.moveToElement(suggestDrop)
                .click()
                .sendKeys("Uni")
                .build().perform();
        mouseAct.moveToElement(waitTimer.until(ExpectedConditions.elementToBeClickable(By.xpath("//li/div[text()='United States (USA)']"))))
                .click()
                .build().perform();
        Assert.assertEquals(suggestDrop.getAttribute("value"), "United States (USA)");
    }
}
