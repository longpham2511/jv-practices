public class Employee extends Person{

    private String employ_email;
    private Integer employ_id;
    public Employee(String name, int age, String employ_email, int employ_id ){
        super(name,age);
        this.employ_email= employ_email;
        this.employ_id=employ_id;
    }

    @Override
    void sleep(){
        System.out.println(this.getName() + " is sleeping during office hours." );
    }

}
