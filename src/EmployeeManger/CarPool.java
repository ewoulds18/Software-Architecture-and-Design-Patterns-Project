import java.util.List;

public class CarPool implements Employee {
    //private List<Employee> subordinates;
    private String name;
    private Employee employee;
    private List<Employee> passengers;

    public CarPool(String name, double salary) {
        this.name = name;
        this.salary = salary;

    }

    public void add(Employee employee) {

  /* this is leaf node so this method

  is not applicable to this class. */

    }

    public void remove(Employee employee) {

         /* this is leaf node so this method

  is not applicable to this class. */

        }

        public Employee getPassengers(List<Employee>) {

        return employees.getSubordinates(List < Employee >);


   }
    }