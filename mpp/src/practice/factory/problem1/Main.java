package practice.factory.problem1;

public class Main {
    public static void main(String[] args) {
        // Create customer
        Customer cust1 = new Customer("Alice", "C1001");

        // Create order for this customer
        Order order1 = CustomerOrderFactory.createOrder(cust1);

        // Add items to order
        CustomerOrderFactory.createItem(order1, "Laptop", "ITM101");
        CustomerOrderFactory.createItem(order1, "Mouse", "ITM102");

        // Another order
        Order order2 = CustomerOrderFactory.createOrder(cust1);
        CustomerOrderFactory.createItem(order2, "Headphones", "ITM103");

        // Print customer orders
        System.out.println("Customer: " + cust1.getName() + " (" + cust1.getCustomerId() + ")");
        for (Order order : cust1.getOrders()) {
            System.out.println(" Order ID: " + order.getOrderId());
            for (Item item : order.getItems()) {
                System.out.println("   - " + item.getName() + " [" + item.getItemCode() + "]");
            }
        }
    }
}
