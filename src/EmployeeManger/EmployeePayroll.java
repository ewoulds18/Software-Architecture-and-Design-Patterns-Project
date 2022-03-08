package src.EmployeeManger;

public abstract class EmployeePayroll implements IEmployee {
    private IEmployee employee;

    public EmployeePayroll(IEmployee employee) {
        this.employee = employee;
    }

    @Override
    public double CalculateSalary() {
        return employee.CalculateSalary();
    }


}
