package jv_stream;

public class Person {
    private final String name;
    private final int age;
    private final Gender gender;

    public Person(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getname() {
        return name;
    }

    public int getage() {
        return age;
    }

    public Gender getgender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Name = " + name
                + ", Age = " + age
                + ", Gender = " + gender + ". ";
    }
}
