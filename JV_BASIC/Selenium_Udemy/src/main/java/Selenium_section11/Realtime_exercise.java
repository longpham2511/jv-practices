package Selenium_section11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.Set;

public class Realtime_exercise {
    public static void main(String[] args) throws InterruptedException {
        WebDriver section11 = new ChromeDriver();
        System.setProperty("chromedriver.exe", "L:/Study/chromedriver_win32");
        section11.get("https://rahulshettyacademy.com/AutomationPractice/#");
        System.out.println(section11.findElements(By.tagName("a")).size()); //all anchor tags in the webpage
        WebElement footdriver = section11.findElement(By.id("gf-BIG"));
        System.out.println(footdriver.findElements(By.tagName("a")).size()); //the anchors in the footsection - limiting webdriver scope
        WebElement footdrivercolumn1 = footdriver.findElement(By.xpath("//table/tbody/tr/td/ul"));

        for (int i = 1; i < footdrivercolumn1.findElements(By.tagName("a")).size(); i++) {
           String keystring =  Keys.chord(Keys.LEFT_CONTROL, Keys.ENTER);
           footdrivercolumn1.findElements(By.tagName("a")).get(i).sendKeys(keystring);

           Thread.sleep(3000);
        }
        Set<String> windowtab =  section11.getWindowHandles();
        Iterator<String> windowtabSwitcher = windowtab.iterator();

        while (windowtabSwitcher.hasNext()){
            section11.switchTo().window(windowtabSwitcher.next());
            System.out.println(section11.getTitle());
        }

    }
}
