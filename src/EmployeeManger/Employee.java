package src.EmployeeManger;

import java.util.ArrayList;
import java.util.List;


public class Employee implements IEmployee{
    protected String name;
    protected int ID;
    protected double salary;
    protected List<Employee> subordinates;
    protected String address;
    protected boolean isCeo;
    protected  List<Observer> observers;


    // Commenting out for now to avoid errors
    //
    //
    //
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

    public void setIsCeo(boolean isCeo){
        this.isCeo = isCeo;
    }

    public boolean getIsCeo(){
        return isCeo;
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

    public double getSalary() {return CalculateSalary();}
    
    public void setSalary(double salary) {this.salary = salary;}
    
    public void setAddress(String address) {this.address = address;}
    
    public String getAddress() {
        return address;
    }

    public void addObserver(Observer observer) {observers.add(observer);}

    public void alertObserver(Observer observer) {observer.sendMessage();}


    public double CalculateSalary() {
        return salary;
    }

    public double CalculateWeeklySalary() {
        return salary;
    }


    public double CalculateMonthlySalary() {
        return salary;
    }

    public double CalculateBonusSalary(boolean isCeo) {
        return salary;
    }
    
    public String getName() { return name; }
    
    public Employee findEmpByName(String name){
        for(Employee emp : subordinates){
            if(emp.getName().equals(name)){
                return emp;
            }
        }
        return null;
    }
}



