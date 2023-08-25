import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
//        int a = 5;
//        int b = 10;
//        int result = a+b;
//        System.out.println(result);

//        Scanner s = new Scanner(System.in);
//        ArrayList<Integer> arraylist1 = new ArrayList();
//        arraylist1.add(10);
//        arraylist1.add(20);
//        arraylist1.add(30);
//        arraylist1.add(40);
//        arraylist1.add(10);
//        System.out.println(arraylist1);
//          System.out.println("Please input a num");
//     int num2 = s.nextInt();
//     arraylist1.add(num2);
//        System.out.println("Your new arraylist1 will be: " +arraylist1);
//        System.out.println((arraylist1.indexOf(10) == 0 || arraylist1.indexOf(arraylist1.lastIndexOf(arraylist1)) == -1 ));
//        System.out.println(arraylist1.indexOf(10));
//        System.out.println(arraylist1.indexOf(arraylist1.lastIndexOf(arraylist1)));

        // int num1 = s.nextInt();
//        String name = s.next();
//        System.out.println("your input is " + name);
//        System.out.println("The first letter of ur input is: "+ name.charAt(0));
//        int l = name.length();
//        if (l<=3){
//            System.out.println(name.substring(0,4));
//        }
//        else {
//            System.out.println("####");
//        }


//        for (int i = 0; i<=10;i++){
//            System.out.println(num1 +" x "+ i + " = "+(num1*i));
//        }

        int[] array1={10,20,9,8,4,23};
        int[] array2={30,40,60,70,20,80};
        System.out.println("The Array contains: "+ Arrays.toString(array1));
        Arrays.sort(array1);
        System.out.println("The sorted Array would be: " + Arrays.toString(array1));
        HashSet<Integer> HS = new HashSet<Integer>();
        for(int i=0;i <array1.length;i++){
            for(int j = 0; j <array2.length;j++){
                if(array1[i] == array2[j]){
                    HS.add(array1[i]);
                }
            }
        }
        System.out.println("Common number will be: "+HS);
    }
}