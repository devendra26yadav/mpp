package practice.factory.problem1;

import java.util.ArrayList;
import java.util.List;
class Customer {
    private final String name;
    private final String customerId;
    private List<Order> orders = new ArrayList<>();

    public Customer(String name, String customerId) {
        this.name = name;
        this.customerId = customerId;
    }

    void addOrder(Order order) {
        orders.add(order);
    }

    public String getName() { return name; }
    public String getCustomerId() { return customerId; }
    public List<Order> getOrders() { return orders; }
}