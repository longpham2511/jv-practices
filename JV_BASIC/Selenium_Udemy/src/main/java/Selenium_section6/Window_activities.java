package Selenium_section6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Window_activities {
    public static void main(String[] args) {
        WebDriver section6 = new ChromeDriver();
        System.setProperty("chromedriver.exe", "L:/Study/chromedriver_win32");
        section6.manage().window().maximize();
        section6.get("https://www.google.com");
        section6.navigate().to("https://rahulshettyacademy.com/AutomationPractice/"); //internally navigate within automation mode
        section6.navigate().back();
        section6.navigate().forward();
    }
}
