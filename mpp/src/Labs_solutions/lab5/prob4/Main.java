package Labs_solutions.lab5.prob4;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Customer customer = CustOrderFactory.ctrateCustomer("Dev");
        Order order1 = CustOrderFactory.createOrder(customer,LocalDate.now());
        CustOrderFactory.addItemsToOrder(order1,"Laptop");
        CustOrderFactory.addItemsToOrder(order1,"Gold");
        CustOrderFactory.addItemsToOrder(order1,"Diamond");

        Order order2 = CustOrderFactory.createOrder(customer,LocalDate.now().plusDays(2));
        CustOrderFactory.addItemsToOrder(order2,"Rolex GMT-Master II");

        System.out.println("Printing Orders");
        for(Order order: customer.getOrders()){
            System.out.println(order);
        }
    }
}
