package src.EmployeeManger;

import java.util.List;

public class CarPool extends Employee {
    //private List<Employee> subordinates;
    //
    //
    //
    //
    //
    private String name;
    private List<Employee> passengers;

    public CarPool(String name, int ID, double sal, String address) {
        super(name, ID, sal, address);
        this.passengers = this.getSubordinates();
    }

    public void add(Employee employee) {

  /*  this is leaf node so this method
//
  is  not applicable to this class. */
//
    }
    public void remove(Employee employee) {

         /*  this is leaf node so this method

            is not applicable to this class.
        */
    }
    
    public List<Employee> getPassengers() {return passengers;}
}