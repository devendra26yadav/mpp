package Streams.intermediate;

import java.util.List;

public class Customer {
    String name;
    List<String> orders;

    Customer(String name, List<String> orders) {
        this.name = name;
        this.orders = orders;
    }

    public List<String> getOrders() {
        return orders;
    }
}