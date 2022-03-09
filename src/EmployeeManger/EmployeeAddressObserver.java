package src.EmployeeManger;

/**************************
 This is EmployeeAddressObserver class.
 It has two methods, the constructor and
 sendMessage(). Which is meant to alert to
 the UI if the Employee's address changes.
 *************************/

public class EmployeeAddressObserver implements Observer {
    public Employee emp;
    public EmployeeAddressObserverObserver(Employee emp) {
        this.emp = emp;
        this.emp.addObserver(this);
    }

    @Override
    public void sendMessage() {
        System.out.println("Employee: + " + emp.name + "'s address is updated!");
    }
}
