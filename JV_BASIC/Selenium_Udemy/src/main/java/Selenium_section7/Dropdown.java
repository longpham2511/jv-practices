package Selenium_section7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Dropdown {
    public static void main(String[] args) throws InterruptedException {
        //if System.setProperty("chromedriver.exe", "L:/Study/chromedriver_win32") is set
        //Selenium Manager is off, new Selenium version doesn't need to set property (beta feature)

        /*
        in Section 7, selenium automation - web element:
        static dropdown - select tagname, option does not change
        dynamic dropdown - can only pick if user click on the dropdown first. dropdowns that affect one another, pick element A from dropdown 1 will generate unique data in dropdown 2
                            - (//a[@value='MAA'])[2] - Selenium scan from left to right, so if there are 2 same elements in the dropdown, you can pick the 2nd one by doing this
        auto selective dropdown - dropdown that suggests options when user types in there
        checkboxes
        radio buttons
        text buttons
        alert java popups
        selenium webdriver form methods
         */
        System.setProperty("chromedriver.exe", "L:/Study/chromedriver_win32");

        WebDriver section7 = new ChromeDriver();
        section7.manage().window().maximize();
        section7.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        //section7.get("https://www.rahulshettyacademy.com/dropdownsPractise/");

        Dropdown test = new Dropdown();
        //test.static_dropdown(section7);
        test.handling_checkbox(section7);
        section7.close();

    }
    public void static_dropdown(WebDriver section7){
        WebElement staticdropdown = section7.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(staticdropdown);
        dropdown.selectByIndex(3);
        System.out.println(dropdown.getFirstSelectedOption().getText());
        dropdown.selectByVisibleText("AED");
        System.out.println(dropdown.getFirstSelectedOption().getText());
    }

    public void dynamic_dropdown (WebDriver section7) throws InterruptedException {
        section7.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        section7.findElement(By.xpath("//a[@value='IXG']")).click();
        Thread.sleep(1000);
        section7.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='AMD']")).click();

        //section7.findElement(By.xpath("(//a[@value='AMD'])[2]")).click();
        //or being a dynamic dropdown, you can pinpoint the table in which contains the element
        // parent and child relationship XPATH -> //div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='AMD']
    }

    public void selective_dropdown(WebDriver section7) throws InterruptedException {
        section7.findElement(By.id("autosuggest")).sendKeys("uni");
        Thread.sleep(3000);
        List<WebElement> selective_dropdown_elements = section7.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        for (WebElement i : selective_dropdown_elements){
            if(i.getText().equalsIgnoreCase("United States (USA)")){
                i.click();
                break; //for loop to break when a matching string is found
            }
        }

    }

    public void handling_checkbox(WebDriver section7) throws InterruptedException {
        section7.get("https://www.spicejet.com/");
        Thread.sleep(5000);
        System.out.println(section7.findElements(By.xpath("//div[@class='css-76zvg2 r-cqee49 r-1enofrn r-1ozqkpa']")).size());
        System.out.println(section7.findElement(By.xpath("//div[@class='css-76zvg2 r-cqee49 r-1enofrn r-1ozqkpa'][contains(text(),'Family & Friends')]")).isEnabled()); //check if the element is present
        section7.findElement(By.xpath("//div[@class='css-76zvg2 r-cqee49 r-1enofrn r-1ozqkpa'][contains(text(),'Family & Friends')]")).click();
        WebElement chkbox = section7.findElement(By.xpath("//div[@class='css-76zvg2 r-cqee49 r-1enofrn r-1ozqkpa'][contains(text(),'Family & Friends')]"));
        if (!chkbox.isEnabled()){
            System.out.println("The box is not checked.");
        }
        else{
            System.out.println("The box is checked.");
        }
        System.out.println(section7.findElement(By.xpath("//div[@class='css-76zvg2 r-cqee49 r-1enofrn r-1ozqkpa'][contains(text(),'Family & Friends')]")).isEnabled()); //check if the element is present

        section7.findElement(By.xpath("//div[text()='Senior Citizen']")).click();
        section7.findElement(By.xpath("//div[text()='Unaccompanied Minor']")).click();
        section7.findElement(By.xpath("//div[@class='css-1dbjc4n']/div[text()='Govt. Employee']")).click();
        System.out.println("\n\tBefore adding passengers: " + section7.findElement(By.xpath("//div[@data-testid='home-page-travellers']")).getText());
        section7.findElement(By.xpath("//div[@data-testid='home-page-travellers']")).click();
        Thread.sleep(1000);
        int clicking_time = 0;
        while (clicking_time <4){
            section7.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
            clicking_time++;
        }
        System.out.println("\n\tAfter adding passengers: " + section7.findElement(By.xpath("//div[@data-testid='home-page-travellers']")).getText());
        section7.findElement(By.xpath("//div[@data-testid='home-page-travellers-done-cta']")).click();
    }
}
