package Selenium_Framework_TestNG;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class testNG_Framework1 {
    /*
    TestNG acts as a Java compiler, instead of putting psvm-main method, testng can replace it
    Need to have @Test annotation followed by a method to run
    can define multiple tests from a single class
    can modularize the testcase based on functionality and trigger them accordingly
    u can get control running a specific test case
    Test suite -> Test folder (module) -> test cases
    test case (method) < class (module) < test < suite
    @BeforeTest/AfterTest -
    @beforeSuite/AfterSuite - declare globally
    @BeforeMethod/AfterMethod - Beforemethod - method 1 - aftermethod - beforemethod - method 2 - aftermethod -....
    @Beforeclass/Afterclass
    @Test(groups={"<<GroupName>>"})

    Test cases will be run alphabetical order without annotations

    Interview questions:
    - Testng - timeout - to wait for a period of time before giving error
             - enabled = false/ true - to disable a test case and run the test suite
             - @test(group={"hehe"}) - give tc tags to run them separately
             - @test(dependsonMethod={"method1"}} - this dependent method will be executed after the mentioned tc
             - 2 ways to parameterlize: drive data from xml testng file or using @dataprovider annotation
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
