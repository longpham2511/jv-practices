package Selenium_section11;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Calender_handle {
    public static void main(String[] args) throws InterruptedException {
        /* NOTE on the working flow:
        calender will have the same attributes and values repeating all over
        For month, we can use while to move the calender to the destinated month
        For date, use list to iterate every date til we get the date that we want
        */

        System.setProperty("chromedriver.exe", "L:/Study/chromedriver_win32");
        WebDriver section11 = new ChromeDriver();
        section11.get("https://www.path2usa.com/travel-companion/");
        section11.manage().window().maximize();
        section11.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(section11, Duration.ofSeconds(5));
        Actions a = new Actions(section11);

        JavascriptExecutor jse = (JavascriptExecutor)section11;

        jse.executeScript("scroll(0, 1200)"); // if the element is on bottom.
        Thread.sleep(2000);

        section11.findElement(By.xpath("//*[@id='form-field-travel_comp_date']")).click();


        //For month, use while ! => while the data is not the same as saying, it will do this action
        //for while(true), the action will be done til a false pops up
        while(!section11.findElement(By.xpath("//div/div[@class='flatpickr-current-month']")).getText().contains("November"))
        {
            section11.findElement(By.xpath("//div/span[@class='flatpickr-next-month']")).click();
        }

        //For date, put dates into a list and iterate them

        for(int i = 0; i< section11.findElements(By.className("flatpickr-day")).size(); i++){
            String dateNumber = section11.findElements(By.className("flatpickr-day")).get(i).getText();
            if (dateNumber.equalsIgnoreCase("25")){
                section11.findElements(By.className("flatpickr-day")).get(i).click();
                break;
            }
        }



    }
}
