package src.EmployeeManger;

import javafx.scene.control.TextArea;

/**************************
 This is EmployeeAddressObserver class.
 It has two methods, the constructor and
 sendMessage(). Which is meant to alert to
 the UI if the Employee's address changes.
 *************************/

public class EmployeeAddressObserver implements Observer {
    public Employee emp;
    public EmployeeAddressObserver(Employee emp) {
        this.emp = emp;
    }

    @Override
    public void sendMessage(TextArea messageLocation) {
        String message = "Observer: " + emp.getName() + "'s address has been updated!";
        messageLocation.setText(message);
    }
}
