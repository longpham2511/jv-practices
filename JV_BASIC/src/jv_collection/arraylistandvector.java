package jv_collection;
import java.util.ArrayList;

//URL: https://www.w3resource.com/java-tutorial/java-arraylist-and-vector.php
public class arraylistandvector {
    public static void main(String[] args) {
        ArrayList<String> tropicalfruits = new ArrayList<String>();
        tropicalfruits.add("Starfruit");
        tropicalfruits.add("Mango");
        tropicalfruits.add("Durian");
        tropicalfruits.add("Avocado");
        for (String i : tropicalfruits){
            System.out.println(i);
        }
        System.out.println();
        tropicalfruits.add(0, "Concac");
        tropicalfruits.add(3,"Dragonfruit");
        System.out.println("The updated tropical fruits list is: " + tropicalfruits);
        System.out.println("The fruit at index 2 is: " + tropicalfruits.get(2));
        System.out.println("The fruit at index 5 is: " + tropicalfruits.get(5));
        System.out.println("The size of the Array now is: " + tropicalfruits.size());
        System.out.println("Removing a fruit at index 4, which is " + tropicalfruits.remove(4) +" and the updated list is: " + tropicalfruits);
        System.out.println("The size of the Array now is: " + tropicalfruits.size());
        System.out.println("Does the list contain 'Mango': "+tropicalfruits.contains("Mango"));

    }

}
