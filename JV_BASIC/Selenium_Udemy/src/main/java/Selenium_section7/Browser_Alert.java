package Selenium_section7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser_Alert {

    // Ctrl + shft + L => format code into a neat formation

    public static void main(String[] args) throws InterruptedException {
        String input1 = "Long Pham";
        WebDriver Alert1 = new ChromeDriver();
        Alert1.get("https://rahulshettyacademy.com/AutomationPractice/");
        Alert1.findElement(By.id("name")).sendKeys(input1);
        Alert1.findElement(By.id("alertbtn")).click();
        Thread.sleep(1000);

        System.out.println(Alert1.switchTo().alert().getText());
        String alert_message = Alert1.switchTo().alert().getText();
        if (alert_message.contains("Long Pham")) {
            System.out.println("Test 1 passed, input name is in err message.");
        } else {
            System.out.println("Test 1 failed, input name is not in err message.");
        }

        Alert1.switchTo().alert().accept(); //selenium will find the button that proceed with the alert
        Alert1.findElement(By.id("name")).sendKeys(input1);
        Alert1.findElement(By.id("confirmbtn")).click();
        Thread.sleep(1000);
        Alert1.switchTo().alert().dismiss(); //selenium will find a button to dismiss the alert


    }
}
