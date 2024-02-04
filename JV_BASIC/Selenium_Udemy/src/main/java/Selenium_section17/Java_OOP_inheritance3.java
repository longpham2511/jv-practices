package Selenium_section17;

import org.testng.annotations.Test;

public class Java_OOP_inheritance3 extends Java_OOP_inheritance4 {
    int a;      //class variable

    //Default constructor
    public Java_OOP_inheritance3(int i) {       //constructor variable
        super(i);  //parent class constructor is invoked - so only needed when there's a parent class
        this.a = i;         //this class variable is the same as i

    }


    public int increment(){
        a = a+1;
        return a;
    }

    public int decrement(){
        a = a-2;
        return a;
    }
}
