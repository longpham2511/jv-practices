package Selenium_section14;

import graphql.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java_stream {
    /*
    Java Stream and Lambda Expression for building optimized code
    1. Stream - can perform aggregate operations on the data return from collections by reducing the complexity of code
    2. Lambda Expression - introduce the arrow operator into java ->, it divides Jv into 2 parts:
    + the left side specifies the parameter required by the expression, can be empty if no parameters are required
    + the right side specifies the action of the lambda expression

    Working of Steam:
    1. Create a stream
    2. Perform intermediate operations on the OG steam to transfer it into another steam and so on
    3. Perform the terminal operation on the final stream to get the result
     */

    //@Test
    public void classicCollection() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Long");
        names.add("Khanh");
        names.add("James");
        names.add("Katherine");
        names.add("Larry");
        int count = 0;
        for(int i = 0; i < names.size(); i++){
            String elementIterator = names.get(i);
            if(elementIterator.startsWith("L")){
                count ++;
            }
        }
        System.out.println(count);
    }

    @Test
    public void streamfilter(){
        ArrayList<String> names = new ArrayList<String>();
        names.add("Long");
        names.add("Khanh");
        names.add("James");
        names.add("Katherine");
        names.add("Larry");

        //There is no life for intermediate op without terminal op
        //Terminal op only executes if inter op returns true

        // .filter(s->s.<<function>>)  -> intermediate op which filter element in the collection
        // .sorted()     -> sort function
        // map(s->s.<<function>>)       -> intermediate op to interact with the elements from the filtered list i.e. toUpperCase(),...
        // foreach(s-> s.<<function>> or <<sout>>)  -> Iterate the list, print out items
        // stream().concat() -> combine 2 list together
        // stream().allmatch() -> to check if there's a match in the list
        // collect() -> put new filter element into a new list

        long c = names.stream().filter(s ->s.startsWith("L")).count();
        System.out.println(c);

        //can be written as:

        long f = Stream.of("Long","Khanh","Longie","Kathy").filter(s->s.contains("L")).count();

        //can also be written as:

        long d = Stream.of("Long","Khanh","Longie","Kathy").filter(s->
        {
            s.contains("L");
            return false;               //if inter op returns false

        }).count();                     //terminal op won't execute

        //how to list all the elements in the List
        names.stream().filter(s->s.length()>4).limit(2).forEach(s-> System.out.println(s));

    }

    @Test
    public void streammap(){
        Stream.of("Long","Khanh","Longie","Kathy").filter(s->s.endsWith("g")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
        System.out.println();
        Stream.of("Long","Khanh","Longie","Kathy","Larry").filter(s->s.startsWith("K")).sorted().map(s->s.toUpperCase()).forEach(s-> System.out.println(s));
        System.out.println();

        ArrayList abc123 = new ArrayList();
        abc123.add("Long");
        abc123.add("LongPHAM");
        abc123.add("LongHP");

        List<String> abc = Arrays.asList("Khanh","MKhanh","KhanhMNL","NLMK","KhanhN","KhanhABC","Long");
        abc.stream().filter(s->s.startsWith("k")).sorted().map(s->s.toUpperCase()).forEach(s-> System.out.println(s));

        Stream <String> totalList = Stream.concat(abc.stream(), abc123.stream());           //concat helps to merge 2 lists
        //totalList.sorted().map(s->s.toUpperCase()).forEach(s-> System.out.println(s));
        //to check if there's any duplicated element in the list

        Boolean flag = totalList.anyMatch(s->s.equalsIgnoreCase("LONG"));
        System.out.println(flag);
        Assert.assertTrue(flag);

    }

    @Test
    public void streamCollect(){
        List<String> abc = Arrays.asList("Khanh","MKhanh","KhanhMNL","NLMK","KhanhN","KhanhABC","Long");
        List<String> newABC = abc.stream().filter(s->s.startsWith("Kh")).sorted().collect(Collectors.toList());
        System.out.println(newABC);
        System.out.println(newABC.get(1)); //or you can just use limit
        abc.stream().filter(s->s.startsWith("Kh")).sorted().limit(1).collect(Collectors.toList());

        List<Integer> values = Arrays.asList(7,9,11,1,2,2,3,3,4,5,6);
        values.stream().distinct().sorted().forEach(s-> System.out.println(s)); //sortedly distict list
        List<Integer>newValues = values.stream().sorted().distinct().limit(3).collect(Collectors.toList()); //print the first 3 index
        System.out.println(newValues.get(2)); //get the 3rd index


    }

}




