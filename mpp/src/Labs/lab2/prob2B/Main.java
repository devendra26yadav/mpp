package Labs.lab2.prob2B;
class Order{
    private int orderNumber;
    private OrderLine orderLine;
    Order(int orderNumber){
        this.orderNumber=orderNumber;
        orderLine= new OrderLine(this);

    }
    public int getOrderNumber(){
        return orderNumber;
    }
    public OrderLine getOrderLine(){
        return orderLine;
    }
}
class OrderLine{
    private Order order;
    OrderLine(Order order){
        this.order = order;
    }
    public Order getOrder(){
        return order;
    }
}
public class Main {
    public static void main(String[] args) {
        Order order = new Order(3456);
        OrderLine orderLine = new OrderLine(order);
        System.out.println("The Order Number : "+orderLine.getOrder().getOrderNumber());
    }
}
