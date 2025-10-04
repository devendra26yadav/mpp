package Labs_solutions.lab4.partC;

public final class Paycheck {
    private final double grossPay;
    private final double FICA = 0.23;
    private final double STATE = 0.05;
    private final double LOCAL = 0.01;
    private final double MEDICARE = 0.03;
    private final double SS = 0.075;

    public Paycheck(double grossPay) {
        this.grossPay = grossPay;
    }

    public void print() {
        System.out.println("Gross Pay: " + grossPay);
        System.out.println("Net Pay: " + getNetPay());
    }

    public double getNetPay() {
        double totalTaxRate = FICA + STATE + LOCAL + MEDICARE + SS;
        return grossPay * (1 - totalTaxRate);
    }
}
