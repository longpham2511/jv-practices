package Selenium_section9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.sql.Driver;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Synchronized_practice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver section9 = new ChromeDriver();
        System.setProperty("chromedriver.exe", "L:/Study/chromedriver_win32");
        section9.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        section9.manage().window().maximize();
        String[] actualProducts = {"Tomato", "Potato", "Onion"};
        List actualProductsArrayList = Arrays.asList(actualProducts);
        Thread.sleep(1000);
        section9.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); //apply to every line of code, wait for 5 sec before labelling step as failure
        //or     section9.manage().timeouts().implicitlyWait(Duration.ofseconds(5));

        Synchronized_practice practiceA = new Synchronized_practice();
        WebDriverWait explicitwait = new WebDriverWait(section9, Duration.ofSeconds(5)); //wait for a specific step to be done
        practiceA.pickItems(section9, actualProductsArrayList, explicitwait);
    }

    public void pickItems(WebDriver section9, List actualProductsArrayList, WebDriverWait explicitwait) {

        List<WebElement> shoppingProducts = section9.findElements(By.xpath("//h4[@class='product-name']"));
        int count = 0;

        for (int i = 0; i < shoppingProducts.size(); i++) {
            String[] shoppingProductname = shoppingProducts.get(i).getText().split("-");
            String shoppingProductActual = shoppingProductname[0].trim();

            if (actualProductsArrayList.contains(shoppingProductActual)) {
                count++;
                section9.findElements(By.xpath("//div[@class='product-action']")).get(i).click();

                if (count == actualProductsArrayList.size()) {
                    System.out.println("Test 1: All item are added.");
                    break;
                }

            }

        }

        //open the cart
        section9.findElement(By.xpath("//a[@class='cart-icon']")).click();

        //check the items and click checkout
        section9.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

        //checkout process
        explicitwait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoCode")));
        section9.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
        section9.findElement(By.className("promoBtn")).click();
        explicitwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
        String promoinfo = section9.findElement(By.cssSelector(".promoInfo")).getText();
        Assert.assertEquals(promoinfo, "Code applied ..!");
        System.out.println("Test 2: Code applied");
    }


}
