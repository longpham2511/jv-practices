package jv_stream;

import java.util.Arrays;
import java.util.List;

public class jv_stream_list {
    public static void main(String[] args) {

        //average_calculator
            List<Integer> numlist = Arrays.asList(5, 20, 30, 30, 15);
            System.out.println("The number list is " + numlist);
            double average = numlist.stream().mapToDouble(Integer::doubleValue).average().orElse(0.0);
            System.out.println("Average of the list is " + average);


    }

}
