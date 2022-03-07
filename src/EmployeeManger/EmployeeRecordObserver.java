package src.EmployeeManger;

public class EmployeeRecordObserver implements Observer {
    public Employee emp;
    public EmployeeRecordObserver(Employee emp) {
        this.emp = emp;
        this.emp.addObserver(this);
    }

    @Override
    public void sendMessage() {
        System.out.println("Employee: + " + emp.name + " is updated!");
    }
}
