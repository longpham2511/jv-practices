package Assignment_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class UI_TESTING {

    //Assignment 2: UI(Dropdowns,EditBoxes,Error Valdiation) Assignment
    public static void main(String[] args) throws InterruptedException {
        String name = "Long Pham";
        String email = "lp2511@gmail.com";
        String password = "3Thl12345";

        WebDriver assignment2 = new ChromeDriver();
        System.setProperty("chromedriver.exe", "L:/Study/chromedriver_win32");
        assignment2.get("https://rahulshettyacademy.com/angularpractice/");
        assignment2.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //actions - keys and check boxes
        assignment2.findElement(By.xpath("//div/input[@name='name']")).sendKeys(name);
        assignment2.findElement(By.xpath("//div/input[@name='email']")).sendKeys(email);
        assignment2.findElement(By.id("exampleInputPassword1")).sendKeys(password);
        assignment2.findElement(By.id("exampleCheck1")).click();

        //actions - dropdowns
        WebElement dropdown_gender = assignment2.findElement(By.id("exampleFormControlSelect1"));
        dropdown_gender.click();
        assignment2.findElement(By.xpath("//option[text()='Male']")).click();
        System.out.println(dropdown_gender.getText());
        assignment2.findElement(By.xpath("//div/input[@name='bday']")).sendKeys("11/25/1997");

        //Assertion, verification
        assignment2.findElement(By.className("btn-success")).click();
        Thread.sleep(5000);
        if(assignment2.findElement(By.id("exampleCheck1")).isSelected()){
            System.out.println("Test 1: checkbox is selected - Passed");
        }
        else {
            System.out.println("Test 1: Failed");
        }
        System.out.println(assignment2.findElement(By.className("alert-success")).getText());;
    }
}
