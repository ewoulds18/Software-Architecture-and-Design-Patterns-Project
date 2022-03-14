package src.EmployeeManger;

import javafx.scene.control.TextArea;
import java.util.ArrayList;
import java.util.List;


public class Employee implements IEmployee{
    protected String name;
    protected int ID;
    protected double salary;
    protected List<Employee> subordinates;
    protected String address;
    protected boolean isCeo;
    protected EmployeeAddressObserver addressObserver;
    protected EmployeeSalaryObserver salaryObserver;


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
        addressObserver = new EmployeeAddressObserver(this);
        salaryObserver = new EmployeeSalaryObserver(this);
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
    
    public void setSalary(double salary, TextArea messageLocation) {
        this.salary = salary;
        salaryObserver.sendMessage(messageLocation);
    }
    
    public void setAddress(String address, TextArea messageLocation) {
        this.address = address;
        addressObserver.sendMessage(messageLocation);
    }
    
    public String getAddress() {
        return address;
    }

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



