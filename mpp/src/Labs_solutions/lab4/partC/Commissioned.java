package Labs_solutions.lab4.partC;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Commissioned extends Employee {
    private double commissionRate;
    private double baseSalary;
    private List<Order> orders = new ArrayList<>();

    public Commissioned(double baseSalary, double commissionRate) {
        this.baseSalary = baseSalary;
        this.commissionRate = commissionRate;
    }

    @Override
    public double calcGrossPay(int month, int year) {
        double totalOrderAmount = 0.0;

        for (Order order : orders) {
            LocalDate date = order.getOrderDate();
            if (date.getMonthValue() == month && date.getYear() == year) {
                totalOrderAmount += order.getOrderAmount();
            }
        }

        return baseSalary + (commissionRate * totalOrderAmount);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
}