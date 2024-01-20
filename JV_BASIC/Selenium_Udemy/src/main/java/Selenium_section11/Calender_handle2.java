package Selenium_section11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Calender_handle2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver calendertrain = new ChromeDriver();
        System.setProperty("chromedriver.exe", "L:/Study/chromedriver_win32");
        calendertrain.get("https://www.spicejet.com/");
        calendertrain.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        calendertrain.manage().window().maximize();
        calendertrain.findElement(By.xpath("//div[@data-testid='departure-date-dropdown-label-test-id']")).click();
        Thread.sleep(2000);

        int monthNumber = calendertrain.findElements(By.cssSelector(".css-76zvg2.r-homxoj.r-adyw6z.r-1kfrs79")).size();
        for(int i = 1; i<monthNumber;i++){
            String monthName = calendertrain.findElements(By.cssSelector(".css-76zvg2.r-homxoj.r-adyw6z.r-1kfrs79")).get(i).getText();
            while(!monthName.contains("November")){
                calendertrain.findElement(By.cssSelector(".r-1loqt21.r-u8s1d.r-11xbo3g.r-1v2oles.r-1otgn73.r-16zfatd.r-1i6wzkk.r-lrvibr.r-184en5c.css-1dbjc4n")).click();
            break;
            }

        }



    }
}
