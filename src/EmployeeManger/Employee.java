import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private int ID;
    private double salary;
    private List<Employee> subordinates;
    private int id;
    private String address;
    private List<Observers> Observor;

    // constructor
    public Employee(String name, int ID, double sal, String address) {
        this.name = name;
        this.ID = ID;
        this.salary = sal;
        this.address = address;
        subordinates = new ArrayList<Employee>();
    }

    public void add(Employee e) {
        subordinates.add(e);
    }

    public void remove(Employee e) {
        subordinates.remove(e);
    }

    public List<Employee> getSubordinates(){
        return subordinates;
    }

    public String toString(){
        return ("Employee :[ Name : " + name + ", ID : " + ID + ", salary :" + salary+" ]");
    }

    public String getAddress() {
        return address;
    }
}












}


