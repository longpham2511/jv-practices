package JAVA_OOP;

public class Abstract_Main {
    public static void main(String[] args) {

        //Abstraction
        System.out.println("Abstraction");
        Abstract abobj1 = new Abtract_obj1();
        abobj1.sound();
        System.out.println();

        //Inheritance
        System.out.println("Inheritance");
        Inheritance in_og = new Inheritance();
        Inhe_obj1 in_obj = new Inhe_obj1();
        in_og.action();
        in_obj.action();

        //Encapsulation
        System.out.println("Encapsulation");
        Encapsulation student1 = new Encapsulation("Long Pham",25);
        Encapsulation student2 = new Encapsulation("Mai Khanh",25);
        System.out.println("Student list:\n"+" - " + student1.GetName()+" age: "+student1.Getbirthdate());
        System.out.println(" - " + student2.GetName()+" age: "+student2.Getbirthdate());
        student1.SetName("LP");
        student1.Setbirthdate(27);
        student2.SetName("KN");
        student2.Setbirthdate(27);
        System.out.println("Updated student list:\n"+" - " + student1.GetName()+" age: "+student1.Getbirthdate()+"\n"+" - "+student2.GetName()+" age: "+student2.Getbirthdate());
    }
}
