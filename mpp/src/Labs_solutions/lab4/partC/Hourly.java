package Labs_solutions.lab4.partC;

public class Hourly extends Employee {
    private double hourlyWages;
    private double hoursPerWeek;

    public Hourly(double hourlyWages, double hoursPerWeek) {
        this.hourlyWages = hourlyWages;
        this.hoursPerWeek = hoursPerWeek;
    }

    @Override
    public double calcGrossPay(int month, int year) {
        return 4 * hoursPerWeek * hourlyWages;
    }
}
