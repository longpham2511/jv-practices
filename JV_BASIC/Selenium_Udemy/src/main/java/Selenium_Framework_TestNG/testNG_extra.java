package Selenium_Framework_TestNG;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testNG_extra {
    @Test
    public void demo_extra(){
        System.out.println("Hello from the extra side");
    }
    @Test
    public void demo_extra1(){
        System.out.println("Hello from the extra side 1");
    }

    @Test
    public void extra1(){
        System.out.println("Hello from the EXTRA");
    }
@BeforeTest
    public void extra2(){
        System.out.println("Hello from the EXTRA 2 - this is a before test annotation");
    }
}

