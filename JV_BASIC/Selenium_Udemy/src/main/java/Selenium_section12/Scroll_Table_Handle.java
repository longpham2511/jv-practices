package Selenium_section12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Scroll_Table_Handle {
    public static void main(String[] args) {
        System.setProperty("chromedriver.exe", "L:/Study/chromedriver_win32");
        WebDriver section12 = new ChromeDriver();
        section12.get("https://rahulshettyacademy.com/AutomationPractice/");
        section12.manage().window().maximize();

        //SCROLL SECTION

        JavascriptExecutor jsEx = (JavascriptExecutor) section12;

        //execute js on a browser by going to console window.scrollBy(0,500)
        jsEx.executeScript("window.scrollBy(0,650)");

        //scroll down within a small window on the web - By picking the small window with js from console first
        // =>> document.querySelector(".tableFixHead")   -put CSS in there to locate the small window
        jsEx.executeScript("document.querySelector('.tableFixHead').scrollTop=100");
        // document.querySelector('.tableFixHead').scrollTop=100 -scroll top to move the page down

        //TABLE SECTION

        //move to a specific window of a table //table[@class='table-display']/tbody/tr[2]
        List<WebElement> priceValue = section12.findElements(By.xpath("//table[@class='table-display']/tbody/tr/td[3]"));
        int sumTotal = 0;
        //calculate the total value of price column
        for(int i = 0; i<priceValue.size();i++){
            sumTotal = sumTotal + Integer.parseInt(priceValue.get(i).getText());
        }
        System.out.println(sumTotal);


    }
}
