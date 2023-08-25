public class Person_Main {
public static void main(String args[]){
    Person person1 = new Person("James Pham",26);
    Person person2 = new Person("Katherine Ng Lu", 26);

    System.out.println("The first person would be "+person1.getName()+", "+person1.getAge()+" years old.");
    System.out.println("The first person would be "+person2.getName()+", "+person2.getAge()+" years old.");
    person1.sleep();
    person2.setAge(27);
    System.out.println(person2.getAge());

    Employee em1 = new Employee("Lil Dik", 12, "lildikie@wtf.com",2511997);
    System.out.println("The oldest work force in the company is "+em1.getAge()+" years old.");
    em1.setAge(25);
    System.out.println("Actually, write his age as "+em1.getAge()+" on the paperwork.");
}
}

