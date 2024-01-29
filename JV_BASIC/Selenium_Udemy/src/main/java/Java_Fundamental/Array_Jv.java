package Java_Fundamental;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array_Jv {
    public static void main(String[] args) {

        //Array declares the quantity of elements within its size

        int[] arr1 = new int[5];
        arr1[0] = 1;
        arr1[1] = 2;
        arr1[2] = 3;
        arr1[3] = 4;
        for ( int i : arr1){
            System.out.println(i);
        }
        System.out.println(arr1.length);

        System.out.println();
        int [] arr2 = {10,15,20,25};
        //arr2[5] = 2; -> this cannot be added into the array as it's already declared
        for (int m : arr2){
            System.out.println(m);
        }

        System.out.println();
        String[] games = {"COD","Battlefield","FPS"};
        for (String n : games){
            System.out.println(n);
        }

        List listofGames = Arrays.asList(games);

        ArrayList arraylistofGames = new ArrayList(List.of(games));


    }
}
