package Selenium_section8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Ecommerce_Practice {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("chromedriver.exe", "L:/Study/chromedriver_win32");
        WebDriver section8 = new ChromeDriver();
        section8.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        section8.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        section8.manage().window().maximize();


        // ecommerce website has the same value for their buttons, have to check for the items' name to interact with their buttons

        Ecommerce_Practice shopping_style = new Ecommerce_Practice();
        shopping_style.pickmultipleitems(section8);

        section8.close();
        }

    public void pickmultipleitems(WebDriver section8){

        // create an array
        String[] multipleitems = {"Beetroot","Cauliflower","Carrot","Beans"};

        // turn this array to array list to use containelement()
        List shoppinglist =  Arrays.asList(multipleitems);

        //make a list out of available items on the ecommerce page
        List<WebElement> items = section8.findElements(By.xpath("//h4[@class='product-name']"));

        // add a counter to know how many times it picks an item from the list
        int a = 0;
        for(int i = 0; i < items.size(); i++){
            String[] productlist = items.get(i).getText().split("-");
            String productname = productlist[0].trim();

            if (shoppinglist.contains(productname)){
                a++;
                section8.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

        // do not include break in a multiple selection, it will cut off the process after finding the first item, instead do it like this
                if(a == multipleitems.length){
                    System.out.println("All three items were added");
                    break;
                }
            }
        }

    }


    public void pick1item(WebDriver section8) {

        String picked_item1 = "Beetroot";
        List<WebElement> items = section8.findElements(By.xpath("//div[@class='product']"));
        for (int i = 0; i < items.size(); i++) {
            String productnameActual = items.get(i).getText();
            if (productnameActual.contains(picked_item1)) {
                section8.findElements(By.xpath("//button[@type='button']")).get(i).click();
                break;
            }
        }

    }
}