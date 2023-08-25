package JAVA_OOP;

public class Encapsulation {
    private int birthdate;
    private String name;
    public Encapsulation(String name, int birthdate){
        this.name=name;
        this.birthdate=birthdate;
    }

    public String GetName(){
        return name;
    }

    public Integer Getbirthdate(){
        return birthdate;
    }

    public void SetName(String SetName){
        this.name = SetName;
    }

    public void Setbirthdate(Integer Setbirthdate) {
        this.birthdate = Setbirthdate;
    }

}
