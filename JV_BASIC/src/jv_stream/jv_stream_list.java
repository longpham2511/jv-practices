package jv_stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class jv_stream_list {
    public static void main(String[] args) {

        //average_calculator
        List<Integer> numlist = Arrays.asList(5, 20, 30, 30, 15);
        System.out.println("The number list is " + numlist);
        double average = numlist.stream().mapToDouble(Integer::doubleValue).average().orElse(0.0);
        System.out.println("Average of the list is " + average);

        //Uppercase to Lower case and vice versa
        System.out.println();
        List<String> fruits = Arrays.asList("apple", "pear", "orange", "grape");
        System.out.println();
        System.out.println("These are the items in the list: " + fruits);
        System.out.println();
        fruits.stream().forEach(System.out::println);
        System.out.println();
        List<String> upperfruits = fruits.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("Uppercase fruits: " + upperfruits);
        List<String> lowerfruits = fruits.stream().map(String::toLowerCase).collect(Collectors.toList());
        System.out.println("Lowercase fruits: " + lowerfruits);

        //List out 2nd smallest
        List<Integer> listofnum = Arrays.asList(10, 25, 30, 4, 48, 21, 44, 10);
        System.out.println("List of numbers: " + listofnum);
        Integer biggestnum = listofnum.stream().distinct().sorted().skip(0).findFirst().orElse(null);
        System.out.println(biggestnum);


    }

}
