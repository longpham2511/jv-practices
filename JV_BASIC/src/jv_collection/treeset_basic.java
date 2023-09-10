package jv_collection;
import java.util.Iterator;
import java.util.TreeSet;

public class treeset_basic {
    public static void main(String[] args) {
        TreeSet<String> gamelist = new TreeSet<String>();
        gamelist.add("Medal of Honor");
        gamelist.add("Call of Duty");
        gamelist.add("Batman");
        gamelist.add("Spiderman");
        gamelist.add("World War Z");
        gamelist.add("Z");
        gamelist.add("Avengers");
        System.out.println("The OG treeset: "+gamelist);
        System.out.println("The first element in alphabet order: " +gamelist.first());
        System.out.println("The first element in alphabet order: " +gamelist.last());
        TreeSet<String> newsubset = (TreeSet<String>) gamelist.subSet("Batman","Spiderman");
        System.out.println("The subset from Batman to Spiderman would be: "+newsubset);

        TreeSet<treeset_obj> consolelist = new TreeSet<treeset_obj>( new comperator_treeset_obj());
        consolelist.add(new treeset_obj("Xbox",1));
        consolelist.add(new treeset_obj("Switch",3));
        consolelist.add(new treeset_obj("Playstation",2));
        consolelist.add(new treeset_obj("PC",4));
        consolelist.add(new treeset_obj("PSP",5));
        Iterator<treeset_obj> i = consolelist.iterator();
        while (i.hasNext()){
            System.out.println(i.next().Getname());
        }





    }



}
