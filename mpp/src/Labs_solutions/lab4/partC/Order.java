package Labs_solutions.lab4.partC;

import java.time.LocalDate;

public class Order {
    private String orderNumber;
    private LocalDate orderDate;
    private double orderAmount;

    public Order(String orderNumber, LocalDate orderDate, double orderAmount) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.orderAmount = orderAmount;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public double getOrderAmount() {
        return orderAmount;
    }
}