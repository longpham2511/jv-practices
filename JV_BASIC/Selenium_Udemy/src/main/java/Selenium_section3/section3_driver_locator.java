package Selenium_section3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class section3_driver_locator {
    public static void main(String[] args) {
        WebDriver section3 = new ChromeDriver();
        System.setProperty("chromedriver.exe","L:/Study/chromedriver_win32");
        section3.get("https://rahulshettyacademy.com/locatorspractice/");

        //locators used to identify HTML elements on a web page
        //different type of locators: ID, Xpath, CSS Selector, name, Class Name, Tag Name, Link Text, Partial Link Text
        //filling up details
        //<input type="text" placeholder="Username" id="inputUsername" value="">
        // input = tag name
        // type, placeholder, id, value = attribute
        //"text", "Username",.... = attribute's values

        section3.findElement(By.id("inputUsername")).sendKeys("longpham2511@gmail.com");
        section3.findElement(By.name("inputPassword")).sendKeys("3Thl2511.");
        section3.findElement(By.className("submit")).click();


        //2 locators to pinpoint exactly where web elements are; they are the most popular locators
        // due to the fact that many id, class name may get designed to be repeated
        //CSS and Xpath helps to locate these elements

        //1. Css Selector
        //<button class="submit signInBtn" type="submit">Sign In</button>
        //-> Class name -> tagname.classname -> button.signInBtn
        //<input type="text" placeholder="Username" id="inputUsername" value="">
        //-> Id -> tagname#id -> input#inputUsername
        //-> Tagname[attribute='value'] -> input[placeholder='Username']
        //<input type="text" placeholder="Email" data-keeper-lock-id="k-d10x1mmxjv" style="" xpath="2">
        // input[type='text']:nth-child(2)
        // tagname (if there's only 1 unique tagname)
        // <parent tagname> <child tagname>

        //can also do this in console with the format $('<CSS Selector>') -> $('input.Username')
        //if this returns as "null" there is no value

        //cannot find p.error because the browser load so fast
        //implicit wait - 5s only
        section3.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //tell Selenium to wait for 5s before giving the result

        System.out.println(section3.findElement(By.cssSelector("p.error")).getText());

        //assert section3.findElement(By.className("Error")).equals("* Incorrect username or password");

        //<a href="#">Forgot your password?</a>
        // tag name a = link text
        section3.findElement(By.linkText("Forgot your password?")).click();

        //2. Xpath
        //  //Tagname[@attribute='value']   -> //input[@placeholder='Name'] -> make it CSS input[placeholder='Name']
        //  //Tagname[@attribute='value'][index]
        // <input type="text" placeholder="Email" data-keeper-lock-id="k-d10x1mmxjv" style="" xpath="2">
        // parent to child tag -> //<parent tag>/<child tag>[<index>]
        // //tagname (if there's only 1 unique tagname)

        //Check on console: for CSS use $(<expression>) for xpath $('<expression>')
        section3.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Long Pham");
        section3.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("abc@gmail.com");
        section3.findElement(By.xpath("//input[@type='text'][3]")).sendKeys("911");
        //section3.findElement(By.cssSelector("input[placeholder='Phone Number']")).clear();
        //section3.findElement(By.cssSelector("input[type='text']:nth-child(4)")).sendKeys("911");
        section3.findElement(By.cssSelector("button.reset-pwd-btn")).click();
        System.out.println(section3.findElement(By.cssSelector("form p")).getText());
        //section3.close();




    }
}
