import jv_stream.Gender;

public class Person {
    private final gender sex;
    private String name;
    private int age;

    Person(String name, int age, gender sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }


    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer newage) {
        age = newage;
    }

    void sleep() {
        System.out.println(this.name + " is sleepy as fuck.");
    }

    void aging() {
        Integer aging = this.age++;
        System.out.println(this.name + " turns " + age + " today.");
    }

}
