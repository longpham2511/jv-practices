package jv_collection;

import java.util.Comparator;

public class comperator_treeset_obj implements Comparator<treeset_obj> {
    public int compare(treeset_obj obj1, treeset_obj obj2) {
        if (obj1.Getrank() > obj2.Getrank()) {
            return 1;
        } else if (obj1.Getrank() < obj2.Getrank())
            return -1;
        else return 0;
    }
}

