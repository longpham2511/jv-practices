package Selenium_Framework_TestNG;

import org.testng.Assert;
import org.testng.annotations.*;

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

    @Test(dependsOnMethods = {"tc_independ", "tc_depend1"})
    public void tc_depend2() {
        System.out.println("The 2nd depend test case will run after the depend and independ1 tc");
    }

    @Test(enabled = false) //can leave at true to run it again
    public void skip_tc() {
        System.out.println("you can skip this test case due to known issues");
    }

    @Test(timeOut = 5000)
    //if that test case takes a long time to finish, leave the timeout so it will wait and not throw any errors
    public void time_out() {
        System.out.println("time_out");
    }

    @Parameters({"URL"})
    @Test
    //By putting the parameter in the xml file, you can use for any test cases, String urlname will utilize the string from the parameter
    public void parameter_usage(String urlname) {
        System.out.println("By putting the parameter in the xml file, you can use for any test cases " + urlname);
    }
    @Parameters({"URL","APIKey"})
    @Test
    //By putting the parameter in the xml file, you can use for any test cases, String urlname will utilize the string from the parameter
    public void parameter_usage1(String urlname, String apiKeys) {
        System.out.println("Local overidden parameter" + urlname);
        System.out.println("This is the APIKEY: "+apiKeys);
    }

    @DataProvider
    @Test
    public Object[][] Getdata(){
        /*
        Data scenario:
        TC1: username + password - good credit data = row
        TC2: username + password - no credit data
        TC3: fraud reported data

        This is a multi array concept
         */
        Object[][] data = new Object[3][2];  //3 times using these 2 variables (username + pass)
        //1st set
        data[0][0] = "firstusername";   //row 1 column 1
        data[0][1] = "firstpass";       //row 1 column 2
        //2nd set
        data[1][0] = "2nd_username";    //row 2 column 1
        data[1][1] = "2nd_pass";        //row 2 column 2
        //3rd set
        data[2][0] = "3rd_username";
        data[2][1] = "3rd_username";
        return data;
    }

    @Test (dataProvider = "Getdata")
    public void receivedata(String username, String password){
        System.out.println(username);
        System.out.println(password);

    }

    @Test
    public void failTC(){
        Assert.assertTrue(false);
    }


}

