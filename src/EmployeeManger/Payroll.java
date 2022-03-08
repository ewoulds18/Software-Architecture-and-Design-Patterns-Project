package src.EmployeeManger;

public class Payroll extends EmployeePayroll{
    private Employee employee;

    public Payroll(IEmployee employee){
        super(employee);
    }
    @Override
    public double CalculateSalary() {
        var sal = super.CalculateSalary();
        return sal;
    }


    @Override
    public double CalculateWeeklySalary() {
        var sal = super.CalculateSalary();
        return (sal * 7);
    }

    @Override
    public double CalculateMonthlySalary() {
        var sal = super.CalculateSalary();
        return (sal * 30);}

    @Override
    public double CalculateBonusSalary(boolean isCeo) {
        var sal = super.CalculateSalary();
        double bonus;
        if (isCeo){
            bonus = sal * 20;
        }else{
            bonus = sal * 10;
        }
        return bonus;
    }
}
