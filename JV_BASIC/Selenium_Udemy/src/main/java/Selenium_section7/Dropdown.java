package Selenium_section7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Dropdown {
    public static void main(String[] args) throws InterruptedException {
        //if System.setProperty("chromedriver.exe", "L:/Study/chromedriver_win32") is set
        //Selenium Manager is off, new Selenium version doesn't need to set property (beta feature)

        /*
        in Section 7, selenium automation - web element:
        static dropdown - select tagname, option does not change
        dynamic dropdown - can only pick if user click on the dropdown first. dropdowns that affect one another, pick element A from dropdown 1 will generate unique data in dropdown 2
                            - (//a[@value='MAA'])[2] - Selenium scan from left to right, so if there are 2 same elements in the dropdown, you can pick the 2nd one by doing this
        checkboxes
        radio buttons
        text buttons
        alert java popups
        selenium webdriver form methods
         */
        WebDriver section7 = new ChromeDriver();
        section7.manage().window().maximize();
        section7.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        section7.get("https://www.rahulshettyacademy.com/dropdownsPractise/");

        Dropdown test = new Dropdown();
        //test.static_dropdown(section7);
        test.dynamic_dropdown(section7);
        section7.close();

    }
    public void static_dropdown(WebDriver section7){
        WebElement staticdropdown = section7.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(staticdropdown);
        dropdown.selectByIndex(3);
        System.out.println(dropdown.getFirstSelectedOption().getText());
        dropdown.selectByVisibleText("AED");
        System.out.println(dropdown.getFirstSelectedOption().getText());
    }

    public void dynamic_dropdown (WebDriver section7) throws InterruptedException {
        section7.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        section7.findElement(By.xpath("//a[@value='IXG']")).click();
        Thread.sleep(1000);
        section7.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='AMD']")).click();

        //section7.findElement(By.xpath("(//a[@value='AMD'])[2]")).click();
        //or being a dynamic dropdown, you can pinpoint the table in which contains the element
        // parent and child relationship XPATH -> //div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='AMD']
    }
}
