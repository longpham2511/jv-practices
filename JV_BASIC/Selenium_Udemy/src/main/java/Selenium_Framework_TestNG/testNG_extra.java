package Selenium_Framework_TestNG;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testNG_extra {
    @BeforeSuite //used this annotation to declare something globally - i.e. declare url
    public void demo_extra() {
        System.out.println("Bforesuite message");
    }

    @AfterSuite //used this annotation to declare something globally - i.e. clear cache
    public void demo_extra1() {
        System.out.println("Aftersuite message");
    }

    @Test
    public void extra1() {
        System.out.println("Hello from the EXTRA");
    }

    @BeforeTest
    public void extra2() {
        System.out.println("Hello from the EXTRA 2 - this is a before test annotation");
    }

    @Test(groups = {"grouptest"}) //put these test into a group
    public void group1() {
        System.out.println("Group Testing 1");
    }

    @Test(groups = {"grouptest"})
    public void group2() {
        System.out.println("Group Testing 2");
    }

    @Test(dependsOnMethods = {"tc_independ"})
    public void tc_depend1() {
        System.out.println("The depend test case will run after the independ one");
    }

    @Test
    public void tc_independ() {
        System.out.println("independ test case");
    }
    @Test(dependsOnMethods = {"tc_independ","tc_depend"})
    public void tc_depend2() {
        System.out.println("The 2nd depend test case will run after the depend and independ1 tc");
    }

    @Test(enabled = false) //can leave at true to run it again
    public void skip_tc() {
        System.out.println("you can skip this test case due to known issues");
    }

    @Test(timeOut = 5000) //if that test case takes a long time to finish, leave the timeout so it will wait and not throw any errors
    public void time_out() {
        System.out.println("time_out");
    }

}

