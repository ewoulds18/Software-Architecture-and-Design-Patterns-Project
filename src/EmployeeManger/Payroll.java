package src.EmployeeManger;

public class Payroll extends EmployeePayroll{
    private Employee employee;

    public Payroll(IEmployee employee){
        super(employee);
    }
    @Override
    public double CalculateSalary() {
        return super.CalculateSalary();
    }


    @Override
    public double CalculateWeeklySalary() {
        double sal = super.CalculateSalary();
        return (sal * 40);
    }

    @Override
    public double CalculateMonthlySalary() {
        double sal = super.CalculateSalary();
        return (sal * 40 * 4);}

    @Override
    public double CalculateBonusSalary(boolean isCeo) {
        double sal = super.CalculateSalary();
        double bonus;
        if (isCeo){
            bonus = sal * 20;
        }else{
            bonus = sal * 10;
        }
        return bonus;
    }
}
