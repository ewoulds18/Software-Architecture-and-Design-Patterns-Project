package src.EmployeeManger;

import javafx.scene.control.TextArea;

/**************************
 This is EmployeeSalaryObserver class.
 It has two methods, the constructor and
 sendMessage(). Which is meant to alert to
 the UI if the Employee's salary changes.
 *************************/

public class EmployeeSalaryObserver implements Observer {
    public Employee emp;
    public TextArea messageLocation;
    public EmployeeSalaryObserver(Employee emp) {
        this.emp = emp;
    }

    @Override
    public void sendMessage(TextArea messageLocation) {
        String message = "Observer: " + emp.getName() + "'s salary has been updated!";
        messageLocation.setText(message);
    }
}
