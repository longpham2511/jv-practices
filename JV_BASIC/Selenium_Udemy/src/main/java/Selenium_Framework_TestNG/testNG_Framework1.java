package Selenium_Framework_TestNG;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class testNG_Framework1 {
    /*
    TestNG acts as a Java compiler, instead of putting psvm-main method, testng can replace it
    Need to have @Test annotation to run
     */
    @Test
    public void demo1(){
        System.out.println("Hello World");
    }

    @AfterTest
    public void demo2(){
        System.out.println("Bye World");
    }

}
