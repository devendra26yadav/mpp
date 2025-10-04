package Labs_solutions.lab4.partC;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Employee emp1 = new Hourly(25, 40);
        Employee emp2 = new Salaried(4000);
        Commissioned emp3 = new Commissioned(2000, 0.1);

        emp3.addOrder(new Order("O1", LocalDate.of(2025, 10, 1), 5000));
        emp3.addOrder(new Order("O2", LocalDate.of(2025, 10, 15), 3000));
        emp3.addOrder(new Order("O3", LocalDate.of(2025, 9, 20), 2000)); // Should be ignored

        Paycheck p1 = emp1.calcCompensation(10, 2025);
        Paycheck p2 = emp2.calcCompensation(10, 2025);
        Paycheck p3 = emp3.calcCompensation(10, 2025);

        p1.print();
        p2.print();
        p3.print();
    }
}
