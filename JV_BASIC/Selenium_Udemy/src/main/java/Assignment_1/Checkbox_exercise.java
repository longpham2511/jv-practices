package Assignment_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.sql.SQLOutput;
import java.time.Duration;
import java.util.List;

public class Checkbox_exercise {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("chromedriver.exe", "L:/Study/chromedriver_win32");
        WebDriver AS1 = new ChromeDriver();
        AS1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        AS1.get("https://rahulshettyacademy.com/AutomationPractice/");
        AS1.manage().window().maximize();
        Thread.sleep(1000);

        //count checkbox + radiobutton
        Assert.assertEquals(AS1.findElements(By.xpath("//input[@class='radioButton']")).size(),3);
        Assert.assertEquals(AS1.findElements(By.xpath("//input[@type='checkbox']")).size(),3);

        //check if radiobutton is selected
        WebElement Radiobutton3 = AS1.findElement(By.xpath("//input[@value='radio3']"));
        Radiobutton3.click();
        if(Radiobutton3.isSelected()){
            System.out.println("RadioButton Check: PASSED");
        }
        else{
            System.out.println("RadioButton Check: FAILED");
        }

        //autofill box
        WebElement Autofillbox1 = AS1.findElement(By.id("autocomplete"));
        Autofillbox1.sendKeys("Vi");
        Thread.sleep(1000);
        List<WebElement> countrydropdown = AS1.findElements(By.xpath("//li[@class='ui-menu-item']"));
        for (WebElement i : countrydropdown){
            if(i.getText().equalsIgnoreCase("Vietnam")){
                i.click();
                break;
            }
        }
        Thread.sleep(1000);
        //Assert.assertEquals(Autofillbox1.getText(),"Vietnam");


        //check if checkbox is selected
        WebElement checkbox1 = AS1.findElement(By.xpath("//input[@name='checkBoxOption1']"));
        WebElement checkbox2 = AS1.findElement(By.xpath("//input[@name='checkBoxOption2']"));
        WebElement checkbox3 = AS1.findElement(By.xpath("//input[@name='checkBoxOption3']"));
        checkbox1.click(); //click
        checkbox1.click(); //un-click
        checkbox2.click();
        checkbox3.click();
        if(!checkbox1.isSelected()){
            System.out.println("Checkbox test 1: PASSED");
        }
        else{
            System.out.println("Checkbox test 1: FAILED");
        }
        if(checkbox2.isSelected()){
            System.out.println("Checkbox test 2: PASSED");
        }
        else{
            System.out.println("Checkbox test 2: FAILED");
        }
        if(checkbox3.isSelected()){
            System.out.println("Checkbox test 3: PASSED");
        }
        else{
            System.out.println("Checkbox test 3: FAILED");
        }



    }
}
