package Labs.lab2.prob2B;

import java.util.ArrayList;
import java.util.List;

class Order {
    private int orderNumber;
    private List<OrderLine> orderLine;

    Order(int orderNumber, double price) {
        this.orderNumber = orderNumber;
        orderLine = new ArrayList<>();
        addOrderLine(price);
    }

    public int getOrderNumber() {
        return orderNumber;
    }
    public void addOrderLine(double price){
        orderLine.add(new OrderLine(price,this));
    }
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("\nOrder Number : ").append(orderNumber);
        builder.append("\n[");
        for(int i=0;i<orderLine.size()-1;i++){
            builder.append(orderLine.get(i)).append(", ");
        }
        builder.append(orderLine.getLast()).append("]");
        return builder.toString();
    }
}
