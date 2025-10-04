package practice.factory.problem1;

import java.util.ArrayList;
import java.util.List;

class Order {
    private static int nextOrderId = 1;
    private final int orderId;
    private List<Item> items = new ArrayList<>();

    // Package-private → only Factory can create
    Order() {
        this.orderId = nextOrderId++;
    }

    void addItem(Item item) {
        items.add(item);
    }

    public int getOrderId() { return orderId; }
    public List<Item> getItems() { return items; }
}
