package Selenium_section13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.SoftAssert;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class Broken_URL {
    public static void main(String[] args) throws IOException {
        //automate broken links with selenium -URL not working
        // java method can get the status code from the url - API 400 or 500
        /*
        step 1 get all url
        get the url status code
        if the status code has 400 status code -> fail
         */
        ChromeOptions Chroptions = new ChromeOptions();
        WebDriver section13 = new ChromeDriver(Chroptions);
        section13.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> footerLinks = section13.findElements(By.xpath("//li/a"));
        SoftAssert softResult = new SoftAssert(); //by using softassert, if the test fails, it won't stop but continuing testing the rest of the test suite

        for (WebElement links : footerLinks) {
            String webLinks = links.getAttribute("href");
            HttpURLConnection conn = (HttpURLConnection) new URL(webLinks).openConnection(); //conn is the object that will check the url. This is a JV method
            conn.setRequestMethod("HEAD");                       //send request
            conn.connect();
            int responseCode = conn.getResponseCode();           //get response

            softResult.assertTrue(responseCode<400,webLinks + " is broken. Error Code: "+responseCode);

//            if (responseCode >= 400) {
//                System.out.println(webLinks + " has a broken URL. Error Code is "+responseCode);
//                //Assert.assertTrue(false);
//            } else  {
//                System.out.println(webLinks + " works just fine.");
//                //Assert.assertTrue(true);
//            }

        }
        softResult.assertAll(); //report issues at the end


//        String urlName = section13.findElement(By.xpath("//li/a[text()='Broken Link']")).getAttribute("href");
//        HttpsURLConnection conn = (HttpsURLConnection) new URL(urlName).openConnection(); //conn is the object that will check the url. This is a JV method
//        conn.setRequestMethod("HEAD");                       //send request
//        conn.conn();
//        int responseCode = conn.getResponseCode();           //get response
//        System.out.println(responseCode);


    }
}
