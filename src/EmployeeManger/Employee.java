package src.EmployeeManger;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    protected String name;
    protected int ID;
    protected double salary;
    protected List<Employee> subordinates;
    protected String address;
    // Commenting out for now to avoid errors
    //


    // protected  List<Observers> Observor;

    // constructor
    public Employee(String name, int ID, double sal, String address) {
        this.name = name;
        this.ID = ID;
        this.salary = sal;
        this.address = address;
        this.subordinates = new ArrayList<>();
    }

    public void add(Employee e) {this.subordinates.add(e);}

    public void remove(Employee e) {
        this.subordinates.remove(e);
    }

    public List<Employee> getSubordinates(){
        return subordinates;
    }
    
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                ", salary=" + salary +
                ", address='" + address +
                ", subordinates=" + subordinates +  '\'' +
                '}' + '\n';
    }

    public double getSalary() {return salary;}
    
    public void setSalary(double salary) {this.salary = salary;}
    
    public void setAddress(String address) {this.address = address;}
    
    public String getAddress() {
        return address;
    }





}



