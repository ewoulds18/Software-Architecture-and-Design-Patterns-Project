package src.EmployeeManger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Manager extends Employee{
    //private List<Employee> employees;
    // Class Manager extending employee


    public Manager(String name, int ID, double sal, String address){
        //  using parent constructor
        //to construct manager object
        super(name, ID, sal, address);
        this.subordinates = new ArrayList <>();
    }
    
    public void add(Employee employee) {
        this.subordinates.add(employee);
    }
    
    public void remove(Employee employee) {
        this.subordinates.remove(employee);
    }

    public List<Employee> getSubordinates() {return subordinates;}

    public String getName() {return name;}

    public double getSalary() {return salary;}
    
    @Override
    public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                ", salary=" + salary +
                ", address='" + address +
                ", subordinates=" + subordinates + '\'' +
                '}' + '\n';
    }
    
    public void print() {
        System.out.println("-------------");
        System.out.println("Name =" + getName());
        System.out.println("Salary =" + getSalary());
        System.out.println("-------------");
        Iterator<Employee> employeeIterator = subordinates.iterator();
        while (employeeIterator.hasNext()) {
            Employee employee = employeeIterator.next();
            System.out.println(employee);
        }
    }
}