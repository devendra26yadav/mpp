package Labs_solutions.lab2.prob2B;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Order order1 = new Order(3,200.45);
        order1.addOrderLine(45);

        Order order2 = new Order(4,400);
        order2.addOrderLine(300);

        Order order3 = new Order(5,500);
        order3.addOrderLine(450);

        Order order4 = new Order(6,700);
        order4.addOrderLine(650);

        List<Order> orders = new ArrayList<>(List.of(order1,order2,order3,order4));

        for(Order order : orders){
            System.out.println(order);
        }


    }
}
