package Selenium_section17;

import org.testng.annotations.Test;

public class Java_OOP_inheritance2 extends Java_OOP_inheritance1{
    /*
    extends helps connect with an interface, can use all its methods
    when extending a class with an interface, all interface's methods are load onto the class' memory, annotation will also show up
     */

    @Test
    public void testRun(){
        doThis();
        Java_OOP_inheritance3 test_inherit = new Java_OOP_inheritance3(3); //parameterlize constructor
        System.out.println(test_inherit.increment());
        System.out.println(test_inherit.decrement());
        Java_OOP_inheritance4 test_inherit2 = new Java_OOP_inheritance4(6);
        System.out.println(test_inherit2.multiply2());
        System.out.println(test_inherit2.multiply3());
        System.out.println(test_inherit.multiply2()); //using variable i from inheritance3 instead of 4, because i from inherit3 was declared as super
    }
}
