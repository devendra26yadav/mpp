package Labs_solutions.lab4.partC;

public class Salaried extends Employee {
    private double salary;

    public Salaried(double salary) {
        this.salary = salary;
    }

    @Override
    public double calcGrossPay(int month, int year) {
        return salary;
    }
}
