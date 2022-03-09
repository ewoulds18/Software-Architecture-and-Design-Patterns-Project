package src.EmployeeManger;

/**************************
 This is EmployeeSalaryObserver class.
 It has two methods, the constructor and
 sendMessage(). Which is meant to alert to
 the UI if the Employee's salary changes.
 *************************/

public class EmployeeSalaryObserver implements Observer {
    public Employee emp;
    public EmployeeSalaryObserver(Employee emp) {
        this.emp = emp;
        this.emp.addObserver(this);
    }

    @Override
    public void sendMessage() {
        System.out.println("Employee: + " + emp.name + "'s salary is updated!");
    }
}
