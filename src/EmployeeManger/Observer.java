package src.EmployeeManger;

/**************************
 This is the interface for the observer class.
 It has one method, sendMessage(). Which is meant to
 alert to the UI if the Employee information changes.
 *************************/

interface Observer {
    void sendMessage();
}
