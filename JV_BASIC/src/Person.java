public class Person {
    private String name;
    private int age;
    public Person(String name, int age){
        this.name=name;
        this.age = age;
    }


    public String getName(){
        return name;
    }
    public Integer getAge(){
        return age;
    }

    public void setAge(Integer newage) {
        age = newage;
    }

    void sleep(){
        System.out.println(this.name + " is sleepy as fuck.");
    }

    void aging(){
        System.out.println(this.name +" turns "+this.age+" today.");
    }

}
