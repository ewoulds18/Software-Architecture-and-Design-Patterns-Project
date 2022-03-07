package src.EmployeeManger;

public abstract class EmployeePayroll implements IEmployee {
    private Employee employee;

    @Override
    public double CalculateSalary(){
        return employee.CalculateSalary();
    }
}
