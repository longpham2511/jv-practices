package Selenium_section15;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Selenium4_newfeatures {
    //@Test
    public void relative_locator(){
        /*
        Relative locator: - can use tag name to easily pick out elements
        above() element located above selected element
        below() element located below selected element
        toleftof() element located on the left of selected element
        toRightof() element located on the right of selected element
        driver.findElement(By.xpath("xxxx").above(Webelement));
         */
        WebDriver section15 = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "L:/Study/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        section15.get("https://rahulshettyacademy.com/angularpractice/");
        section15.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Above
        WebElement input_Name = section15.findElement(By.xpath("//div/input[@name='name']"));
        System.out.println(section15.findElement(with(By.tagName("label")).above(input_Name)).getText());
        //Below
        WebElement dob_Element = section15.findElement(By.xpath("//label[@for='dateofBirth']"));
        section15.findElement(with(By.tagName("input")).below(dob_Element)).click(); //a Flex HTML element - cannot be pick by this method
        //Left
        WebElement formlabel_Element = section15.findElement(By.xpath("//label[@for='exampleCheck1']"));
        section15.findElement(with(By.tagName("input")).toLeftOf(formlabel_Element)).click();
        //Right
        WebElement radiobutton1_Element = section15.findElement(By.id("inlineRadio1"));
        System.out.println(section15.findElement(with(By.tagName("label")).toRightOf(radiobutton1_Element)).getText());

    }

    //@Test
    public void invoke_multiple_winandtabs(){
        WebDriver section15 = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "L:/Study/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        section15.get("https://rahulshettyacademy.com/angularpractice/");
        section15.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        section15.switchTo().newWindow(WindowType.TAB); either tab or window, selenium can do both window simultaneously
        section15.switchTo().newWindow(WindowType.WINDOW);
        section15.get("https://www.rahulshettyacademy.com/");
        String url_Name = section15.findElements(By.xpath("//a[@href='https://courses.rahulshettyacademy.com/p/core-java-for-automation-testers-interview-programs']")).get(1).getText();
        System.out.println(url_Name);
        //window switcher
        Set<String> setofWin = section15.getWindowHandles();
        Iterator<String> winSwitcher = setofWin.iterator();
        String parentWin = winSwitcher.next();
        String childWin = winSwitcher.next();

        section15.switchTo().window(parentWin);
        section15.findElement(By.xpath("//div/input[@name='name']")).sendKeys(url_Name);
        section15.quit();
    }

//    @Test
    public void element_Screenshot() throws IOException {
        WebDriver section15 = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "L:/Study/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        section15.get("https://rahulshettyacademy.com/angularpractice/");
        section15.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        section15.switchTo().newWindow(WindowType.WINDOW);
        section15.get("https://www.rahulshettyacademy.com/");
        String url_Name = section15.findElements(By.xpath("//a[@href='https://courses.rahulshettyacademy.com/p/core-java-for-automation-testers-interview-programs']")).get(1).getText();
        System.out.println(url_Name);
        Set<String> setofWin = section15.getWindowHandles();
        Iterator<String> winSwitcher = setofWin.iterator();
        String parentWin = winSwitcher.next();
        String childWin = winSwitcher.next();
        section15.switchTo().window(parentWin);
        WebElement input_Element = section15.findElement(By.xpath("//div/input[@name='name']"));
        input_Element.sendKeys(url_Name);

        //Get a screenshot of the webelement
        File img_FILE = input_Element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(img_FILE,new File("input.png"));
        section15.quit();
    }
    @Test
    public void height_Weight(){
        WebDriver section15 = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "L:/Study/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        section15.get("https://rahulshettyacademy.com/angularpractice/");
        section15.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        section15.switchTo().newWindow(WindowType.TAB);
        section15.get("https://www.rahulshettyacademy.com/");
        String url_Name = section15.findElements(By.xpath("//a[@href='https://courses.rahulshettyacademy.com/p/core-java-for-automation-testers-interview-programs']")).get(1).getText();
        System.out.println(url_Name);
        Set<String> setofWin = section15.getWindowHandles();
        Iterator<String> winSwitcher = setofWin.iterator();
        String parentWin = winSwitcher.next();
        String childWin = winSwitcher.next();
        section15.switchTo().window(parentWin);
        WebElement input_Element = section15.findElement(By.xpath("//div/input[@name='name']"));
        input_Element.sendKeys(url_Name);

        //Get Height & Width
        System.out.println(input_Element.getRect().getHeight());
        System.out.println(input_Element.getRect().getWidth());
        System.out.println(input_Element.getRect().getDimension());
    }
}
