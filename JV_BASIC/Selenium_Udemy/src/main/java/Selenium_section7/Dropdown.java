package Selenium_section7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {
    public static void main(String[] args) {
        //if System.setProperty("chromedriver.exe", "L:/Study/chromedriver_win32") is set
        //Selenium Manager is off, new Selenium version doesn't need to set property (beta feature)

        /*
        in Section 7, selenium automation - web element:
        static dropdown - select tagname, option does not change
        dynamic dropdown
        checkboxes
        radio buttons
        text buttons
        alert java popups
        selenium webdriver form methods
         */
        Dropdown static_dropdown = new Dropdown();
        static_dropdown.static_dropdown();



    }
    public void static_dropdown(){
        WebDriver section7 = new ChromeDriver();
        section7.manage().window().maximize();
        section7.get("https://www.rahulshettyacademy.com/dropdownsPractise/");
        WebElement staticdropdown = section7.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(staticdropdown);
        dropdown.selectByIndex(3);
        System.out.println(dropdown.getFirstSelectedOption().getText());
        dropdown.selectByVisibleText("AED");
        System.out.println(dropdown.getFirstSelectedOption().getText());
    }
}
