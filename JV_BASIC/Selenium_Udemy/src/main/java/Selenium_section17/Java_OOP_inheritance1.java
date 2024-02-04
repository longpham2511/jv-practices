package Selenium_section17;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Java_OOP_inheritance1 {
    public void doThis(){
        System.out.println("This is from inheritance 1");
    }

    @BeforeMethod
    @Test
    public void b4Test(){
        System.out.println("Before method here");
    }
}
