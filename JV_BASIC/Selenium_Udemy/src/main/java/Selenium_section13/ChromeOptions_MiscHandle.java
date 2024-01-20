package Selenium_section13;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;

public class ChromeOptions_MiscHandle {
    public static void main(String[] args) throws IOException {
        //Chromeoption capabilities: https://chromedriver.chromium.org/capabilities
        //Use ChromeOptions to bypass any expired ssl url, customise your ChromeDriver session
        //can use Options for different browser as well i.e. Firefox.Options
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);

        //Use Proxy to set the Proxy to access URL
//        Proxy proxy = new Proxy();
//        proxy.setHttpProxy("<<input proxy ip addr>>");
//        options.setCapability("proxy",proxy);

        WebDriver section13 = new ChromeDriver(options);
        System.setProperty("webdriver.chromedriver.exe", "L:/Study/chromedriver-win64/chromedriver-win64/chromedriver.exe");

        //Bypass expired ssl url thanks to ChromeOptions
//        section13.get("https://expired.badssl.com/");
//        System.out.println(section13.getTitle());

        /* delete all cookies
        Test scenario:
        1. Sign up
        2.login-verify login
        3. clear cookies
        4. sign in again
         */
//        section13.manage().deleteAllCookies();
//        section13.manage().deleteCookieNamed("<<cookies name>>");

        //Downnload file - one of ChromeOptions functionality
//        Map<String, Object> prefs = new HashMap<String, Object>();
//        prefs.put("download.default_directory", "/directory/path");
//        options.setExperimentalOption("prefs", prefs);

        //To take screenshot, webdriver object need to change into TakeScreenshot
        //If user is not an admin and is not allowed to download into storage C, then use the path to C:../user/<<username>>
        section13.get("https://www.google.com/");
        File src = ((TakesScreenshot)section13).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File("L:/screenshot.png"));



    }
}
