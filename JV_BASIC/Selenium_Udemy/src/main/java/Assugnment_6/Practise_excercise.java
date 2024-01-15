package Assugnment_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Practise_excercise {

    /*
        exercise
        1. Select a checkbox, get the title of that checkbox
        2. The title of checkbox from step 1, will be the option of another dropdown
        3. send the title of step 1 to alert text box, click alert and grab text to see if the title of step 1 show up in alert
        4. Do not hard code the label
         */
    public static void main(String[] args) {
        WebDriver assignment6 = new ChromeDriver();
        System.setProperty("chromedriver.exe", "L:/Study/chromedriver_win32");
        assignment6.get("https://rahulshettyacademy.com/AutomationPractice/#");
        assignment6.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        //        1. Select a checkbox, get the title of that checkbox
        String pickedOption = assignment6.findElement(By.xpath("//label[@for='honda']")).getText();
        assignment6.findElement(By.xpath("//label[@for='honda']")).click();

        //        2. The title of checkbox from step 1, will be the option of another dropdown
        WebElement dropdown1 = assignment6.findElement(By.id("dropdown-class-example"));
        Select dropdownfunc = new Select(dropdown1);
        dropdownfunc.selectByVisibleText(pickedOption);

        //        3. send the title of step 1 to alert text box, click alert and grab text to see if the title of step 1 show up in alert
        assignment6.findElement(By.xpath("//input[@id='name']")).sendKeys(pickedOption);
        assignment6.findElement(By.id("alertbtn")).click();

        String alertPrompt = assignment6.switchTo().alert().getText();
        if (alertPrompt.contains(pickedOption)) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }


    }
}
