package Selenium_Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_section2 {
    public static void main(String[] args) {
        //invoking Browser
        //Chrome - ChromeDriver -
        //Java OOP create an object to access the methods
        //Web driver is an Interface - is a group of related methods without the body
        //when a class uses an interface, it has to provide implementation/bodies to all defined methods (Abstract method OOP)
        //classes like ChromDriver, FirefoxDriver, SafariDriver,.... implement the web driver interface and provide their own implementation of web driver method
        //we need to create an object of a class to access the methods of the class

        //webdriver methods + class method
            // ChromeDriver CD = new ChromeDriver(); //CD has access to all the methods of Chrome driver
        //when using CD, it's only worked in ChromeDriver
        //CD might not work in other browser because it only accesses Chrome driver methods
        //WebDriver WD = new ChromeDriver(); //WD has access to methods of Chromedriver which are defined in Web Driver Interface
        //WD will have the knowledge of which only webdriver implementation of Chromedriver

        //Chromedriver.exe -> Chrome browser
        //Step to invoke Chrome driver
        System.setProperty("chromedriver.exe","L:/Study/chromedriver_win32");
        WebDriver WD = new ChromeDriver();
        //Selenium Manager
        WD.get("https://rahulshettyacademy.com/#/index");
        System.out.println("Title: " + WD.getTitle());
        System.out.println("URL: " + WD.getCurrentUrl());
        System.out.println("Page Source: " + WD.getPageSource());

        //WD.close(); //closing a current tab
      //  WD.quit(); //closing any browsers that is associated to selenium



    }
}
