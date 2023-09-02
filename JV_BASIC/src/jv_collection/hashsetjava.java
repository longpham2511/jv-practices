package jv_collection;

import java.sql.SQLOutput;
import java.util.HashSet;

public class hashsetjava {
    public static void main(String[] args) {
        HashSet<String> HS = new HashSet<String>();
        //HS provides a unique set of contents
        HS.add("A");
        HS.add("B");
        HS.add("C");
        HS.add("D");
        HS.add("E");
        HS.add("A");
        System.out.println("The original HashSet is: "+HS);
        System.out.println("The size of this HashSet is: "+ HS.size());
        System.out.println("Removing 'F' which doesn't exist in HS: "+HS.remove("F"));
        System.out.println("Removing `A` which exists in HS: "+HS.remove("A"));
        System.out.println("Adding `G` in the HS"+HS.add("G"));
        System.out.println("The HS after editing: "+HS);
    }
}
