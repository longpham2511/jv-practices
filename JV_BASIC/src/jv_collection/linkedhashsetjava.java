package jv_collection;
import java.util.LinkedHashSet;
import java.util.Iterator;


public class linkedhashsetjava {
    public static void main(String[] args) {
        LinkedHashSet<String> randoms = new LinkedHashSet<>();
        randoms.add("bagels");
        randoms.add("eggs");
        randoms.add("bacon");
        randoms.add("tomatoes");
        randoms.add("butter");
        randoms.add("butter");

        System.out.println("The size: "+randoms.size());
        System.out.println("The elements: "+randoms);
        System.out.println("Trying to remove a random object which is not present: Hams - "+randoms.remove("hams"));
        Iterator<String> i = randoms.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }
    }
}
