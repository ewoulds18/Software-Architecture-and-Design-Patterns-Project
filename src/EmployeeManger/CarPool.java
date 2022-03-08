package src.EmployeeManger;

import java.util.List;

public class CarPool extends Employee {
    
    private List<Employee> passengers;
    
    public CarPool(String name, int ID, double sal, String address) {
        super(name, ID, sal, address);
        passengers = this.getSubordinates();

    }

    public void add(Employee employee) {
        this.subordinates.add(employee);

    }

    public void remove(Employee employee) {
        this.subordinates.remove(employee);

    }
    
    public List<Employee> getPassengers() {return passengers;}
    
    @Override
    public String toString() {
        return "CarPool{" +
                "name='" + this.name + '\'' +
                "address= "+ this.address+
                ", passengers=" + getSubordinates() +
                '}';
    }
}