package Selenium_section6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Xpath_transverse {
    public static void main(String[] args) {
        //if a xpath is started from the root of html code use /html/parent/parent/child
        //a relative xpath is when we find an element from the parent to the child
        //Ex: //header/div/button[3]
        // from sibling to sibling //header/div/button[1]/following-sibling::button[1]
        System.setProperty("chromedriver.exe", "L:/Study/chromedriver_win32");
        WebDriver section6 = new ChromeDriver();
        section6.get("https://rahulshettyacademy.com/AutomationPractice/");
        section6.manage().window().fullscreen();
        section6.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        System.out.println(section6.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
        System.out.println(section6.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());

        //from child to parent //header/div/button[1]/parent::div

        // from child to grandparents then to grandparent child //header/div/button[1]/parent::div/parent::header/a[1]

        section6.close();

    }
}
