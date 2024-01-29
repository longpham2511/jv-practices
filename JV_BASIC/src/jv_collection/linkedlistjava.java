package jv_collection;

import java.util.LinkedList;

public class linkedlistjava {
    public static void main(String[] args) {
        LinkedList<String> mylinkedlist = new LinkedList<>();
        mylinkedlist.addFirst("Cheese");
        mylinkedlist.addLast("Drinks");
        mylinkedlist.add("Bread");
        mylinkedlist.add("Soup");
        mylinkedlist.add(2, "Salad");
        mylinkedlist.add("Entree");
        mylinkedlist.addLast("Dessert");
        System.out.println(mylinkedlist);
        mylinkedlist.remove("Cheese");
        mylinkedlist.remove(2);
        mylinkedlist.removeLast();
        System.out.println("My list after being altered: " + mylinkedlist);
        System.out.println("The first item in the list: " + mylinkedlist.getFirst());
        System.out.println("The last item in the list: " + mylinkedlist.getClass());
    }


}
