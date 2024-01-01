package Selenium_section8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Ecommerce_Practice {
    public static void main(String[] args) {

        System.setProperty("chromedriver.exe", "L:/Study/chromedriver_win32");
        WebDriver section8 = new ChromeDriver();

        section8.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        section8.manage().window().maximize();
        section8.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //ecommerce website has the same value for their buttons, have to check for the items' name to interact with their buttons

        String picked_item1 = "Beetroot";
        //can be a String Array if you want to pick multiple items
        //String[] picked_manyitems = {"Beetroot", "Broccoli"};

        List<WebElement> items = section8.findElements(By.xpath("//div[@class='product']"));

        for(int i = 0; i<items.size() ;i++){
            String productActual = items.get(i).getText();
            if (productActual.contains(picked_item1)){
                section8.findElements(By.xpath("//button[@type='button']")).get(i).click();
                break;
            }
        }

    }
}
