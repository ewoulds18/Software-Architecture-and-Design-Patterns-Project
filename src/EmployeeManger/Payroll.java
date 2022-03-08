package src.EmployeeManger;

public class Payroll extends EmployeePayroll{
    private Employee employee;

    @Override
    public double CalculateSalary() {
        return employee.salary;
    }

    @Override
    public double CalculateWeeklySalary() {return employee.salary * 7;}

    @Override
    public double CalculateMonthlySalary() {return employee.salary * 30;}

    @Override
    public double CalculateBonusSalary() {
        boolean isCeo = employee.getIsCeo();
        double bonus;
        if (isCeo){
            bonus = employee.salary * 1.2;
        }else{
            bonus = employee.salary * 1.1;
        }
        return bonus;
    }
}
