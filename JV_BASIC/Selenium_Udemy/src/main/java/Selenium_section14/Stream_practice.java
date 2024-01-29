package Selenium_section14;

import graphql.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class Stream_practice {

    /*
        Sorting a list
        1. Click on a list to sort the list
        2. capture all element in the list - list A
        3. capture text of all web elements
        4. sort in the list - list B
        5. compare list A and B
         */

    public static void main(String[] args) {
        WebDriver section14 = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "L:/Study/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        section14.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        section14.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        section14.findElement(By.className("sort-icon")).click();

        List<WebElement> ogList = section14.findElements(By.xpath("//tbody/tr/td[1]"));
        List<String> streamogList = ogList.stream().map(s->s.getText()).collect(Collectors.toList());
        List<String> sortedstreamogList = streamogList.stream().sorted().collect(Collectors.toList());
        Assert.assertTrue(streamogList.equals(sortedstreamogList));

        ////tbody/tr/td[1]/following-sibling::td[1] moving to another sibling column... cannot use //tbody/tr/td[2] -> as it counts from the begining

        //Problem: make a stream list in which the iterator will stop at an item and get the price out of the item
        // do a Stream to filter out the correct item and get its related price
        List<String> therightoption = ogList.stream().filter(s->s.getText().contains("Beans")).map(s->getPrice(s)).collect(Collectors.toList());
        therightoption.stream().forEach(s-> System.out.println(s));

        //Problem: What if the elements is not on the same page?
        // make a Do -While loop, search for element, if it cannot be found -> move to the next list
        // * be careful when move to the next page of the table
        List<String> secondrightoption;
        do {
            List<WebElement> differentpage_ogList = section14.findElements(By.xpath("//tbody/tr/td[1]")); //when moving to another page, we need to pick the pinpoint the column again
            secondrightoption = differentpage_ogList.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPrice(s)).collect(Collectors.toList());
            secondrightoption.stream().forEach(s-> System.out.println(s));
            if (secondrightoption.size() < 1) {
                section14.findElement(By.xpath("//a[@aria-label='Next']")).click();
            }
        }while(secondrightoption.size() < 1);

        //Problem: Query a search for item "Rice"
        //Check if the results contains the keyword
        /*
        1. put keys down the search bar
        2. get element names on the list
        3. filter to all the element contains the word "Rice"
        4. compare the filter list with the element names on the list
         */
        String shoppingitem = "Rice";
        section14.findElement(By.xpath("//input[@id='search-field']")).sendKeys(shoppingitem);
        List<WebElement> search_item = section14.findElements(By.xpath("//tbody/tr/td[1]"));
        List<WebElement> filter_searchitem = search_item.stream().filter(a->a.getText().contains(shoppingitem)).collect(Collectors.toList());
        Assert.assertTrue(search_item.equals(filter_searchitem));


    }

    private static String getPrice(WebElement s) {
        String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText(); //xpath - sibling on the same row, so no need to put // in the front
        return pricevalue;


    }
}
