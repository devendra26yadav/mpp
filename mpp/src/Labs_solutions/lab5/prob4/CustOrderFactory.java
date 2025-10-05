package Labs_solutions.lab5.prob4;

import java.time.LocalDate;

public class CustOrderFactory {
   public static Customer ctrateCustomer(String name){
       return new Customer(name);
   }
   public static Order createOrder(Customer cust,LocalDate date){
       return Order.newOrder(cust,date);
   }
   public static void addItemsToOrder(Order order,String itemName){
       order.addItem(itemName);
   }
}
