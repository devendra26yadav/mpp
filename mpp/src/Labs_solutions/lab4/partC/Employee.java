package Labs_solutions.lab4.partC;

public abstract class Employee {
    private int empId;

    public void print() {

    }

    public Paycheck calcCompensation(int month, int year) {
        double grossPay = calcGrossPay(month, year);
        return new Paycheck(grossPay);
    }

    public abstract double calcGrossPay(int month, int year);
}
